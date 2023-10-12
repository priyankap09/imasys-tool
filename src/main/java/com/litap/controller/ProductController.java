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
import com.litap.service.ProductServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	ProductServiceImpl productService;
	
	
	@RequestMapping("getAllProductList/{sortOn}")
	public List<Product> getAllProductList(@PathVariable String sortOn){
		return productService.getAllProducts(sortOn);
	}
	
	@RequestMapping("getProductsList/{pageSize}/{pageNo}")
	@Cacheable(value="allprodinfo")
	public List<Product> getProductsList(@PathVariable int pageSize, @PathVariable int pageNo) {
		//long g=7738923827L;		
			
		return productService.getProductsList(pageNo, pageSize);
	}
	
	@RequestMapping("sortedProductList/{pageSize}/{pageNo}")
	@Cacheable(value="allprodinfo")
	public List<Product> sortedProductList(@PathVariable int pageSize, @PathVariable int pageNo) {
		//long g=7738923827L;
		
		return productService.getSortedProductList(pageNo, pageSize);
	}
}
