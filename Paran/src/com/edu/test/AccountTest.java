package com.edu.test;

public class AccountTest {
	public static void main(String[] args){
		
		AccountHolder objAccHolder = new AccountHolder();
		Account obj = null;
		
		objAccHolder.setName("김현진");
		objAccHolder.setAddress("파란직업전문학교");
		objAccHolder.setCellPhone("01083490706");
		objAccHolder.setresidentNo("910509-1xxxxxx");
		
		//obj.deposit(1000); NullPointerException
		
		obj = new Account(objAccHolder,1004,10000);
		obj.getPeople().display();

		AccountHolder testAccObj = obj.getPeople();
		testAccObj.display();
		
		try {
			obj.withdraw(11000);
		} catch (Exception e) {
			System.out.println(obj.getBalance());
		}
		
	}
}
