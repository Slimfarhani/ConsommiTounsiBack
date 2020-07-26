package com.consommi.tounsi.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consommi.tounsi.models.ModelKPI;
import com.consommi.tounsi.models.ModelProductSales;

@Service
@Transactional
public class Statistics  {
	@Autowired
    EntityManagerFactory emf;
	public ModelKPI JPQLQuery()
    {	ModelKPI m_kpi= new ModelKPI();
    	List<ModelProductSales>lstProducts = new ArrayList<ModelProductSales>();
        EntityManager em = emf.createEntityManager();
        Query query;
        query = em.createQuery("Select count(s) from Supplier s");
        m_kpi.setTotalNumberOfSuppliers(Integer.parseInt(query.getSingleResult().toString()));
        System.out.println("Res count from : Supplier"+m_kpi.getTotalNumberOfSuppliers());
        em.close();
        
        EntityManager em1 = emf.createEntityManager();
        em1 = emf.createEntityManager();
        query = em1.createQuery("Select count(c) from Customer c");
        m_kpi.setTotalNumberOfCustumers(Integer.parseInt(query.getSingleResult().toString()));
        System.out.println("Res count from : Customer"+m_kpi.getTotalNumberOfCustumers());
        em1.close();
        
        EntityManager em2 = emf.createEntityManager();
        em2 = emf.createEntityManager();
        query = em2.createQuery("Select count(o) from Order o");
        m_kpi.setTotalNumberOfOrders(Integer.parseInt(query.getSingleResult().toString()));
        System.out.println("Res count from : Order"+m_kpi.getTotalNumberOfOrders());
        em2.close();
        
        EntityManager em3 = emf.createEntityManager();
        em3 = emf.createEntityManager();
        query = em3.createQuery("Select count(c) from Complaint c");
        m_kpi.setTotalNumberOfComplaints(Integer.parseInt(query.getSingleResult().toString()));
        System.out.println("Res count from : Complaint"+m_kpi.getTotalNumberOfComplaints());
        em3.close();
        
        EntityManager em4 = emf.createEntityManager();
        em4 = emf.createEntityManager();
        query = em4.createQuery("Select count(d) from Delivery d");
        m_kpi.setTotalNumberOfDeliveries(Integer.parseInt(query.getSingleResult().toString()));
        System.out.println("Res count from : Delivery"+m_kpi.getTotalNumberOfDeliveries());
        em4.close();
        
        EntityManager em5 = emf.createEntityManager();
        em5 = emf.createEntityManager();
        query = em5.createQuery("Select count(e) from Event e");
        m_kpi.setTotalNumberOfEvents(Integer.parseInt(query.getSingleResult().toString()));
        System.out.println("Res count from : Event"+m_kpi.getTotalNumberOfEvents());
        em5.close();
        
        EntityManager em6 = emf.createEntityManager();
        em6 = emf.createEntityManager();;
        query = em6.createQuery("Select sum(od.Quantity) as TQuantity,od.Product.ProductName as ProductName,s.Price as Price,od.Product.Description as Description from Order_Detail od,Stock s where s.Product.ProductId=od.Product.ProductId group by od.Product.ProductId order by TQuantity desc").setMaxResults(5);
		List<Object[]> res= query.getResultList();
        em6.close();
        
        for(int i=0;i<res.size(); i++) {
        	ModelProductSales model = new ModelProductSales();
        	model.setTQuantity((long) (res.get(i))[0]);
        	model.setProductName((res.get(i))[1].toString());
        	model.setPrice((float) (res.get(i))[2]);
        	model.setDescription((res.get(i))[3].toString());
           	System.out.println("obj 0" +model.getTQuantity());
           	System.out.println("obj 0" +model.getProductName());
           	System.out.println("obj 0" +model.getPrice());
           	System.out.println("obj 0" +model.getDescription());
        	lstProducts.add(model);
        }
        
        m_kpi.setTopSelledPoducts(lstProducts);
        System.out.println("Res count from : TEST"+lstProducts.size());
        
        return m_kpi;

    }
	

}
