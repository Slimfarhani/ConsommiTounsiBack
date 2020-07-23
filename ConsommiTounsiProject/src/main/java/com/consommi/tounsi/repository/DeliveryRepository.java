package com.consommi.tounsi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.consommi.tounsi.models.Delivery;
import com.consommi.tounsi.models.Product;
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>  {

	
	@Query(value="select * from  `delivery` d , `order` o where d.delivery_id =o.delivery_id and  o.customer_user_id = ?1 ",nativeQuery = true)
	Optional <List<Delivery>> findByDeliveryByConsumer(@Param("idUser")Long idUser);

	
}
