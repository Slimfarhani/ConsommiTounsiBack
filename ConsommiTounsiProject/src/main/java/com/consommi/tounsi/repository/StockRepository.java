package com.consommi.tounsi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Post;
import com.consommi.tounsi.models.Product;
import com.consommi.tounsi.models.Stock;
import com.consommi.tounsi.models.User;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	@Query(value="select * from stock as s, product as p where s.product_id=p.product_id and  p.product_name like %?1% ",nativeQuery = true)
	Optional<List<Stock>>findByStockName(@Param("productName")String productName);
	@Query(value="select * from stock as s, product as p,user as u where s.product_id=p.product_id and  s.supplier_id=u.user_id and s.product_id=?1 and s.supplier_id=?2 ",nativeQuery = true)
	Optional<Stock>findByProductIdAndSuppliedId(@Param("product_id")long productid,@Param("supplier_id")long supplierid);
	@Query(value="select * from stock as s , user as u where  s.supplier_id=u.user_id and s.supplier_id=?1 ",nativeQuery = true)
	Optional<List<Stock> > findBySuppliedId(@Param("supplier_id")long supplierid);

}
