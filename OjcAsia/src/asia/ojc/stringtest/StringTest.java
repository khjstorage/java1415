package asia.ojc.stringtest;

/*== �� ��� �ּ� ���̴�.
String a="1234" �� ���� ��Ʈ���� �����ϴ� ��� shared string pool�� ���� Ŭ������ �����ϹǷ�
ù��° ������ a�� b�� �ּҰ� ���Եȴ�.

�ι�° ���������� new Stirng("1234") ���·� ��Ʈ���� ���������Ƿ� �޸� ���� ���� �����Ǿ� 
�ּҴ� �ٸ��� ��Ÿ����.*/

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