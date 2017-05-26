package com.edu.chapter5.test2_1;

public class Computer extends Product {

	private String cpu;

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public Computer() {}
	
	public Computer(String productNo, String productName, int productPrice, String cpu) {
		super(productNo,productName,productPrice);
		this.cpu = cpu;
	}
	
	@Override
	public void displayItem() {
		System.out.println(super.productNo+"|"+productName+"|"+super.productPrice+"|"+cpu);			
	}

}
