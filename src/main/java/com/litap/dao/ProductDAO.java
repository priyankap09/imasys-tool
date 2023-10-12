package com.litap.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.litap.entity.Product;
import com.litap.util.ProdPriceComparator;

@Repository
public class ProductDAO {

	@Autowired
	SessionFactory factory;
	

	public List<Product> getAllProducts(String sortOn) {
		//long g=7738923827L;


		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Product.class);

		//		Criteria criteriaCount = session.createCriteria(Product.class);
		//		criteriaCount.setProjection(Projections.rowCount());
		//		Long count = (Long)criteriaCount.uniqueResult();
		//		
		//		System.out.println("PRODUCT ROWCOUNT:"+count);

		List<Product> list= criteria.list();
		
		
		if(sortOn.equalsIgnoreCase("price"))
			Collections.sort(list,new ProdPriceComparator());

		return list;
	}


	public List<Product> getSortedProductList( int pageSize,  int pageNo){

		int firstResult =(pageNo-1)*pageSize;
		Session session = factory.openSession();
		Query query = session.createQuery("from Product order by prodName", Product.class);

		//		Criteria criteria = session.createCriteria();
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

}
