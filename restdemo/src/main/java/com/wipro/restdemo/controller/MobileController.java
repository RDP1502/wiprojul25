package com.wipro.restdemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.restdemo.dto.Mobile;
import com.wipro.restdemo.service.MobileService;

@RestController
@RequestMapping("/mobile")
public class MobileController {
	
	  @Autowired
	   private MobileService service;

	    @PostMapping
	    public String addMobile(@RequestBody Mobile mobile) {
	        service.save(mobile);
	        
	        return "Mobile added!";
	    }

	    @GetMapping
	    public List<Mobile> getAllMobiles() {
	        return service.findAll();
	    }

	    @GetMapping("/{id}")
	    public Mobile getMobile(@PathVariable int id) {
	        return service.findById(id);
	    }

	    @PutMapping("/{id}")
	    public String updateMobile(@PathVariable int id, @RequestBody Mobile mobile) {
	        service.update(id, mobile);
	        return "Mobile updated!";
	    }

	    @DeleteMapping("/{id}")
	    public String deleteMobile(@PathVariable int id, @RequestBody Mobile mobile) {
	        service.delete(id, mobile);
	        return "Mobile deleted!";
	    }
	

}
