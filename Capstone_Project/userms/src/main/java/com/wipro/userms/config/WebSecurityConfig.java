package com.wipro.userms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // disable CSRF
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers("/user/login","/user/register","/user/logout/**").permitAll()// public endpoints
            		.requestMatchers(
            			    "/swagger-ui.html",
            			    "/swagger-ui/**",
            			    "/v3/api-docs/**",
            			    "/v3/api-docs.yaml"
            			).permitAll()
            		.requestMatchers("/user/update/**").hasAnyRole("USER","ADMIN")
            		.requestMatchers("/user").hasRole("ADMIN")
                .anyRequest().authenticated()// all other endpoints need JWT
            )
            .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
