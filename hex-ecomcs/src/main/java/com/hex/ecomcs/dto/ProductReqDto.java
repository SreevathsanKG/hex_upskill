package com.hex.ecomcs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductReqDto(
		
		@NotNull
		@NotBlank
		String title,
		@NotNull
		@NotBlank
		@Size
		String description,
		@NotNull
		@Positive
		int price,
		@NotNull
		@NotBlank
		String offer
) {}
