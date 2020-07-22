package com.consommi.tounsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.AdViews;

@Repository
public interface AdViewsRepository extends JpaRepository<AdViews, Long>{
	@Query("select av.UserId from AdViews av where av.AdId = :AdId")
	List<Long> findByAdId(@Param("AdId")Long AdId);
}
