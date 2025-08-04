package com.wipro.productmgmt.repo;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.productmgmt.entity.ProductMgmt;


@Repository
public interface ProductRepo extends JpaRepository<ProductMgmt, Integer> {
	List<ProductMgmt> findByProductName(String productName);
	List<ProductMgmt> findByProductNameAndProductMakeOrderByProductNameDesc(String productName, String productMake);
	Page<ProductMgmt> findAll(Pageable p);
}
