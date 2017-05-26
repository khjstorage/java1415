package asia.ojc.treeset;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
class AddrBook2 implements Comparable{
	String name;
	String addr;
	AddrBook2(String name, String addr) {
		this.name = name;
		this.addr = addr;
	}
	public String toString() {
		return name + " / " + addr;
	}	
	@Override
	public int compareTo(Object o) {
		return this.name.compareTo(((AddrBook2)o).name);
	}
}
public class TreeSetTest3 {
	Set treeset;
	public TreeSetTest3() {
		// Comparable을구현한객체를add 하므로/TreeSet의생성자에 this를 넣지 않음
		treeset = new TreeSet();
	}
	public void test() {
		treeset.add(new AddrBook2("나길동", "서울"));
		treeset.add(new AddrBook2("하길동", "부산"));
		treeset.add(new AddrBook2("김길동", "대구"));
		treeset.add(new AddrBook2("최길동", "광주"));
		printAll();
	}
	public void printAll() {
		Iterator iter = treeset.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());
		
		treeset.forEach(new Consumer<AddrBook2>() { 
            public void accept(AddrBook2 addr) {
                System.out.println("forEach s :: " + addr );
            } 
        });			
		
		//이번에는 forEach 람다식으로...
		System.out.println("--------------------");
		treeset.forEach( (addr) -> System.out.println("람다식 Addr ::" + addr ) );        
		
        //이번에는 forEach 더블콜론 연산자로...
        System.out.println("--------------");
        treeset.forEach(System.out::println);
        
      //이번에는 forEach 더블콜론 연산자, 람다식으로...
        System.out.println("--------------");
        treeset.forEach((addr) -> System.out.println(addr)); 
	}
	public static void main(String[] args) {
		TreeSetTest3 tst = new TreeSetTest3();
		tst.test();
	}
}