package com.edu.chapter5.test2;

public class BuyTest {
	public static void main(String[] args) {

		Product pcObj = new Computer("��ǻ��","1",1000000);
		Product radioObj = new Radio("����","2",4000000);
		Product tvObj = new Television("�ڷ�����","3",5000000);
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
		
		//�����ݾ� 0�� > ���� ���� > ���ܻ�Ȳ�߻� 
		try {
			buyerObj.buy(radioObj);
		} catch (Exception e) {
			buyerObj.summary(); //<<<<<<
		} 
		
		//���� ���� ���
		try {
			buyerObj.cancleBuy(radioObj);
		} catch (Exception e) {
			System.out.println("�ݾ��ʰ� �߽��ϴ�.");
		}

		System.out.println("\r������ ���� ���");
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
		System.out.println(">>���� �� ������:"+buyerObj.getBalance()+"��");
	}
}



