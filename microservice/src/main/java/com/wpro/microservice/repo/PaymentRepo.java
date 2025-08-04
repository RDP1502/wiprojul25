package com.wpro.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wpro.microservice.entity.Payment;


@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
