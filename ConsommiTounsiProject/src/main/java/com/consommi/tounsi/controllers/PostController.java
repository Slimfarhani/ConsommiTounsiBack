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
import com.consommi.tounsi.models.Event;
import com.consommi.tounsi.models.Post;
import com.consommi.tounsi.models.Stock;
import com.consommi.tounsi.models.User;
import com.consommi.tounsi.repository.PostRepository;
import com.consommi.tounsi.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class PostController {

	@Autowired
	PostRepository agent;
	@Autowired
	UserRepository agent2;
	
	@GetMapping("/post")
	public List<Post> getAllPosts() {
		return agent.findAll();
	}
	@GetMapping("/post/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable(value = "id") Long postId)
			throws ResourceNotFoundException {
		Post post = agent.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post not found for this id :: " + postId));
		return ResponseEntity.ok().body(post);
	}

	@PostMapping("/post/{userid}")
	public Post createPost(@Valid @RequestBody Post post,@PathVariable(value = "userid")
	Long userId) throws ResourceNotFoundException {
		User user = agent2.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Post not found for this id :: " + userId));
		post.setUser(user);
		return agent.save(post);
	}

	@PutMapping("/post/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable(value = "id") Long postId,
			@Valid @RequestBody Post postDetails) throws ResourceNotFoundException {
		Post post = agent.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post not found for this id :: " + postId));

		post.setPostId(postDetails.getPostId());
		post.setTitle(postDetails.getTitle());
		post.setContent(postDetails.getContent());
		post.setUser(postDetails.getUser());
		final Post updatedpost = agent.save(post);
		return ResponseEntity.ok(updatedpost);
	}
	@DeleteMapping("/post/{id}")
	public Map<String, Boolean> deletePost(@PathVariable(value = "id") Long postId)
			throws ResourceNotFoundException {
		Post post = agent.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post not found for this id :: " + postId));
		agent.delete(post);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	@GetMapping("/postByCustomerName/{nomCustomer}")
	public ResponseEntity<List<Post>> getStockByNomProd(@PathVariable(value = "nomCustomer") String nomCustomer)
			throws ResourceNotFoundException {
		List<Post> post = agent.findByCustomerName(nomCustomer)
				.orElse(null);
		return ResponseEntity.ok().body(post);
	}
}
