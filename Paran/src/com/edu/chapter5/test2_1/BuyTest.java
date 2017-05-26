package com.edu.chapter5.test2_1;

public class BuyTest {

	public static void main(String[] args) {
		Product pcObj = new Computer("1","��ǻ��", 1000000, "cpu-z");
		Product radioObj = new Radio("2","����", 5000000, "p96k");
		Product tvObj = new Television("3","�ڷ�����", 4000000, "LG");
		Buyer buyerObj = new Buyer();

		buyerObj.readItem();	
		System.out.println("��Item ���(Read : item_list.txt)");
		for(Product itemList : buyerObj.getItemList()){
			itemList.displayItem();
		}
		
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
		
	
		
		buyerObj.writeItem();
	}
}



