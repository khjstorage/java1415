package com.edu.chapter4.products;

public class Pencil {
	private String manufacturer;
	private String manufacturerDate;
	private String pencilType;
	private int price;
	private int stock;
	
	public Pencil(){}
	public Pencil(String manufacturer, String manufacturerDate, String pencilType, int price, int stock){
		this.manufacturer = manufacturer;
		this.manufacturerDate = manufacturerDate;
		this.pencilType = pencilType;
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
	public String getPencilType() {
		return pencilType;
	}
	public void setPencilType(String pencilType) {
		this.pencilType = pencilType;
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
		return "Pencil [manufacturer=" + manufacturer + ", manufacturerDate=" + manufacturerDate + ", pencilType="
				+ pencilType + ", price=" + price + ", stock=" + stock + "]";
	}
	public void output(){
		System.out.println(toString());
	}
}
