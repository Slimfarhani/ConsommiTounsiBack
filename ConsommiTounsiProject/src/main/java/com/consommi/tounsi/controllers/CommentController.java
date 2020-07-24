package com.consommi.tounsi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consommi.tounsi.exceptions.ResourceNotFoundException;
import com.consommi.tounsi.models.Comment;
import com.consommi.tounsi.models.Post;
import com.consommi.tounsi.models.User;
import com.consommi.tounsi.repository.CommentRepository;
import com.consommi.tounsi.repository.PostRepository;
import com.consommi.tounsi.repository.UserRepository;


@RestController
@RequestMapping("/api/v1")
public class CommentController {
	
	@Autowired
	CommentRepository agent;
	@Autowired
	UserRepository agentUser;
	@Autowired
	PostRepository agentPost;
	
	@GetMapping("/comment")
	public List<Comment> getAllComments() {
		return agent.findAll();
	}
	@GetMapping("/comment/{id}")
	public ResponseEntity<Comment> getPostById(@PathVariable(value = "id") Long commentId)
			throws ResourceNotFoundException {
		Comment comment = agent.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment not found for this id :: " + commentId));
		return ResponseEntity.ok().body(comment);
	}
	@PostMapping("/comment/{postid}/{userid}")
	public Comment createComment(@Valid @RequestBody Comment comment,@PathVariable(value = "userid")
	Long userId, @PathVariable(value = "postid") Long postId) 
			throws ResourceNotFoundException {
		User user = agentUser.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Comment not found for this id :: " + userId));
		Post post = agentPost.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found for this id :: " + userId));
		comment.setUser(user);
		comment.setPost(post);
		return agent.save(comment);
	}
	
	@PutMapping("/Comment/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable(value = "id") Long commentId,
			@Valid @RequestBody Comment commentDetails) throws ResourceNotFoundException {
		Comment comment = agent.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment not found for this id :: " + commentId));

		comment.setCommentId(commentDetails.getCommentId());
		comment.setContent(commentDetails.getContent());
		comment.setPost(commentDetails.getPost());
		comment.setUser(commentDetails.getUser());
		final Comment updatedcomment = agent.save(comment);
		return ResponseEntity.ok(updatedcomment);
	}
	@DeleteMapping("/comment/{id}")
	public Map<String, Boolean> deleteComment(@PathVariable(value = "id") Long commentId)
			throws ResourceNotFoundException {
		Comment comment = agent.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment not found for this id :: " + commentId));
		agent.delete(comment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
