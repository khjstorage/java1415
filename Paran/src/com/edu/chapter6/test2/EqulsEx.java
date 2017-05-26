package com.edu.chapter6.test2;

class Rect{
	int width;
	int height;
	public Rect(int width, int height){
		this.width = width;
		this.height = height;
	}
//	public boolean equals(Rect p){
//		if(width*height == p.width*p.height){
//			return true;
//		}else{
//			return false;
//		}
//	}
	
}

public class EqulsEx {
	public static void main(String[] args) {
		Rect a = new Rect(2,3);
		Rect b = new Rect(3,2);
		Rect c = new Rect(2,3);
		String a1 = new String("abc");
		String b1 = new String("abc");
		
		if(a.equals(b)){
			System.out.println("a is equal to b");
		}
		if(a.equals(c)){
			System.out.println("a is equal to c");
		}
		if(b.equals(c)){
			System.out.println("b is equal to c");
		}
		System.out.println(a1.equals(b1));
	}

}
