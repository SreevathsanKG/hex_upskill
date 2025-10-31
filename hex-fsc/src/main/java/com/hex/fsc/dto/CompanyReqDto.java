package com.hex.fsc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CompanyReqDto(
		
		@NotBlank
		@NotNull
		String name,
		@NotBlank
		@NotNull
		String authCode
		) {}
