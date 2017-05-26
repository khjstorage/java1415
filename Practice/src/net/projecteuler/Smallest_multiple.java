package net.projecteuler;


/* 12(2*2*3),18(2*3*3)

   GCM �ִ����� = 6  (2*3)
   �ִ������� ���ϴ� �����, �켱 ���μ�(�����)�� �����Ͽ� ������ ���� ���Ͽ� �����ָ� �ȴ�

   LCM �ּҰ���� = 36 (2*3*2*3) 
   �ּҰ������ ���� ���� �켱 ���μ�(�����)�� �����Ͽ� �� �� �߿��� ��� ��� �� ������ �ִ� ����� ��� ã�Ƽ� �����ָ� �ȴ�

   �� �ڿ��� A, B�� ���Ͽ� A*B = GCM*LCM �����Ѵ�.

   ����1 : 4byte �������� ����� ��� overflow�� �߻��� �� �ִ�. (���� ������ ����!)
   ����2 : Java ���̺귯�� �� BigInteger�� ����ϸ� �ִ������� ���ϴ� method�� �� ���ǵǾ��ִ�.
   ����3 : ��Ŭ���� ȣ���� (Euclidean algorithm)�� �ִ������� ���ϴ� ���


 */

public class Smallest_multiple {

	public static void main(String[] args) {
		
		int result = 0;
		int min = 2;
		int max = 20;

		// �׳� ��� ������� ������ ���������� ���ϴ� ���
		boolean is = false;
		while(!is) {
			result++;
			is = true;
			for(int i=min; i<=max; i++) {
				if(result % i != 0) {
					is = false;
					break;
				}
			}
		}


		System.out.println("�ּҰ���� : "+result);

	}
 
}
