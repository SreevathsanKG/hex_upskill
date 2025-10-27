package com.hex.ecomcs.service;

import org.springframework.stereotype.Service;

import com.hex.ecomcs.model.Category;
import com.hex.ecomcs.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {

	private final CategoryRepository categoryRepository;
	
	public Category getById(Long categoryId) {
		return categoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("Categroy ID Invalid"));
	}
}
