package com.wipro.restdemo.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.wipro.restdemo.dto.Mobile;

@Repository
public class MobileRepo {
	
	
	 List<Mobile> mobileList = new ArrayList<>();

	    public void save(Mobile mobile) {
	    	mobileList.add(mobile);
	    }

	    public Mobile  findById(int id) {
	    	for(Mobile m: mobileList) {
	    		if(m.getId()==id) {
	    			return m;
	    		}
	    	}
	    	return null;
			
	    }

	    public List<Mobile> findAll() {
	        return mobileList;
	    }

	    public void update(int id, Mobile mobile) {
	    	int i=0;
	    	for(Mobile m:mobileList) {
	    		if(m.getId()==mobile.getId()) {
	    			mobileList.set(i, mobile);
	    			break;
	    		}
	    	}//i++;
	    }

	    public void delete(int id, Mobile mobile) {
	    	 mobileList.removeIf(m -> m.getId() == id);
	}

}
