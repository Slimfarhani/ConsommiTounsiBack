package com.consommi.tounsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Participation;
import com.consommi.tounsi.models.Post;
import com.consommi.tounsi.models.Stock;
import com.consommi.tounsi.models.User;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {

}
