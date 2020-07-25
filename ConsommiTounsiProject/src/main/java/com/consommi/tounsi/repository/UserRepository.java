package com.consommi.tounsi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.UserName = :UserName and u.Password = :Password")
	Optional<User> findByUserNameAndPassword(@Param("UserName")String UserName,
			@Param("Password")String Password);
	@Query(value = "select user_type from user where user_name = ?1 and password= ?2", nativeQuery = true)
    Optional<String> getUserRole(String user_name,String password);
	
	@Query("select count(u)>0 from User u where u.UserName = :UserName")
    Boolean verifUsername(@Param("UserName")String UserName);
}

