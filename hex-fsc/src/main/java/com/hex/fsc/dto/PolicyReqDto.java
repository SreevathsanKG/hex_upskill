package com.hex.fsc.dto;

import com.hex.fsc.enums.PolicyType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PolicyReqDto(
		
		@NotBlank
		@NotNull
		String title,
		@NotBlank
		@NotNull
		String tenure,
		@NotNull
		PolicyType type
		) {}