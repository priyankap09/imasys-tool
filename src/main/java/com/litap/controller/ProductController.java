package com.litap.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.litap.entity.Product;

@RestController
public class ProductController {
	
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("getallproducts/{pageSize}/{pageNo}")
	@Cacheable(value="allprodinfo")
	public List<Product> getaAllProducts(@PathVariable int pageSize, @PathVariable int pageNo) {
		long g=7738923827L;
		
		
		int firstResult =(pageNo-1)*pageSize;
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Product.class);
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(pageSize);
		
//		Criteria criteriaCount = session.createCriteria(Product.class);
//		criteriaCount.setProjection(Projections.rowCount());
//		Long count = (Long)criteriaCount.uniqueResult();
//		
//		System.out.println("PRODUCT ROWCOUNT:"+count);
		
		List<Product> list= criteria.list();
		
		return list;
	}
	
	@RequestMapping("sortedProductList/{pageSize}/{pageNo}")
	@Cacheable(value="allprodinfo")
	public List<Product> sortedProductList(@PathVariable int pageSize, @PathVariable int pageNo) {
		long g=7738923827L;
		
		
		int firstResult =(pageNo-1)*pageSize;
		Session session = factory.openSession();
	Query query = session.createQuery("from product sort by prod_name", Product.class);
		
//		Criteria criteria = session.createCriteria();
	query.setFirstResult(firstResult);
	query.setMaxResults(pageSize);
		
//		Criteria criteriaCount = session.createCriteria(Product.class);
//		criteriaCount.setProjection(Projections.rowCount());
//		Long count = (Long)criteriaCount.uniqueResult();
//		
//		System.out.println("PRODUCT ROWCOUNT:"+count);
		
		List<Product> list= query.getResultList();
		
		return list;
	}
}
