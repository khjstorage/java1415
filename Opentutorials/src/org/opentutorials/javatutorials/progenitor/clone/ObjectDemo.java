package org.opentutorials.javatutorials.progenitor.clone;
 
class Student implements Cloneable{
    String name;
    Student(String name){
        this.name = name;
    }
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    
    public String toString(){
    	return super.toString()+ this.name + this.name;
    }//toString 구현 시켜줘야함
}



class ObjectDemo {
 
    public static void main(String[] args) {
        Student s1 = new Student("egoing");
        try {
            Student s2 = (Student)s1.clone();
            System.out.println(s1);
            System.out.println(s2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
 
}