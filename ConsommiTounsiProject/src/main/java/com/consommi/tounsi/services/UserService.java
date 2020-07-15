package com.consommi.tounsi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consommi.tounsi.models.User;
import com.consommi.tounsi.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository agent;
	
	public List<User> getAllUsers(){
		return agent.findAll();
	}
	
	public User addOrUpdateUser(User user) {
		agent.save(user);
		return user;
	}
}
