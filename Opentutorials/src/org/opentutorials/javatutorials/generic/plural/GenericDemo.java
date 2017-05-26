package org.opentutorials.javatutorials.generic.plural;

class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class Person<T, S>{
    public T info;
    public S id;
    Person(T info, S id){ 
        this.info = info; 
        this.id = id;
    }
}
public class GenericDemo {
    public static void main(String[] args) {
    	Integer id = new Integer(1);
    	EmployeeInfo e = new EmployeeInfo(1);
        Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(new EmployeeInfo(1), id);
        System.out.println(p1.id.intValue());
    }//int = Integer Waapper Å¬·¡½º
}