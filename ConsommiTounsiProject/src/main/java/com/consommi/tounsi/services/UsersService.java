package com.consommi.tounsi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consommi.tounsi.models.Users;
import com.consommi.tounsi.repository.UsersRepository;

@Service
@Transactional
public class UsersService {

	@Autowired
	UsersRepository agent;
	
	public List<Users> getAllUsers(){
		return agent.findAll();
	}
	
	public Users addOrUpdateUser(Users user) {
		agent.save(user);
		return user;
	}
}
