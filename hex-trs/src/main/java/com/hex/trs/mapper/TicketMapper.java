package com.hex.trs.mapper;

import org.springframework.stereotype.Component;

import com.hex.trs.dto.TicketReqDto;
import com.hex.trs.dto.TicketRespDto;
import com.hex.trs.enums.Priority;
import com.hex.trs.model.Ticket;

import jakarta.validation.Valid;

@Component
public class TicketMapper {
	
	public Ticket toEntity(@Valid TicketReqDto ticketReqDto) {
		Ticket ticket = new Ticket();
        ticket.setSubject(ticketReqDto.subject());
        ticket.setIssues(ticketReqDto.issues());
        Priority priority =  Priority.valueOf(ticketReqDto.priority());
        ticket.setPriority(priority);
        return ticket;
	}
	
	public TicketRespDto toDto(Ticket ticket) {
        TicketRespDto dto =  new TicketRespDto(ticket.getId(),
                ticket.getStatus().toString(),
                ticket.getCreatedAt().toString()
        );
        return dto;
    }

}
