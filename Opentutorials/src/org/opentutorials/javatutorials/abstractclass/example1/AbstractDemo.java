package org.opentutorials.javatutorials.abstractclass.example1;

abstract class A{
	public abstract int b();
	//��ü�� �ִ� �޼ҵ�� abstract Ű���带 ���� �� ����.
	/*public abstract int c(){
		System.out.println("Hello");
	}*/
	//�߻� Ŭ���� ������ �߻� �޼ҵ尡 �ƴ� �޼ҵ尡 ���� �� �� �ִ�. 
	public void d(){
		System.out.println("world");
	}
}

class B extends A{

	@Override
	public int b() {
		//����
		return 0;
	}

}
/*Ŭ����B�� AŬ������ ����ϰ� �ִ�. b�޼ҵ带 �������̵� �����ʾҴ�.
�׷��� abstract b ���� �״�� ��ӵȴ�. �� BŬ������ ������� ���ؼ�
abstract �޼ҵ带 ����� ������ ���� �ȴ�.*/


public class AbstractDemo {

	public static void main  (String[] args) {
		//A obj = new A();
		B obj = new B();
		System.out.println(obj.b());
	}

}
