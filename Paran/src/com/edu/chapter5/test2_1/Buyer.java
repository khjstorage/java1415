package com.edu.chapter5.test2_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

public class Buyer {

	private List<String> key = null;
	private List<Product> itemList = null;
	private int balance;
	
	public Buyer() {
		this.balance = 10000000;
		key = new ArrayList<String>();
		itemList = new ArrayList<Product>();
	}
	
	public List<String> getKey() {
		return key;
	}
	public void setKey(List<String> key) {
		this.key = key;
	}
	public List<Product> getItemList() {
		return itemList;
	}
	public void setItemList(List<Product> itemList) {
		this.itemList = itemList;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void readItem(){
		BufferedReader in = null;

		try {
			in = new BufferedReader(new FileReader("fileTest/item_list.txt"));

			String str;
			while (true) {
				str = in.readLine();
				if (str == null) {
					break;
				}

				StringTokenizer st = new StringTokenizer(str, "|");
				String[] tokenArray = new String[st.countTokens()];

				int i = 0;
				while (st.hasMoreElements()) {
					tokenArray[i++] = st.nextToken();
				}

				if (tokenArray[0].equals("1")) {
					Product comObj = new Computer();
					comObj.setProductNo(tokenArray[0]);
					((Computer) comObj).setProductName(tokenArray[1]);
					comObj.setProductPrice(Integer.parseInt(tokenArray[2]));
					((Computer) comObj).setCpu(tokenArray[3]);
					//uuid
					itemList.add(comObj);
				} else if (tokenArray[0].equals("2")) {
					Product radioObj = new Radio();
					radioObj.setProductNo(tokenArray[0]);
					((Radio) radioObj).setProductName(tokenArray[1]);
					radioObj.setProductPrice(Integer.parseInt(tokenArray[2]));
					((Radio) radioObj).setModelName(tokenArray[3]);
					//uuid
					itemList.add(radioObj);
				} else {
					Product tvObj = new Television();
					tvObj.setProductNo(tokenArray[0]);
					((Television) tvObj).setProductName(tokenArray[1]);
					tvObj.setProductPrice(Integer.parseInt(tokenArray[2]));
					((Television) tvObj).setChannel(tokenArray[3]);
					//uuid
					itemList.add(tvObj);
				}
			}
		}catch (FileNotFoundException e) {
			System.out.println("��ũ�� ���� ���Ͽ� �׼��� �Ͽ����ϴ�.");
		} catch (IOException e) {
			System.out.println("����� ������ �߻��߽��ϴ�.");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writeItem(){
		BufferedWriter out = null;
		String rLine = null;
		try {
			out = new BufferedWriter(new FileWriter("filetest/buy_item.txt"));
			for(Product productObj : getItemList()){
				if(productObj instanceof Computer){
					Computer downComputer = (Computer)productObj;
					rLine = downComputer.getProductNo()+","+downComputer.getProductName()+","+downComputer.getProductPrice()+","+downComputer.getCpu();
					out.write(rLine);
					out.newLine();
				}else if(productObj instanceof Radio){
					Radio downRadio = (Radio)productObj;
					rLine = downRadio.getProductNo()+","+downRadio.getProductName()+","+downRadio.getProductPrice()+","+downRadio.getModelName();
					out.write(rLine);
					out.newLine();
				}else if(productObj instanceof Television){
					Television downTelevision = (Television)productObj;
					rLine = downTelevision.getProductNo()+","+downTelevision.getProductName()+","+downTelevision.getProductPrice()+","+downTelevision.getChannel();
					out.write(rLine);
					out.newLine();
				}else{
					System.out.println("not 1,2,3");
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("������ ������ �� �����ϴ�.");
		} catch (IOException e) {
			System.out.println("����� ������ �߻��߽��ϴ�.");
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public String pin(){
		String pin = UUID.randomUUID().toString();
		return pin;
	}
	
	public void buy(Product p) throws Exception {
		if(p.getProductPrice() <= this.balance) {
			this.balance -= p.getProductPrice();
			itemList.add(p);
			key.add(pin());
			System.out.println("���� �����ݾ��� " + this.balance +"�� �Դϴ�.");
		}else{
			throw new Exception();
		}
	}

	public void cancleBuy(Product p) throws Exception{
		if(itemList.remove(p) == true){
			this.balance += p.getProductPrice();
			System.out.println("���� �����ݾ��� " + this.balance +"�� �Դϴ�.");
		}else{
			throw new Exception();
		}
	}

	public void summary() {
		System.out.println("\r����ٱ��� ���");
		for (Product item : itemList) {
			System.out.println("��ǰ��ȣ:"+item.getProductNo()+"\t�ݾ�:"+item.getProductPrice()+"��");
		}
		System.out.println("��ٱ��Ͽ� ��ҽ��ϴ�. ���� �����ݾ��� " + this.getBalance()+"�� �Դϴ�.\r");
	}


}
