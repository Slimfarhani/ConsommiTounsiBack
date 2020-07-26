package com.consommi.tounsi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Post;
import com.consommi.tounsi.models.User;
import com.consommi.tounsi.models.Customer;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	

	@Query(value="select * from post as p, customer as c where p.customer_id=c.customer_id and  c.customer_name like %?1% ",nativeQuery = true)
	Optional<List<Post>>findByCustomerName(@Param("customerName")String customerName);
}
