package org.opentutorials.javatutorials.interfaces.example1;
 
class Calculator {
    int left, right;
    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }
    public void sum() {
        System.out.println(this.left + this.right);
    }
    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}

/*������ A�� Calculator�� ����µ� 3������ �ʿ��ϴٰ� �Ѵٸ� �� 
�ð��� �����ϱ� ���ؼ� ���� ���� �ڵ带 �ۼ��ϴ� ������ ���� �� �� ���� ���̴�. 
3������ ������ ������ A�� Calculator Ŭ������ �ϼ��ؼ� �ΰ������. �Ʒ��� �� �ڵ��.
�ƻԽ�. ������ A�� setOprands�� �Ű������� 2�� �ް� ������ ������ B�� �� �޼ҵ尡 ���� 3���� ���� ���̶�� ������ ���̴�. 
�̰� ��ġ �����ͳ��� ���簡 �߰����� ������ ���� �Ͱ� ���� ��Ȳ�̴�. �̶����� �Ű����� ���۵ȴ�. 
��쿡 ���󼭴� ġ���ϰ� ������ �ǰ� ������Ʈ�� �ı����� ġ�ݴ´�. �̷��� ������ �ذ��ϱ� ���� ���� ���� ����� �����ϱ�? 
������ ��ȣ���� ��ü���� ����� �ϸ� �ȴ�. Ư�� �� ����� �ڵ� �ȿ��� �� �� �ִٸ� �� ���� ���̴�. 
�׷���. �������̽��� �ʿ��� �����̴�. */