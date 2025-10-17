package com.wipro.orderms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.orderms.entity.Cart;
import com.wipro.orderms.repo.CartRepo;
import com.wipro.orderms.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepo cartRepo;
	

	@Override
	public ResponseEntity save(Cart cart) {
		// TODO Auto-generated method stub
		cartRepo.save(cart);
		return new ResponseEntity<>("Cart is saved", HttpStatus.OK);
	}

	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		return cartRepo.findAll();
	}

	@Override
	public List<Cart> findByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Cart> extCart = cartRepo.findAll();
		List<Cart> userCart = null;
		for(Cart cart:extCart) {
			if(cart.getUserId()== userId) {
				userCart.add(cart);
			}
		}
		return userCart;
	}

	@Override
	public Cart findById(int id) {
		// TODO Auto-generated method stub
		Optional<Cart> extCart = cartRepo.findById(id);
		if(extCart.isPresent()) {
			return extCart.get();
		}else {
			return null;
		}
	}

	@Override
	public ResponseEntity update(int id, Cart cart) {
		// TODO Auto-generated method stub
		Cart extCart = cartRepo.findById(id).get();
		if(extCart.getId()== id) {
			extCart.setCartItems(cart.getCartItems());
			extCart.setTotalPrice(cart.getTotalPrice());
			extCart.setTotalQty(cart.getTotalQty());
			extCart.setUserId(cart.getUserId());
			cartRepo.save(extCart);
			return new ResponseEntity<>("Cart is updated", HttpStatus.OK);
		}else {
		return new ResponseEntity<>("Cart not found", HttpStatus.NO_CONTENT);
	}
		}

	@Override
	public ResponseEntity delete(int id) {
		// TODO Auto-generated method stub
		Optional<Cart> optCart = cartRepo.findById(id);
		if(optCart.isPresent()) {
			cartRepo.deleteById(id);
			return  new ResponseEntity<>("Cart is deleted", HttpStatus.OK);
		}else {
		return new ResponseEntity<>("Cart not found for delete", HttpStatus.NO_CONTENT);
	}
	}
}
