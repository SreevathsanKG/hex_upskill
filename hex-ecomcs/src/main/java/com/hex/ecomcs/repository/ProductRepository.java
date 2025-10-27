package com.hex.ecomcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hex.ecomcs.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
