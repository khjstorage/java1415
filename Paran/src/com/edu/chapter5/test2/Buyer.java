package com.edu.chapter5.test2;

import java.util.ArrayList;
import java.util.List;
//import java.util.UUID; //UUID(Universally unique identifier), ���� ���� �ĺ���.


public class Buyer {
	
	private List<Product> proList = null;
	private int balance;

	public Buyer() {
		this.balance = 10000000;
		proList = new ArrayList<Product>();
	}
	public List<Product> getProList() {
		return proList;
	}
	public void setProList(List<Product> proList) {
		this.proList = proList;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//�����ϱ� �޼ҵ�-void buy(Product p)
	public void buy(Product p) throws Exception {
		if(p.getProductPrice() <= this.balance) {
			//UUID uuid = UUID.randomUUID();
			this.balance -= p.getProductPrice();
			//System.out.println(uuid);
			proList.add(p);
			System.out.println("���� �����ݾ��� " + this.balance +"�� �Դϴ�.");
		}else{
			throw new Exception();
		}
	}
	//������� �޼ҵ�-void cancleBuy(Product p)
	public void cancleBuy(Product p) throws Exception{
		if(this.balance < 10000000){
			proList.remove(p);
			this.balance += p.getProductPrice();
			System.out.println("���� �����ݾ��� " + this.balance +"�� �Դϴ�.");
		}else{
			throw new Exception();
		}
	}
	//�������(��ٱ���) �޼ҵ�-summary()
	public void summary() {
		System.out.println("\r����ٱ��� ���");
		for (Product item : proList) {
			System.out.println("��ǰ��ȣ:"+item.getProductNo()+"\t�ݾ�:"+item.getProductPrice()+"��");
		}
		System.out.println("��ٱ��Ͽ� ��ҽ��ϴ�. ���� �����ݾ��� " + this.getBalance()+"�� �Դϴ�.\r");
	}
}
