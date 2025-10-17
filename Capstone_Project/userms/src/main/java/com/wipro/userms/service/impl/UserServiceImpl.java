package com.wipro.userms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.util.stream.Collectors;
import com.wipro.userms.dto.Token;
import com.wipro.userms.entity.User;
import com.wipro.userms.repo.UserRepo;
import com.wipro.userms.service.UserService;
import com.wipro.userms.util.AppConstant;
import com.wipro.userms.util.EncryptUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public ResponseEntity save(User user) {
		// TODO Auto-generated method stub
		if(user.getEmailId().equals("rdpawar@gmail.com")) {
			user.setUserType(0); // admin
		}else {
			user.setUserType(1);
		}
		
		user.setLoggedIn(false);
		// store encrypted password with its salt
		String passWord = user.getPassWord();
		String[] passWordSalt = EncryptUtil.getEncryptedPassword(passWord, null);
		user.setPassWord(passWordSalt[0]);
		user.setSalt(passWordSalt[1]);
		userRepo.save(user);
		return new ResponseEntity<>("User saved successfully", HttpStatus.OK);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		Optional<User> existingUser = userRepo.findById(id);
		if(existingUser.isPresent()) {
			return existingUser.get();
		}
		return null;
	}

	@Override
	public ResponseEntity update(int id, User user) {
		// TODO Auto-generated method stub
		Optional<User> extUser = userRepo.findById(id);
		if(extUser.isPresent()) {
			User updateUser = extUser.get();
			updateUser.setAddress(user.getAddress());
			updateUser.setEmailId(user.getEmailId());
			updateUser.setFirstName(user.getFirstName());
			updateUser.setLastName(user.getLastName());
			userRepo.save(updateUser);
			
			return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("User not Found", HttpStatus.NO_CONTENT);
		}
		
	}

	@Override
	public ResponseEntity delete(int id) {
		// TODO Auto-generated method stub
		Optional<User> existingUser = userRepo.findById(id);
		if(existingUser.isPresent()) {
			userRepo.deleteById(id);
			return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
		}else {
			return new ResponseEntity("User not found", HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public Token login(User user) {
		// TODO Auto-generated method stub
		User userSalt = userRepo.findByEmailId(user.getEmailId());
		String[] encryptedPassword = EncryptUtil.getEncryptedPassword(user.getPassWord(), userSalt.getSalt());
		User userData = userRepo.findByEmailIdAndPassWord(user.getEmailId(), encryptedPassword[0]);
		if(userData!=null) {
			String userId = String.valueOf(userData.getId());
			String jwtToken;
			if(userData.getUserType() == 0) {
				 jwtToken = "Bearer " + getJWTToken(userId, "ROLE_ADMIN");
			}else {
				 jwtToken = "Bearer " + getJWTToken(userId, "ROLE_USER");
			}
			
			Token token = new Token();
			token.setToken(jwtToken);
			userData.setLoggedIn(true);
			userRepo.save(userData);
			return token;
		}
		return null;
	}
	
	 @Override
	 public void logout(int userId) {
		// TODO Auto-generated method stub
		 Optional<User> user = userRepo.findById(userId);
		 User extUser = user.get();
		 extUser.setLoggedIn(false);
		 userRepo.save(extUser);
	 }
	
	 private String getJWTToken(String userId, String role) {
	        Key key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(AppConstant.SECRET));
		 	List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);

	        return Jwts.builder()
	                .setId("jwtExample")
	                .setSubject(userId)
	                .claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 600000))
	                .signWith(key)
	                .compact();
	    }

	

}
