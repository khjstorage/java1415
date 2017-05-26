package org.opentutorials.javatutorials.interfaces.example2;

public class CalculatorConsumer2 {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.setOprands(10, 20, 30);
        System.out.println(c.sum()+c.avg());
    }
}