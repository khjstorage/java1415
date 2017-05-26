package list.linkedlist.implementation;

public class Main {

	public static void main(String[] args) {

		LinkedList numbers = new LinkedList();

		/*
		 * 
		 * numbers.~
		 * 
		 * 
		 * */

		LinkedList.ListIterator i = numbers.listIterator();

		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
}
