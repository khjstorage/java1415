package com.edu.chapter5.test1;

public class ForeignStudentScore extends StudentScore {
	protected String nationality;
	
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void display(){
		super.display();
		System.out.println("±¹Àû> "+nationality);
	}
}
