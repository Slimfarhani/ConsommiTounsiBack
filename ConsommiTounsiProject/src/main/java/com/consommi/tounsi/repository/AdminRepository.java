package com.consommi.tounsi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Admin;
import com.consommi.tounsi.models.Customer;
import com.consommi.tounsi.models.User;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	@Query("select a from Admin a where a.UserName = :UserName and a.Password = :Password")
	Optional<Admin> findByAdminNameAndPassword(@Param("UserName")String UserName,
			@Param("Password")String Password);
}
