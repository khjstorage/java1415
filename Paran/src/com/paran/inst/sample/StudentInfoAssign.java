package com.paran.inst.sample;

public class StudentInfoAssign {
	public static void main(String[] args){
		StudentInfo[] stsInfoArr = new StudentInfo[10];
		String[] strNameArr = {"��","��","��","��","��","��","��","��","��","��"};
		for(int i=0;i<stsInfoArr.length;i++){
			stsInfoArr[i] = new StudentInfo();
			stsInfoArr[i].setName(strNameArr[i]);
			stsInfoArr[i].setAge(i);
			stsInfoArr[i].setNo(i);
			stsInfoArr[i].setAlias(strNameArr[i]);
			stsInfoArr[i].setScore(i<5?0:55);
			
		}
		for(int i=0;i<stsInfoArr.length;i++){
			try {
				checkScore(stsInfoArr[i]);
			} catch (Exception e) {
				System.out.println(stsInfoArr[i].getName()+" "+stsInfoArr[i].getAge()+" "+ stsInfoArr[i].getNo()+" "+stsInfoArr[i].getAlias()+" "+stsInfoArr[i].getScore());
				System.out.println("����ó��");
			}
		}		
	}
	public static void checkScore(StudentInfo pObj) throws Exception{
		if ( pObj.getScore() < 51 ){
			throw new Exception();
		}
	}
}
