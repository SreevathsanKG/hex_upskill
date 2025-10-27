package com.hex.trs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hex.trs.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
