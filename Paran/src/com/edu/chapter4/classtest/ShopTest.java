package com.edu.chapter4.classtest;

import com.edu.chapter4.products.*;

public class ShopTest {
	public static void main(String args[]){
		Note noteObj = new Note("�Ｚ","2016-06-29",500,890000,100);
		Pencil pencilObj = new Pencil("�����","2016-06-29","4B",150000,200);
		Slipper slipperObj = new Slipper("���ٽ�","2016-06-29","260cm",5000,250);
		Shop shopObj  = new Shop(noteObj,pencilObj,slipperObj);

		shopObj.getNoteObj().income(100);
		shopObj.getPencilObj().income(150);
		shopObj.getSliperObj().income(200);

		/*Note 100 �Ǹ�
		Pencil 150�� �Ǹ�
		Slipper 200�� �Ǹ�*/
		try {
			shopObj.getNoteObj().sale(100);
		} catch (Exception e) {
			shopObj.getNoteObj().output();
		}
		try {
			shopObj.getPencilObj().sale(150);
		} catch (Exception e) {
			shopObj.getPencilObj().output();
		}
		try {
			shopObj.getSliperObj().sale(200);
		} catch (Exception e) {
			shopObj.getSliperObj().output();
		}

		/*Note 101 �Ǹ�
		Pencil 201�� �Ǹ�
		Slipper 251�� �Ǹ�*/
		try {
			shopObj.getNoteObj().sale(101);
		} catch (Exception e) {
			shopObj.getNoteObj().output();
		}
		try {
			shopObj.getPencilObj().sale(201);
		} catch (Exception e) {
			shopObj.getPencilObj().output();
		}
		try {
			shopObj.getSliperObj().sale(251);
		} catch (Exception e) {
			shopObj.getSliperObj().output();
		}



	}
}
