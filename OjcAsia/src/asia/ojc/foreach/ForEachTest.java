package asia.ojc.foreach;
/*
   emps.forEach((emp) -> myMethod.hello(emp));
   �ڹ�7
	for (Emp emp : emps) { 
		 myMethod.hello(emp));
    }
   �ڹ�8 �������� Collection���� ��ȸ�� �� Iterator(�ݺ���)�� ��� ��ȸ������ forEach�� ����
   Java.lang.Iterable �������̽� �޼ҵ�
   forEach�� ����Ͻ� ������ �и��Ͽ� ���밡��
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

		//�ݺ��ڸ� ��� Collection�� ��ȸ
		Iterator<Integer> iter = myList.iterator();
		while(iter.hasNext()){
			Integer i = iter.next();
			System.out.println("i ::" + i );
		}

		//������ for������
		for(int i : myList) {
			System.out.println("������ for�� i :: " + i );
		}

		//�̹����� forEach���� �̿�����. Consumer�� �ڹٿ��� �����ϴ� �Լ��� �������̽��̴�.
		//�Ķ���͸� �޾Ƽ� void�� accept �޼ҵ� ����
		myList.forEach(new Consumer<Integer>() { 
			public void accept(Integer i) {
				System.out.println("forEach i :: " + i );
			} 
		});

		//Consumer�������̽��� ������ Ŭ������ new�� forEach�� ���
		OnJConsumer action = new OnJConsumer();
		myList.forEach(action);

		//�̹����� forEach ���ٽ�����...
		myList.forEach( (i) -> System.out.println("���ٽ� i ::" + i ) );

		//�̹����� forEach �����ݷ� �����ڷ�...
		System.out.println("--------------");
		myList.forEach(System.out::println);        
	} 
}