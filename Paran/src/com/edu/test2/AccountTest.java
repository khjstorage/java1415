package com.edu.test2;

public class AccountTest {
	public static void main(String[] args){
		AccounterHolder user1 = new AccounterHolder();
		Account objAcc = new Account(user1,"123456789", 10000);

		try {
			objAcc.outPut(11000); //���
		} catch (Exception e){
			System.out.println("����!! �ܾ�: "+objAcc.getBalance());
		}
	}
}
