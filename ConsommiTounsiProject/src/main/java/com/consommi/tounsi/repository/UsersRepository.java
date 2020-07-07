package com.consommi.tounsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
