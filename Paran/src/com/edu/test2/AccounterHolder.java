package com.edu.test2;


public class AccounterHolder {
	private String name, address;
	private int cellPhone, residentNo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAdress(String adress) {
		this.address = adress;
	}
	public int getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(int cellPhone) {
		this.cellPhone = cellPhone;
	}
	public int getResidentNo() {
		return residentNo;
	}
	public void setResidentNo(int residentNo) {
		this.residentNo = residentNo;
	}
	
	public void displayInfo(){
		System.out.println(getName()
				+"\t"+getAddress()
				+"\t"+getCellPhone()
				+"\t"+getResidentNo());
	}

}

