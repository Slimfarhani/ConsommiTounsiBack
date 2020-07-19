package com.consommi.tounsi.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Customer;
import com.consommi.tounsi.models.Supplier;
import com.consommi.tounsi.models.User;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("select c from Customer c where c.UserName = :UserName and c.Password = :Password")
	Customer findByCustomerNameAndPassword(@Param("UserName")String UserName,
			@Param("Password")String Password);

	
	
}
