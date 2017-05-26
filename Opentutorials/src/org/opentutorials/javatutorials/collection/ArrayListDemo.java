package org.opentutorials.javatutorials.collection;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		String[] arrayObj = new String[2];
		arrayObj[0] = "one";
		arrayObj[1] = "two";
		// arrayObj[2] = "three"; 오류가 발생한다.
		for(int i=0; i<arrayObj.length; i++){
			System.out.println(arrayObj[i]);
		}

		ArrayList al = new ArrayList();
		al.add("one");		//object형
		al.add("two");
		al.add("three");
		al.add(1, "gd");
		al.remove(2);
		System.out.println(al.remove(2));
		System.out.println(al);
		System.out.println(al.get(1));
		System.out.println(al.size());

		for(int i=0; i<al.size(); i++){
			System.out.println(al.get(i));
		}


		for(int i=0; i<al.size(); i++){
			String val = (String) al.get(i);
			System.out.println(val);
		}


	}

}



/*rrayList의 메소드 add의 입장에서는 인자로 어떤 형태의 값이 올지 알 수 없다. 
그렇기 때문에 모든 데이터 타입의 조상인 Object 형식으로 데이터를 받고 있다. 
이방식은 예전의 방식이다. 이제는 제네릭을 사용해야 한다*/
