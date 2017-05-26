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

/*개발자 A가 Calculator를 만드는데 3개월이 필요하다고 한다면 그 
시간을 단축하기 위해서 위와 같은 코드를 작성하는 이유가 공감 할 수 있을 것이다. 
3개월이 지나고 개발자 A가 Calculator 클래스를 완성해서 인계해줬다. 아래는 그 코드다.
아뿔싸. 개발자 A는 setOprands의 매개변스를 2개 받고 있지만 개발자 B는 이 메소드가 변수 3개를 받을 것이라고 생각한 것이다. 
이건 마치 해저터널의 공사가 중간에서 만나지 않은 것과 같은 상황이다. 이때부터 신경전이 시작된다. 
경우에 따라서는 치열하게 다투게 되고 프로젝트는 파국으로 치닫는다. 이러한 문제를 해결하기 위한 가장 좋은 방법은 무엇일까? 
협업자 상호간에 구체적인 약속을 하면 된다. 특히 그 약속을 코드 안에서 할 수 있다면 참 좋을 것이다. 
그렇다. 인터페이스가 필요한 순간이다. */