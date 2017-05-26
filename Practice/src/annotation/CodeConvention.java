/*
 * @(#)CodeConvention.java        0.82 2000/1/17
 *
 * Copyright (c) 2000 Kwang Shin OH.
 * Shin Ra APT. 401-1501 KwanYang-DONG, DongAn-GU, AnYang-SI, KOREA
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Kwang Shin
 * OH ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Kwang Shin OH.
 */
 
 
package annotation;
 
 
/**
 * 클래스에 대한 설명을 여기에 쓴다.
 *
 * @version          0.82 17 Jan 2000
 * @author            Firstname Lastname
 */

class Convention{
	
}


public class CodeConvention extends Convention{
    /* 클래스의 구현 주석이 이곳에 온다. */
 
    /** classVar1에 대한 설명을 쓴다. (문서 주석) */
    public static int classVar1;
 
    /** 
     * classVar2에 대한 설명이(문서 주석이)
     * 한 줄 이상일 경우 이렇게 쓴다.(private일 경우 나오지는 않음.)
     */
    private static Object classVar2;
 
    /** instanceVar1에 대한 설명을 쓴다.(문서 주석) */
    public Object instanceVar1;
 
    /** instanceVar2에 대한 설명을 쓴다.(문서 주석) */
    protected int instanceVar2;
 
    /** instanceVar3에 대한 설명을 쓴다.(문서 주석) private이라 안 나옴. */
    private Object[] instanceVar3;
 
    /** 
     * ...생성자 DepositCommodity에 대한 설명을 쓴다.(문서 주석)...
     */
    public CodeConvention() {
        // ...이곳에 구현을 한다...
    }
 
    /**
     * ...메서드 doSomething에 대한 설명을 쓴다.(문서 주석)...
     */
    public void doSomething() {
        // ...이곳에 구현을 한다... 
    }
 
    /**
     * ...메서드 doSomethingElse에 대한 설명을 쓴다.(문서 주석)...
     * @param someParam 파라미터설명
     * @return String 리턴값설명
     * @exception exception 예외사항설명
     */
    public String doSomethingElse(Object someParam) {
		return null;
        // ...이곳에 구현을 한다... 
    }
}
