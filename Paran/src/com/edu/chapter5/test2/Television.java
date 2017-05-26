package com.edu.chapter5.test2;

public class Television extends Product {
	
	private String productName;
	
	public Television(String productName, String product, int productPrice){
		super(product,productPrice);
		this.productName = productName;
	}

	public String getproductName() {
		return productName;
	}

	public void setproductName(String productName) {
		this.productName = productName;
	}

	@Override
	public void displayItem() {
		System.out.println(super.productNo+productName+super.productPrice);		
	}
}
