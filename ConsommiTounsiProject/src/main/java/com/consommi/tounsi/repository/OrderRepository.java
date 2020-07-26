package com.consommi.tounsi.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	@Query(value = "select * from `order` where customer_user_id = ?1", nativeQuery = true)
    Optional<List<Order>> findOrdersByCustomer(long idCustomer);
	
	@Query(value = "select * from `order` where order_id = ?1", nativeQuery = true)
    Order findOrdersByID(long idORder);
	
}

