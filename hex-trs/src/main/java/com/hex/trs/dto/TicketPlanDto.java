package com.hex.trs.dto;

import java.time.Instant;

import com.hex.trs.enums.Priority;
import com.hex.trs.enums.Status;

public record TicketPlanDto(
		
		Long ticketId,
		Priority priority,
		Status status,
		Instant createdAt,
		String customerName,
		String executiveName,
		String jobTitle,
		String planName,
		double price
		) {}
