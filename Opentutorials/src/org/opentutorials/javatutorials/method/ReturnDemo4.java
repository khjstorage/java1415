package org.opentutorials.javatutorials.method;

public class ReturnDemo4 {


	public static String[] getMembers() {
		String[] members = { "ÃÖÁøÇõ", "ÃÖÀ¯ºó", "ÇÑÀÌ¶÷" };
		return members;
	}

	public static void main(String[] args) {
		String[] members = getMembers();
		for(int i=0; i < members.length; i++) {
			System.out.println(members[i]);
		}
	}

}
