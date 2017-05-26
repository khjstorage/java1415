package com.edu.test;


public class AccountHolder {
	private String name;
	private String address;
	private String cellPhone;
	private String residentNo;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String string) {
		this.cellPhone = string;
	}

	public String getresidentNo() {
		return residentNo;
	}

	public void setresidentNo(String residentNo) {
		this.residentNo = residentNo;
	}

	public void display() {
		System.out.println(getName());
		System.out.println(getAddress());
		System.out.println(getCellPhone());
		System.out.println(getresidentNo());
	}

}
