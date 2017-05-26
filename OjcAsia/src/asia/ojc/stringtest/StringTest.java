package asia.ojc.stringtest;

/*== 의 경우 주소 비교이다.
String a="1234" 와 같이 스트링을 생성하는 경우 shared string pool에 같은 클래스로 관리하므로
첫번째 예문의 a와 b는 주소가 같게된다.

두번째 예문에서는 new Stirng("1234") 형태로 스트링을 생성했으므로 메모리 힙에 각각 생성되어 
주소는 다르게 나타난다.*/

public class StringTest {
	public static void main(String[] args) {
		String a="1234";    
		String b="12" + "34";
		
		if (a == b) {
			System.out.println("a == b" );			
		}
		else {
			System.out.println("a != b" );
		}
		
		String a1 = new String("1234");
		String b1 = new String("1234");
		
		if (a1 == b1) {
			System.out.println("a1 == b1" );			
		}
		else {
			System.out.println("a1 != b1" );
		}
	}
}