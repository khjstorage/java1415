package org.opentutorials.javatutorials.collection;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		String[] arrayObj = new String[2];
		arrayObj[0] = "one";
		arrayObj[1] = "two";
		// arrayObj[2] = "three"; ������ �߻��Ѵ�.
		for(int i=0; i<arrayObj.length; i++){
			System.out.println(arrayObj[i]);
		}

		ArrayList al = new ArrayList();
		al.add("one");		//object��
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



/*rrayList�� �޼ҵ� add�� ���忡���� ���ڷ� � ������ ���� ���� �� �� ����. 
�׷��� ������ ��� ������ Ÿ���� ������ Object �������� �����͸� �ް� �ִ�. 
�̹���� ������ ����̴�. ������ ���׸��� ����ؾ� �Ѵ�*/
