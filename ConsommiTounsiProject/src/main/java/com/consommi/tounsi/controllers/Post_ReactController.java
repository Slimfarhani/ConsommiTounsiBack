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
import com.consommi.tounsi.models.Post;
import com.consommi.tounsi.models.Post_React;
import com.consommi.tounsi.models.Post_ReactId;
import com.consommi.tounsi.models.User;
import com.consommi.tounsi.repository.PostRepository;
import com.consommi.tounsi.repository.Post_ReactRepository;
import com.consommi.tounsi.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class Post_ReactController {

	@Autowired
	Post_ReactRepository agent;
	@Autowired
	PostRepository agentPost;
	@Autowired
	UserRepository agentUser;
	@GetMapping("/post_react")
	public List<Post_React> getAllPost_Reacts() {
		return agent.findAll();
	}
	@GetMapping("/post_react/{id}")
	public ResponseEntity<Post_React> getPost_ReactById(@PathVariable(value = "id") Long post_ReactId)
			throws ResourceNotFoundException {
		Post_React post_React = agent.findById(post_ReactId)
				.orElseThrow(() -> new ResourceNotFoundException("Post_React not found for this id :: " + post_ReactId));
		return ResponseEntity.ok().body(post_React);
	}

	@PostMapping("/post_react/{userid}/{postid}")
	public Post_React createPost(@Valid @RequestBody Post_React post_React,
			@PathVariable(value = "userid") Long userId,
			@PathVariable(value = "postid") Long postId) throws ResourceNotFoundException {
		User user = agentUser.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		Post post = agentPost.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found for this id :: " + postId));
		post_React.setPost(post);
		post_React.setUser(user);
		post_React.setPost_ReactId(new Post_ReactId(postId,userId));
		return agent.save(post_React);
	}

	@PutMapping("/post_react/{id}")
	public ResponseEntity<Post_React> updatePost(@PathVariable(value = "id") Long post_ReactId,
			@Valid @RequestBody Post_React post_ReactDetails) throws ResourceNotFoundException {
		Post_React post_React = agent.findById(post_ReactId)
				.orElseThrow(() -> new ResourceNotFoundException("Post_React not found for this id :: " + post_ReactId));

		post_React.setReactionType(post_ReactDetails.getReactionType());
		final Post_React updatedpost_React = agent.save(post_React);
		return ResponseEntity.ok(updatedpost_React);
	}
	@DeleteMapping("/post_react/{id}")
	public Map<String, Boolean> deletePost(@PathVariable(value = "id") Long post_ReactId)
			throws ResourceNotFoundException {
		Post_React post_React = agent.findById(post_ReactId)
				.orElseThrow(() -> new ResourceNotFoundException("Post_React not found for this id :: " + post_ReactId));
		agent.delete(post_React);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
