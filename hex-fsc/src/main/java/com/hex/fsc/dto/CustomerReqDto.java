package com.hex.fsc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerReqDto(
		
		@NotBlank
		@NotNull
		String name,
		@NotBlank
		@NotNull
		String idproof,
		@NotBlank
		@NotNull
		String authCode
		
	) {}
