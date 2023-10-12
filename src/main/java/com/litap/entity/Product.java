package com.litap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Product implements Comparable<Product>{
	
	@Id
	private int productId;	
	private String prodName, prodType, prodCategory;
	private double prodPrice;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "prod_type_id", referencedColumnName = "prodTypeId")
	private ProductType productType;
	
	
	
	public Product() {
		super();
		
	}
	public Product(int productId, String prodName, String prodType, String prodCategory, double prodPrice,
			ProductType productType) {
		super();
		this.productId = productId;
		this.prodName = prodName;
		this.prodType = prodType;
		this.prodCategory = prodCategory;
		this.prodPrice = prodPrice;
		this.productType = productType;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	public double getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	
	@Override
	public int compareTo(Product o) {
		
		return o.productId - this.productId;
	}
	
	
	
	

}
