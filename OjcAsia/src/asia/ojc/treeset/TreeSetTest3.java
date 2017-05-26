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
		// Comparable�������Ѱ�ü��add �ϹǷ�/TreeSet�ǻ����ڿ� this�� ���� ����
		treeset = new TreeSet();
	}
	public void test() {
		treeset.add(new AddrBook2("���浿", "����"));
		treeset.add(new AddrBook2("�ϱ浿", "�λ�"));
		treeset.add(new AddrBook2("��浿", "�뱸"));
		treeset.add(new AddrBook2("�ֱ浿", "����"));
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
		
		//�̹����� forEach ���ٽ�����...
		System.out.println("--------------------");
		treeset.forEach( (addr) -> System.out.println("���ٽ� Addr ::" + addr ) );        
		
        //�̹����� forEach �����ݷ� �����ڷ�...
        System.out.println("--------------");
        treeset.forEach(System.out::println);
        
      //�̹����� forEach �����ݷ� ������, ���ٽ�����...
        System.out.println("--------------");
        treeset.forEach((addr) -> System.out.println(addr)); 
	}
	public static void main(String[] args) {
		TreeSetTest3 tst = new TreeSetTest3();
		tst.test();
	}
}