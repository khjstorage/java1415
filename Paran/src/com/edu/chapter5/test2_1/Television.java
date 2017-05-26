package com.edu.chapter5.test2_1;

public class Television extends Product {
	
	private String channel;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Television() {}
	
	public Television(String productNo, String productName, int productPrice, String channel) {
		super(productNo,productName,productPrice);
		this.channel = channel;
	}
	
	@Override
	public void displayItem() {
		System.out.println(super.productNo+"|"+productName+"|"+super.productPrice+"|"+channel);		
	}
	
}
