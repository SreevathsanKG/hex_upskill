package com.hex.trs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hex.trs.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long>{

	@Query("""
			select p from Customer c 
			JOIN CustomerPlan cp on c.id=cp.customer.id 
			JOIN Plan p on cp.plan.id=p.id
			where c.id=?1
			""")
	List<Plan> getPlanByCustomer(Long customerId);
	
	@Query(nativeQuery = true , value = """
            select p.*
            from customers c
            JOIN customer_plan cp ON c.id = cp.customer_id
            JOIN plans p ON cp.plan_id = p.id
            where c.id=?1
            """)
    List<Plan> getPlansByCustomerNativeQuery(long customerId);

}
