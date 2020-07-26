package com.consommi.tounsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Ad;
import com.consommi.tounsi.models.ModelProductSales;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long>{
	
	@Query("select a from Ad a where a.Supplier.UserId = :userId")
	List<Ad> findBySupplierId(@Param("userId")Long userId);
}
