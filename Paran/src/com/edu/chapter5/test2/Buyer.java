package com.edu.chapter5.test2;

import java.util.ArrayList;
import java.util.List;
//import java.util.UUID; //UUID(Universally unique identifier), 범용 고유 식별자.


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
	
	//구매하기 메소드-void buy(Product p)
	public void buy(Product p) throws Exception {
		if(p.getProductPrice() <= this.balance) {
			//UUID uuid = UUID.randomUUID();
			this.balance -= p.getProductPrice();
			//System.out.println(uuid);
			proList.add(p);
			System.out.println("쇼핑 여유금액은 " + this.balance +"원 입니다.");
		}else{
			throw new Exception();
		}
	}
	//구매취소 메소드-void cancleBuy(Product p)
	public void cancleBuy(Product p) throws Exception{
		if(this.balance < 10000000){
			proList.remove(p);
			this.balance += p.getProductPrice();
			System.out.println("쇼핑 여유금액은 " + this.balance +"원 입니다.");
		}else{
			throw new Exception();
		}
	}
	//정보출력(장바구니) 메소드-summary()
	public void summary() {
		System.out.println("\r▼장바구니 목록");
		for (Product item : proList) {
			System.out.println("제품번호:"+item.getProductNo()+"\t금액:"+item.getProductPrice()+"원");
		}
		System.out.println("장바구니에 담았습니다. 쇼핑 여유금액은 " + this.getBalance()+"원 입니다.\r");
	}
}
