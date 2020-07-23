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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consommi.tounsi.exceptions.ResourceNotFoundException;
import com.consommi.tounsi.models.Comment;
import com.consommi.tounsi.models.Comment_React;
import com.consommi.tounsi.models.Comment_ReactId;
import com.consommi.tounsi.models.User;
import com.consommi.tounsi.repository.CommentRepository;
import com.consommi.tounsi.repository.Comment_ReactRepository;
import com.consommi.tounsi.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class Comment_ReactController {
	
	@Autowired
	Comment_ReactRepository agent;
	@Autowired
	UserRepository agentUser;
	@Autowired
	CommentRepository agentComment;
	
	@GetMapping("/comment_react")
	public List<Comment_React> getAllComment_Reacts() {
		return agent.findAll();
	}
	@GetMapping("/comment_react/{id}")
	public ResponseEntity<Comment_React> getComment_ReactById(@PathVariable(value = "id") Long comment_ReactId)
			throws ResourceNotFoundException {
		Comment_React comment_React = agent.findById(comment_ReactId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment_React not found for this id :: " + comment_ReactId));
		return ResponseEntity.ok().body(comment_React);
	}
	@PostMapping("/comment_react/{userid}/{commentid}")
	public Comment_React createCommentReact(@Valid @RequestBody Comment_React comment_React,
			@PathVariable(value = "userid") Long userId,
			@PathVariable(value = "commentid") Long commentId) throws ResourceNotFoundException {
		User user = agentUser.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		Comment comment = agentComment.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment not found for this id :: " + commentId));
		comment_React.setComment(comment);
		comment_React.setUser(user);
		comment_React.setComment_ReactId(new Comment_ReactId(commentId,userId));
		return agent.save(comment_React);
	}
	@DeleteMapping("/comment_react/{id}")
	public Map<String, Boolean> deleteCommentReact(@PathVariable(value = "id") Long comment_ReactId)
			throws ResourceNotFoundException {
		Comment_React comment_React = agent.findById(comment_ReactId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment_React not found for this id :: " + comment_ReactId));
		agent.delete(comment_React);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
