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
    		//Student 클래스는 Objcet 상속관계여서 다형성<< Object obj = s2
      		//하지만 obj에는 s2의 name 멤버변수 존재 x 따라서 형변환
}