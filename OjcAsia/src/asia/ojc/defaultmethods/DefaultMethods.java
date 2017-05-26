package asia.ojc.defaultmethods;

/*
 * �ڹ�8 ���ʹ� �������̽��� BODY�� ������(������) �޼ҵ带 ����� �� �ִµ�
 * �ڹ�8 default methods ��� �Ѵ�.
 * � Ŭ������ �������̽��� �����Ͽ� �����Ǿ�����(�̷��� Ŭ������ ������ �ִٰ� ����.)
 * �������̽��� � �߻� �޼ҵ带 �ϳ� �߰��ߴٰ� �ϸ� �̸� ������ ��� Ŭ������ �����ؾ� �ϴ� ���ŷ����� �ִ�.
 * (�������̽��� �̸� ������ Ŭ������ �ʹ� ���ϰ� Ŀ�ø� �Ǿ� �ִ�.)
 * �� ��� default method�� �̿��Ѵٸ� ���� ���̴�.
 */

interface OracleJavaCommunity2 {
	//default method
	 default void javaStudy() {
		System.out.println("����Ŭ�ڹ�Ŀ�´�Ƽ �ڹ�8 ����");
	}

	public void springStudy();
}

class OracleJavaCommunityEdu implements OracleJavaCommunity2 {
	public void springStudy() {
		System.out.println("����Ŭ�ڹ�Ŀ�´�Ƽ ������4 ����");
	}
	
	//javaStudy �޼ҵ� ����x
}

public class DefaultMethods {
	public static void main(String[] args) {
		OracleJavaCommunityEdu ojc = new OracleJavaCommunityEdu();

		ojc.javaStudy();    //�������̽����� ���� default method
		ojc.springStudy();
	}
}