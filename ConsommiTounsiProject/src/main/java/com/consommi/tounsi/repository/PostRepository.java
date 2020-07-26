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
	

	@Query(value="select * from post as p, user as u where p.user_id=u.user_id and  c.user_name like %?1% ",nativeQuery = true)
	Optional<List<Post>>findByuserName(@Param("userName")String userName);
}
