package com.edu.test2;

public class Account {
	private AccounterHolder objAccHolder; //������
	private String accNo;	//���¹�ȣ
	private int balance;	//�ܰ�
	
	public Account (AccounterHolder objAccHolder, String accN, int balance){
		this.accNo = accN; // ���¹�ȣ �Ҵ�
		this.balance = balance; // �ܰ� �Ҵ�
		objAccHolder.setName("ȫ�浿"); // �̸�
		objAccHolder.setAdress("��õ�� ���⵿"); //�ּ�
		objAccHolder.setResidentNo(312154); // �ֹι�ȣ
		objAccHolder.setCellPhone(0101114561); //��ȭ��ȣ
		objAccHolder.displayInfo(); // ���� ����
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

