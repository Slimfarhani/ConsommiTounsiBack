package com.consommi.tounsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consommi.tounsi.models.Order;

public interface OrderRepository  extends JpaRepository<Order, Long> {

}
