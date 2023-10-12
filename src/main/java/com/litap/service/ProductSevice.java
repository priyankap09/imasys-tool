package com.litap.service;

import java.util.List;

import com.litap.entity.Product;

public interface ProductSevice {
	
	public List<Product> getAllProducts(String sortOn);
	public List<Product> getProductsList(int pageNumber, int pageSize);
	public List<Product> getProductsInMRPRange(double minMRP, double maxMRP);

}
