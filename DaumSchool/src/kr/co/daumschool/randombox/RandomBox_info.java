package kr.co.daumschool.randombox;

public class RandomBox_info {

    private char name;
    private int number;
    private int value;
    private boolean state;
    
    public RandomBox_info(){

    }
    
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    
    public char getName() {
        return name;
    }
    public void setName(char name) {
        this.name = name;
    }


    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }


    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    

}
