package com.consommi.tounsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Ad;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long>{

}
