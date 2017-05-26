package org.opentutorials.javatutorials.accessmodifier.inner;

public class B {
	public void _public(){
		System.out.println("public void _public()");
	}
	private void _private(){
		System.out.println("public void _private()");
	}//���� ��Ű��������
	protected void  _protected(){
		System.out.println("public void _protected()");
	}//protected �ٸ���Ű�� ���� <��Ӱ���>�̸� �������
	void _default(){
		System.out.println("public void x()");
	}//default ������Ű�� �̸鼭 ����̿�����

	void a(){
		_public();
	}
	void b(){
		_private();
	}
	void c(){
		_protected();
	}
	void d(){
		_default();
	}

}
