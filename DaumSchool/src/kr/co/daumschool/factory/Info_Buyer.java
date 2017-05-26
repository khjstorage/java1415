package kr.co.daumschool.factory;

import java.util.Arrays;

class Info_Buyer {

	String buyer_name;
	String buyer_id;
	int buyer_soccerball;
	int buyer_baseball;
	int buyer_basketball;
	int buyer_volleyball;
	int buyer_amount;
	int buyer_price;

	public Info_Buyer(){
	}
	public Info_Buyer(String name, String id){
		this.buyer_name = name;
		this.buyer_id = id;
	}
	
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
			
	public int getBuyer_soccerball() {
		return buyer_soccerball;
	}
	public void setBuyer_soccerball(int buyer_soccerball) {
		this.buyer_soccerball = buyer_soccerball;
	}
	public int getBuyer_baseball() {
		return buyer_baseball;
	}
	public void setBuyer_baseball(int buyer_baseball) {
		this.buyer_baseball = buyer_baseball;
	}
	public int getBuyer_basketball() {
		return buyer_basketball;
	}
	public void setBuyer_basketball(int buyer_basketball) {
		this.buyer_basketball = buyer_basketball;
	}
	public int getBuyer_volleyball() {
		return buyer_volleyball;
	}
	public void setBuyer_volleyball(int buyer_volleyball) {
		this.buyer_volleyball = buyer_volleyball;
	}
	public int getBuyer_amount() {
		return buyer_amount;
	}
	public void setBuyer_amount(int buyer_amount) {
		this.buyer_amount = buyer_amount;
	}
	public int getBuyer_price() {
		return buyer_price;
	}
	public void setBuyer_price(int buyer_price) {
		this.buyer_price = buyer_price;
	}
	
	public void show_buyer(){
		System.out.println("이    름: "+buyer_name);
		System.out.println("아 이 디: "+buyer_id);
		System.out.println("축구공: "+buyer_soccerball);
		System.out.println("야구공: "+buyer_baseball);
		System.out.println("농구공: "+buyer_basketball);
		System.out.println("배구공: "+buyer_volleyball);
		System.out.println("구 매 량: "+buyer_amount);
		System.out.println("합    계: "+buyer_price);
	}
	
	@Override
	public String toString() {
		return "Info_Buyer [buyer_name=" + buyer_name + ", buyer_id="
				+ buyer_id + ", buyer_soccerball=" + buyer_soccerball
				+ ", buyer_baseball=" + buyer_baseball + ", buyer_basketball="
				+ buyer_basketball + ", buyer_volleyball=" + buyer_volleyball
				+ ", buyer_amount=" + buyer_amount + ", buyer_price="
				+ buyer_price + "]";
	}


}
