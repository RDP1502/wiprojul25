package com.wipro.userms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wipro.notificationms.dto.UserDto;
import com.wipro.userms.dto.UserNotificationDto;
import com.wipro.userms.entity.User;
import com.wipro.userms.repo.UserRepo;
import com.wipro.userms.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${notification.service.url}")
    private String notifyUrl;

	@Override
	public String save(User user) {
		// TODO Auto-generated method stub
		 UserDto dto = new UserDto();
	     dto.setUserName(user.getUserName());
		userRepo.save(user);
		 
		return "Saved successfuly";
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		
		
		return userRepo.findAll();
	}

	@Override
	public String update(int id, User user) {
		// TODO Auto-generated method stub
		Optional<User> existing = userRepo.findById(id);
        if (existing.isPresent()) {
            User user1 = existing.get();
            
            user1.setAddress(user1.getAddress() + " updated");
            userRepo.save(user1);
            notify(user1, "Updated");
            UserDto dto = new UserDto();
            dto.setUserName(user.getUserName());
            dto.setStatus("User Updated");

            restTemplate.postForObject(notifyUrl + "/notify", dto, String.class);
            return "User updated successfully";
        }
        return "User not found";
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id).get(); 
		
		Optional<User> existing = userRepo.findById(id);
	    if (existing.isPresent()) {
	        userRepo.deleteById(id);
	        notify(existing.get(), "Deleted");
	        UserDto dto = new UserDto();
            dto.setUserName(user.getUserName());
            dto.setStatus("User Deleted");

            restTemplate.postForObject(notifyUrl + "/notify", dto, String.class);
	        return "User deleted successfully";
	    }
	    return "User not found";
	}

	private void notify(User user, String action) {
        UserNotificationDto dto = new UserNotificationDto(user, action);
        try {
            restTemplate.postForObject(notifyUrl + "/notify", dto, Void.class);
        } catch (Exception e) {
            System.out.println("Failed to notify: " + e.getMessage());
        }
    }

}
