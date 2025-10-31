package com.hex.trs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hex.trs.dto.CustomerDto;
import com.hex.trs.dto.CustomerTicketDto;
import com.hex.trs.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	

	@Query("""
			select new com.hex.trs.dto.CustomerDto(c.id, c.city, COUNT(c.id))
			from Customer c
			LEFT JOIN Ticket t on t.customer=c
			GROUP BY c.id,c.city
			""")
	List<CustomerDto> getCustomerWithTicketsCount();

	@Query("select c from Customer c where c.user.username=?1")
	Customer getByUsername(String username);

	@Query("select new com.hex.trs.dto.CustomerTicketDto(c.id, c.name, c.city, t.id, t.subject, t.priority) from Customer c  JOIN  Ticket t on t.customer=c where c.user.username=?1")
	List<CustomerTicketDto> getCustomerTicketInfo(String username);

}
