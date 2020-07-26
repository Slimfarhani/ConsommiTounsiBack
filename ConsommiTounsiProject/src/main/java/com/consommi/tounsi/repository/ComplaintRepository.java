package com.consommi.tounsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Complaint;

@Repository
public interface ComplaintRepository  extends JpaRepository<Complaint, Long>{

	@Query(value="select * from complaint  where  order_order_id = ?1 ",nativeQuery = true)
	List<Complaint> findByComplaintyByOrder(@Param("Order")Long Order);
	
	

}
