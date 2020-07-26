package com.consommi.tounsi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Order;
import com.consommi.tounsi.models.Order_Detail;
@Repository
public interface Order_DetailRepository extends JpaRepository<Order_Detail, Long> {

	
}

