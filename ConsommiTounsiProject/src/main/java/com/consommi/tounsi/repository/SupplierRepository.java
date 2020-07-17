package com.consommi.tounsi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Supplier;
import com.consommi.tounsi.models.User;
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	@Query("select s from Supplier s where s.UserName = :UserName and s.Password = :Password")
	Supplier findBySupplierNameAndPassword(@Param("UserName")String UserName,
			@Param("Password")String Password);
}
