package com.consommi.tounsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Delivery_Man;


@Repository
public interface DeliveryManRepository extends JpaRepository< Delivery_Man, Long>{

}



