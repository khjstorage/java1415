

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ӵ��� ����� ��� program");
		int[][] money ={
				{0,1700,4300,7700,13500,22900},
				{1700,0,3500,6900,13300,22700},
				{4300,3500,0,4300,10700,20100},
				{7700,6900,4300,0,8400,17800},
				{13500,13300,10700,8400,0,9400},
				{22900,22700,20100,17800,9400,0}
		};
		
		System.out.println("\n�� ���ú� ��ȣ");
		System.out.println("����(0) ����(1) õ��(2) \n����(3) �뱸(4) �λ�(5)");


		while(true){
			System.out.println("����� ���ù�ȣ �Է��ϰ� Enter>");
			int start = sc.nextInt();
			System.out.println("������ ���ù�ȣ �Է��ϰ� Enter>");
			int end = sc.nextInt();
			System.out.println(money[start][end]);
		}
	}
}
