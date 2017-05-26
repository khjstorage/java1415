package org.opentutorials.javatutorials.collection;

import java.util.ArrayList;

public class ArrayListDemoGeneric {
	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<String>();
		al.add("one");
		al.add("two");
		al.add("three");
		for(int i=0; i<al.size(); i++){
			String val = al.get(i);
			System.out.println(val);
		}

		/*제네릭을 사용하면 ArrayList 내에서 사용할 데이터 타입을 인스턴스를
        생성할 때 지정할 수 있기 때문에 데이터를 꺼낼 때(String val = al.get(i);) 
        형변환을 하지 않아도 된다.*/
	}

}