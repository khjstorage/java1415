package com.edu.chapter5.test2_1;

public class Radio extends Product {
	
	private String modelName;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Radio() {}
	
	public Radio(String productNo, String productName, int productPrice, String modelName) {
		super(productNo,productName,productPrice);
		this.modelName = modelName;
	}
	
	@Override
	public void displayItem() {
		System.out.println(super.productNo+"|"+productName+"|"+super.productPrice+"|"+modelName);		
	}
	
}
