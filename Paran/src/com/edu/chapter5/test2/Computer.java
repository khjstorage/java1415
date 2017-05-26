package com.edu.chapter5.test2;

public class Computer extends Product {

	private String productName;

	public Computer(String productName, String product, int price){
		super(product,price);
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
