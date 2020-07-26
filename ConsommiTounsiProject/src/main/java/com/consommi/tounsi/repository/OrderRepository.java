package com.consommi.tounsi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	
}

