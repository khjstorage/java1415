package asia.ojc.foreach;
/*
   emps.forEach((emp) -> myMethod.hello(emp));
   자바7
	for (Emp emp : emps) { 
		 myMethod.hello(emp));
    }
   자바8 이전까지 Collection등을 순회할 때 Iterator(반복자)를 얻어 순회했지만 forEach로 가능
   Java.lang.Iterable 인터페이스 메소드
   forEach로 비즈니스 로직을 분리하여 재사용가능
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.lang.Integer;

//Consumer implementation that can be reused
class OnJConsumer implements Consumer<Integer>{

	public void accept(Integer i) {
		System.out.println("Consumer impl i :: " + i);
	}
} 

public class ForEachTest { 
	public static void main(String[] args) {

		List<Integer> myList = new ArrayList<Integer>();
		for(int i=0; i<5; i++) myList.add(i);

		//반복자를 얻어 Collection을 순회
		Iterator<Integer> iter = myList.iterator();
		while(iter.hasNext()){
			Integer i = iter.next();
			System.out.println("i ::" + i );
		}

		//개선된 for문으로
		for(int i : myList) {
			System.out.println("개선된 for문 i :: " + i );
		}

		//이번에는 forEach문을 이용하자. Consumer는 자바에서 제공하는 함수형 인터페이스이다.
		//파라미터를 받아서 void형 accept 메소드 구현
		myList.forEach(new Consumer<Integer>() { 
			public void accept(Integer i) {
				System.out.println("forEach i :: " + i );
			} 
		});

		//Consumer인터페이스를 구현한 클래스를 new후 forEach에 사용
		OnJConsumer action = new OnJConsumer();
		myList.forEach(action);

		//이번에는 forEach 람다식으로...
		myList.forEach( (i) -> System.out.println("람다식 i ::" + i ) );

		//이번에는 forEach 더블콜론 연산자로...
		System.out.println("--------------");
		myList.forEach(System.out::println);        
	} 
}