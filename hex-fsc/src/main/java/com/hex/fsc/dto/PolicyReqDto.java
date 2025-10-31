package com.hex.fsc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PolicyReqDto(
		
		@NotBlank
		@NotNull
		String title,
		@NotBlank
		@NotNull
		String tenure,
		@NotBlank
		@NotNull
		String type
		) {}