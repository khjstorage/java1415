package com.edu.chapter4.products;

public class Note {
	private String manufacturer;
	private String manufacturerDate;
	private int totalpage;
	private int price;
	private int stock;
	
	public Note(){}
	public Note(String manufacturer, String manufacturerDate, int totalpage, int price, int stock){
		this.manufacturer = manufacturer;
		this.manufacturerDate = manufacturerDate;
		this.totalpage = totalpage;
		this.price = price;
		this.stock = stock;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getManufacturerDate() {
		return manufacturerDate;
	}
	public void setManufacturerDate(String manufacturerDate) {
		this.manufacturerDate = manufacturerDate;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public int income(int pAmount){
		return stock += pAmount;
	}
	public int sale(int pAmount) throws Exception{
		if((stock-pAmount)<0){
			throw new Exception();
		}
		return stock -= pAmount;
	}
	
	@Override
	public String toString() {
		return "Note [manufacturer=" + manufacturer + ", manufacturerDate=" + manufacturerDate + ", totalpage="
				+ totalpage + ", price=" + price + ", stock=" + stock + "]";
	}
	
	public void output(){
		System.out.println(toString());
	}
}
