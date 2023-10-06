package com.litap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProductType {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prodTypeId;
	
	private String prodType;
	private String descr;
	
	@OneToOne(mappedBy = "productType")
	private Product product;
	
	public ProductType(int prodTypeId, String prodType, String descr) {
		super();
		this.prodTypeId = prodTypeId;
		this.prodType = prodType;
		this.descr = descr;
	}
	public int getProdTypeId() {
		return prodTypeId;
	}
	public void setProdTypeId(int prodTypeId) {
		this.prodTypeId = prodTypeId;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	

}
