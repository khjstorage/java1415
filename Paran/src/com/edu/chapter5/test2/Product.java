package com.edu.chapter5.test2;

public abstract class Product {

	protected String productNo;
	protected int productPrice;
	
	public Product(String productNo, int productPrice){
		this.productNo = productNo;
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
