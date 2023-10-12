package com.litap.util;

import java.util.Comparator;

import com.litap.entity.Product;

public class ProdPriceComparator implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		
		if(o1.getProdPrice() < o2.getProdPrice())
			return 1; 
		else if(o1.getProdPrice() > o2.getProdPrice())
			return -1; 
		else
			return 0;
	}

}
