package list.arraylist.implementation;

public class Main {

	public static void main(String[] args) {

		ArrayList numbers = new ArrayList();

		/*
		 * 
		 * numbers.~
		 * 
		 * 
		 * */
		

		ArrayList.ListIterator li = numbers.listIterator();

		while(li.hasNext()){
			int number = (int)li.next();
			if(number == 30){
				li.add(35);
			}
		}

		while(li.hasNext()){
			int number = (int)li.next();
			if(number == 40){
				li.remove();
			}
		}

		while(li.hasNext()){
			System.out.println(li.next());
		}

		while(li.hasPrevious()){
			System.out.println(li.previous());
		}

		for(int i=0; i<numbers.size(); i++){
			System.out.println(numbers.get(i));
		}
	}
}
