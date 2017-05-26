package com.edu.chapter5.test2;

public class BuyTest {
	public static void main(String[] args) {

		Product pcObj = new Computer("컴퓨터","1",1000000);
		Product radioObj = new Radio("라디오","2",4000000);
		Product tvObj = new Television("텔레비전","3",5000000);
		Buyer buyerObj = new Buyer();

		try {
			buyerObj.buy(pcObj);
		} catch (Exception e) {
			buyerObj.summary();
		} 
		
		try {
			buyerObj.buy(radioObj);
		} catch (Exception e) {
			buyerObj.summary();
		} 
		
		try {
			buyerObj.buy(tvObj);
		} catch (Exception e) {
			buyerObj.summary();
		} 
		
		//남은금액 0원 > 라디오 구매 > 예외상황발생 
		try {
			buyerObj.buy(radioObj);
		} catch (Exception e) {
			buyerObj.summary(); //<<<<<<
		} 
		
		//라디오 구매 취소
		try {
			buyerObj.cancleBuy(radioObj);
		} catch (Exception e) {
			System.out.println("금액초과 했습니다.");
		}

		System.out.println("\r▼최종 구매 목록");
		for(Product item : buyerObj.getProList()){
			if(item instanceof Computer){
				Computer downComObj = (Computer)item;
				downComObj.displayItem();
			}else if(item instanceof Radio){
				Radio downRadObj = (Radio)item;
				downRadObj.displayItem();
			}else{
				Television downTvObj = (Television)item;
				downTvObj.displayItem();
			}
		}
		System.out.println(">>쇼핑 후 남은돈:"+buyerObj.getBalance()+"원");
	}
}



