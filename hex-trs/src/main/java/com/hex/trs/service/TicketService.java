package com.hex.trs.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hex.trs.dto.TicketPlanDto;
import com.hex.trs.dto.TicketReqDto;
import com.hex.trs.dto.TicketRespDto;
import com.hex.trs.enums.Status;
import com.hex.trs.mapper.TicketMapper;
import com.hex.trs.model.Customer;
import com.hex.trs.model.Ticket;
import com.hex.trs.repository.TicketRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketService {
	
	private final TicketRepository ticketRepository;
	private final TicketMapper ticketMapper;
	private final CustomerService customerService;
	
	public TicketRespDto add(Long customerId, @Valid TicketReqDto ticketReqDto) {
		Customer customer = customerService.getById(customerId);
		Ticket ticket = ticketMapper.toEntity(ticketReqDto);
		ticket.setStatus(Status.OPEN);
		ticket.setCustomer(customer);
		return ticketMapper.toDto(ticketRepository.save(ticket));
	}

	public List<Ticket> getTicketsByCustomer(Long customerId) {
		return ticketRepository.getTicketsByCustomer(customerId);
	}

	public List<TicketPlanDto> getTicketDetailsWithPlanInfo(String page, String size) {
		Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
		return ticketRepository.getTicketDetailsWithPlanInfo(pageable);
	}

}
