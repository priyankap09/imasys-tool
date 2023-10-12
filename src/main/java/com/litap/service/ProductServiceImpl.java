package com.litap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litap.dao.ProductDAO;
import com.litap.entity.Product;


@Service
public class ProductServiceImpl implements ProductSevice {

	@Autowired
	ProductDAO productDAO;
	
	@Override
	public List<Product> getAllProducts(String sortOn) {
		 
		return productDAO.getAllProducts(sortOn);
	}

	@Override
	public List<Product> getProductsList(int pageNumber, int pageSize) {
		 
		return null;
	}

	@Override
	public List<Product> getProductsInMRPRange(double minMRP, double maxMRP) {
		 
		return null;
	}
	
	public  List<Product> getSortedProductList(int pageNumber, int pageSize) {
		 
		return productDAO.getSortedProductList(pageSize, pageNumber);
	}

}
