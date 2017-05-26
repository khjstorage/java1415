package org.opentutorials.javatutorials.progenitor.equals;
 
class Student{
    String name;
    Student(String name){
        this.name = name;
    }
    
    public boolean equals(Object obj) {
        Student _obj = (Student)obj;
        return name == _obj.name;
    }
}
 
class ObjectDemo {
 
    public static void main(String[] args) {
        Student s1 = new Student("egoing");
        Student s2 = new Student("egoing"); 
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
 
    }
    		//Student Ŭ������ Objcet ��Ӱ��迩�� ������<< Object obj = s2
      		//������ obj���� s2�� name ������� ���� x ���� ����ȯ
}