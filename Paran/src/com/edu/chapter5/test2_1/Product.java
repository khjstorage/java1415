package com.edu.chapter5.test2_1;


public abstract class Product {

	protected String productNo;
	protected int productPrice;
	protected String productName;
	
	
	public Product(){}
	
	public Product(String productNo, String productName, int productPrice){
		this.productNo = productNo;
		this.productName =  productName;
		this.productPrice = productPrice;
	}
	
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public abstract void displayItem();

}
