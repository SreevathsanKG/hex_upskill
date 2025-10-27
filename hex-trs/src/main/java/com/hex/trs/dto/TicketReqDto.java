package com.hex.trs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TicketReqDto(
		
		@NotBlank
		@NotNull
		@Size
		String subject,
		@NotBlank
		@NotNull
		String issues,
		@NotBlank
		@NotNull
		String priority
) { }
