package com.consommi.tounsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consommi.tounsi.models.Comment_React;
import com.consommi.tounsi.models.Comment;
import com.consommi.tounsi.models.User;


public interface Comment_ReactRepository extends JpaRepository<Comment_React, Long> {

}
