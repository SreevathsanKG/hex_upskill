package com.hex.ecomcs.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hex.ecomcs.dto.ProductInfoDto;
import com.hex.ecomcs.dto.ProductReqDto;
import com.hex.ecomcs.mapper.ProductMapper;
import com.hex.ecomcs.model.Category;
import com.hex.ecomcs.model.Product;
import com.hex.ecomcs.model.Vendor;
import com.hex.ecomcs.repository.ProductRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	private final CategoryService categoryService;
	private final VendorService vendorService;
	private final ProductMapper productMapper;
	
	public Product addProduct(Long categoryId, Long vendorId,@Valid ProductReqDto productReqDto) {
		Category category = categoryService.getById(categoryId);
		Vendor vendor = vendorService.getById(vendorId);
		Product product =  productMapper.toEntity(productReqDto);
		product.setCategory(category);
		product.setVendor(vendor);
		return productRepository.save(product);
	}

	public List<ProductInfoDto> getProductWithCategoryVendorInfo(String page,String size) {
		Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
		return productRepository.getProductWithCategoryVendorInfo(pageable);
	}
}
