package org.opentutorials.javatutorials.generic.example2;

class StudentInfo{
    public int grade;
    StudentInfo(int grade){ this.grade = grade; }
}
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class Person{
    public Object info;
    Person(Object info){ this.info = info; }
}
public class GenericDemo {
    public static void main(String[] args) {
        Person p1 = new Person("∫Œ¿Â");
        EmployeeInfo ei = (EmployeeInfo)p1.info;
        System.out.println(ei.rank);
    }
}

/*Exception in thread "main" java.lang.ClassCastException:
java.lang.String cannot be cast to org.opentutorials.javatutorials.generic.EmployeeInfo
at org.opentutorials.javatutorials.generic.GenericDemo.main(GenericDemo.java:17)*/