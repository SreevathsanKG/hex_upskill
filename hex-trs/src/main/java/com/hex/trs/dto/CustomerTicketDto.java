package com.hex.trs.dto;

import com.hex.trs.enums.Priority;

public record CustomerTicketDto(
		
		Long customerId,
		String customerName,
		String city,
		Long ticketId,
		String subject,
		Priority priority
		) {

}
