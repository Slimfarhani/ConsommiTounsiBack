package com.consommi.tounsi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.consommi.tounsi.models.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	
	@Query("select e from Event e where e.Location = :location ")
	List<Event> findByLocation(@Param("location")String location);
	
	
	@Query("select e from Event e where e.Supplier.UserId = :SupplierID ")
	List<Event> findBySupplier(@Param("SupplierID")Long SupplierID);
	
	

	@Query("select e from Event e where e.state = :state ")
	List<Event> findByState(@Param("state")int state);

	@Query(value = "select SUM(donation_amount) from participation where event_id = ?1 ", nativeQuery = true)
	float TotalDonations(Long eventID);
	
}
