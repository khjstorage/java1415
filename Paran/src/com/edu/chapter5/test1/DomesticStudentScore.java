package com.edu.chapter5.test1;

public class DomesticStudentScore extends StudentScore {
	protected String residentNo;
	
	public String getResidentNo() {
		return residentNo;
	}

	public void setResidentNo(String residentNo) {
		this.residentNo = residentNo;
	}

	public void display(){
		super.display();
		System.out.println("ÁÖ¹Î¹øÈ£>> "+residentNo);
	}
}
