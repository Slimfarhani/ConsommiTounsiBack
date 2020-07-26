package com.consommi.tounsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query("select c from Comment c where c.Post.PostId = :postId")
	List<Comment> findByPostId(@Param("postId")Long postId);
}
