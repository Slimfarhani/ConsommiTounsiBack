package com.consommi.tounsi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
//	@Query("select u from Product u where  u.ProductName like '% : %nomProduit")
	@Query(value="select * from stock s, Product p where s.product_id =p.product_id and  p.product_name like %?1% ",nativeQuery = true)
	Optional <List<Product>> findByProdName(@Param("nomProd")String nomProd);
}
