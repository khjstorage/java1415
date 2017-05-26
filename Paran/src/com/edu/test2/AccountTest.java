package com.edu.test2;

public class AccountTest {
	public static void main(String[] args){
		AccounterHolder user1 = new AccounterHolder();
		Account objAcc = new Account(user1,"123456789", 10000);

		try {
			objAcc.outPut(11000); //출금
		} catch (Exception e){
			System.out.println("오류!! 잔액: "+objAcc.getBalance());
		}
	}
}
