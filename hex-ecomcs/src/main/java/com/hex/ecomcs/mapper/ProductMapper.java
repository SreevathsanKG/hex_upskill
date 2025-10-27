package com.hex.ecomcs.mapper;

import org.springframework.stereotype.Component;

import com.hex.ecomcs.dto.ProductReqDto;
import com.hex.ecomcs.enums.Offer;
import com.hex.ecomcs.model.Product;

import jakarta.validation.Valid;

@Component
public class ProductMapper {

	public Product toEntity(@Valid ProductReqDto productReqDto) {
		Product product = new Product();
		product.setTitle(productReqDto.title());
		product.setDescription(productReqDto.description());
		product.setPrice(productReqDto.price());
		Offer offer = Offer.valueOf(productReqDto.offer());
		product.setOffer(offer);
		return product;
	}
}
