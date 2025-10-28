package com.hex.ecomcs.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hex.ecomcs.dto.ProductInfoDto;
import com.hex.ecomcs.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("""
			SELECT new com.hex.ecomcs.dto.ProductInfoDto(p.id, p.title, p.price, c.name, v.name, v.city)
			FROM Product p
			JOIN Category c on p.category=c
			JOIN Vendor v on p.vendor=v
			""")
	List<ProductInfoDto> getProductWithCategoryVendorInfo(Pageable pageable);

}
