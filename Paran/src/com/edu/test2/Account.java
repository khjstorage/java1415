package com.edu.test2;

public class Account {
	private AccounterHolder objAccHolder; //예금주
	private String accNo;	//계좌번호
	private int balance;	//잔고
	
	public Account (AccounterHolder objAccHolder, String accN, int balance){
		this.accNo = accN; // 계좌번호 할당
		this.balance = balance; // 잔고 할당
		objAccHolder.setName("홍길동"); // 이름
		objAccHolder.setAdress("순천시 연향동"); //주소
		objAccHolder.setResidentNo(312154); // 주민번호
		objAccHolder.setCellPhone(0101114561); //전화번호
		objAccHolder.displayInfo(); // 정보 보기
	}
	
	public AccounterHolder getObjAccHolder() {
		return objAccHolder;
	}
	public void setObjAccHolder(AccounterHolder objAccHolder) {
		this.objAccHolder = objAccHolder;
	}
	public String getAccN() {
		return accNo;
	}
	public void setAccN(String accN) {
		this.accNo = accN;
	}
	public int getBalance() {
		return balance;
	}
	public void inPut(int balance) {
		this.balance += balance;
	}
	public void outPut(int money) throws Exception{

		if( balance - money < 0 ) {
			throw new Exception();			
		}
		else
			balance = balance - money;
	}
}

