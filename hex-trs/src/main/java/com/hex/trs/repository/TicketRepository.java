package com.hex.trs.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hex.trs.dto.TicketPlanDto;
import com.hex.trs.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

	@Query("""
			select t from Executive e
			RIGHT JOIN Ticket t on e=t.executive
			JOIN Customer c on t.customer=c
			where c.id=?1 and e IS NOT NULL
			""")
	List<Ticket> getTicketsByCustomer(Long customerId);

	@Query("""
			select new com.hex.trs.dto.TicketPlanDto(t.id, t.priority, t.status, t.createdAt, c.city, e.name, e.jobTitle, p.planName, p.price)
			from Customer c
			LEFT JOIN Ticket t on c=t.customer
			JOIN Executive e on t.executive=e
			JOIN CustomerPlan cp on c=cp.customer
			JOIN Plan p on cp.plan=p
			""")
	List<TicketPlanDto> getTicketDetailsWithPlanInfo(Pageable pageable);
	

}
