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
		// Comparable������������ü��add �ϹǷ�/TreeSet�ǻ����ڿ�
		// Comparator ��ü�������Ͽ��ٸ��񱳸޼ҵ带�̿��϶��˸�
		treeset = new TreeSet(this);
	}

	public void test() {
		treeset.add(new AddrBook("���浿", "����"));
		treeset.add(new AddrBook("�ϱ浿", "�λ�"));
		treeset.add(new AddrBook("��浿", "�뱸"));
		treeset.add(new AddrBook("�ֱ浿", "����"));
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
