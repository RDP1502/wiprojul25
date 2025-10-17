package com.wipro.userms.config;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import com.wipro.userms.util.AppConstant;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import java.security.Key;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";
    
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String uri = request.getRequestURI();
        String servletPath = request.getServletPath();
        System.out.println("JWT Filter - Request URI: " + uri);
        System.out.println("JWT Filter - Servlet Path: " + servletPath);

        // skip login, register, logout
        if (uri.endsWith("/login") 
                || uri.endsWith("/register") 
                || uri.contains("/logout")
           ) {
            System.out.println("JWT Filter - Skipping JWT check for this endpoint.");
            chain.doFilter(request, response);
            return;
        }

        if (checkJWTToken(request)) {
            Claims claims = validateToken(request);
            if (claims.get("authorities") != null) {
                setUpSpringAuthentication(claims);
            } else {
                SecurityContextHolder.clearContext();
            }
        } else {
            System.out.println("JWT Filter - No JWT found. Clearing context.");
            SecurityContextHolder.clearContext();
        }

        chain.doFilter(request, response);
    }




    private Claims validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
        Key key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(AppConstant.SECRET));
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    private void setUpSpringAuthentication(Claims claims) {
        @SuppressWarnings("unchecked")
        List<String> authorities = (List<String>) claims.get("authorities");

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                claims.getSubject(), null,
                authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    private boolean checkJWTToken(HttpServletRequest request) {
        String authHeader = request.getHeader(HEADER);
        return authHeader != null && authHeader.startsWith(PREFIX);
    }
}
