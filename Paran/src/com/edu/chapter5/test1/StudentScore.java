package com.edu.chapter5.test1;

public class StudentScore implements Comparable<StudentScore>{
	protected String name;
	protected String studentNo;
	protected int korJumsu;
	protected int engJumsu;
	protected int matJumsu;
	protected int aveJumsu;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public int getKorJumsu() {
		return korJumsu;
	}

	public void setKorJumsu(int korJumsu) {
		this.korJumsu = korJumsu;
	}

	public int getEngJumsu() {
		return engJumsu;
	}

	public void setEngJumsu(int engJumsu) {
		this.engJumsu = engJumsu;
	}

	public int getMatJumsu() {
		return matJumsu;
	}

	public void setMatJumsu(int matJumsu) {
		this.matJumsu = matJumsu;
	}

	public int getAveJumsu() {
		return aveJumsu;
	}

	public int setAveJumsu(int aveJumsu) {
		return this.aveJumsu = aveJumsu;
	}

	public int average(){
		return setAveJumsu((korJumsu+engJumsu+matJumsu)/3);
	}

	public void display(){
		System.out.println("�̸�. "+name);
		System.out.println("�й�. "+studentNo);
		System.out.println("�������. "+aveJumsu);

	}

	@Override
	public int compareTo(StudentScore o) {
		if(this.aveJumsu < o.aveJumsu){
			return 1;
		}else if(this.aveJumsu > o.aveJumsu){
			return -1;
		}else {
			return 0;
		}
	}
	/*
	�������� ����						�������� ���� 
	this �� other ���� ������ ���		this �� other ���� ������ ����
	this �� other ���� ũ�� ����			this �� other ���� ũ�� ���
	this �� other �� ���ٸ� 0			this �� other �� ���ٸ� 0
	*/

//	@Override
//	public int compareTo(StudentScore o) {
//		return this.aveJumsu - o.aveJumsu; //�ڱ��ڽ��� ������ �Ǹ� �������� ����
//		return o.aveJumsu - this.aveJumsu; //�񱳴���� ������ �Ǹ� �������� ����
//	}
}


