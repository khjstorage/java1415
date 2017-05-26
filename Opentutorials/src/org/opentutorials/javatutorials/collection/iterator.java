package org.opentutorials.javatutorials.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;

public class iterator {
	public static void main(String[] args) {

		Collection<Integer> A = new HashSet<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);

		Iterator hs = A.iterator();
		while(hs.hasNext()){
			System.out.println(hs.next());
		}

		for(int value : A){
			System.out.println(value);
		}
		

		Collection<Integer> B = new ArrayList<Integer>();
		B.add(1);
		B.add(2);

		Iterator al = B.iterator();
		while(al.hasNext()){
			System.out.println(al.next());
		}
	}

}
