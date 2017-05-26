package asia.ojc.treeset;

import java.util.*;

class AddrBook {
	String name;
	String addr;

	AddrBook(String name, String addr) {
		this.name = name;
		this.addr = addr;
	}

	public String toString() {
		return name + " / " + addr;
	}
}

public class TreeSetTest2 implements Comparator {
	Set treeset;

	public TreeSetTest2() {
		// Comparable을구현않은객체를add 하므로/TreeSet의생성자에
		// Comparator 객체를전달하여다른비교메소드를이용하라고알림
		treeset = new TreeSet(this);
	}

	public void test() {
		treeset.add(new AddrBook("나길동", "서울"));
		treeset.add(new AddrBook("하길동", "부산"));
		treeset.add(new AddrBook("김길동", "대구"));
		treeset.add(new AddrBook("최길동", "광주"));
		printAll();
	}

	public int compare(Object o1, Object o2) {
		return (((AddrBook) o1).name).compareTo(((AddrBook) o2).name);
	}

	public void printAll() {
		Iterator iter = treeset.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());
	}

	public static void main(String[] args) {
		TreeSetTest2 tst = new TreeSetTest2();
		tst.test();
	}
}
