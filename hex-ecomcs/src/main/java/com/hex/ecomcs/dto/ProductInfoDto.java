package com.hex.ecomcs.dto;

public record ProductInfoDto(
		
		Long productId,
		String productTitle,
		double price,
		String categoryName,
		String vendorName,
		String vendorCiy
		) {}
