package org.opentutorials.javatutorials.polymorphism;

class A{
    public String x(){return "A.x";}
}

class B extends A{
    public String x(){return "B.x";}
    public String y(){return "y";}		//없는척~
}

class B2 extends A{
    public String x(){return "B2.x";}
}

public class PolymorphismDemo1 {
    public static void main(String[] args) {
        A obj = new B();
        A obj2 = new B2();
        //B obj3 = (B) new A();			// 부모가 자식이될꺼야~ 라고하면 형변환 필요
        System.out.println(obj.x());   //오버라이딩 된 메소드가 나온다.
        System.out.println(obj2.x()); 
        //System.out.println(obj.y()); y가없음 메소드가 존재하지않음
       
    }
}