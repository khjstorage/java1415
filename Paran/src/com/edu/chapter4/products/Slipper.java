package com.edu.chapter4.products;

public class Slipper {
	private String manufacturer;
	private String manufacturerDate;
	private String sliperSize;
	private int price;
	private int stock;
	
	public Slipper(){}
	public Slipper(String manufacturer, String manufacturerDate, String sliperSize, int price, int stock){
		this.manufacturer = manufacturer;
		this.manufacturerDate = manufacturerDate;
		this.sliperSize = sliperSize;
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
	public String getSliperSize() {
		return sliperSize;
	}
	public void setSliperSize(String sliperSize) {
		this.sliperSize = sliperSize;
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
		return "Slipper [manufacturer=" + manufacturer + ", manufacturerDate=" + manufacturerDate + ", sliperSize="
				+ sliperSize + ", price=" + price + ", stock=" + stock + "]";
	}
	public void output(){
		System.out.println(toString());
	}
}
