package com.consommi.tounsi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
//	@Query("select u from Product u where  u.ProductName like '% : %nomProduit")
	@Query(value="select * from Product where product_name like %?1% ",nativeQuery = true)
	Optional<Product> findByProdName(@Param("nomProd")String nomProd);
}
