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
 * Ŭ������ ���� ������ ���⿡ ����.
 *
 * @version          0.82 17 Jan 2000
 * @author            Firstname Lastname
 */

class Convention{
	
}


public class CodeConvention extends Convention{
    /* Ŭ������ ���� �ּ��� �̰��� �´�. */
 
    /** classVar1�� ���� ������ ����. (���� �ּ�) */
    public static int classVar1;
 
    /** 
     * classVar2�� ���� ������(���� �ּ���)
     * �� �� �̻��� ��� �̷��� ����.(private�� ��� �������� ����.)
     */
    private static Object classVar2;
 
    /** instanceVar1�� ���� ������ ����.(���� �ּ�) */
    public Object instanceVar1;
 
    /** instanceVar2�� ���� ������ ����.(���� �ּ�) */
    protected int instanceVar2;
 
    /** instanceVar3�� ���� ������ ����.(���� �ּ�) private�̶� �� ����. */
    private Object[] instanceVar3;
 
    /** 
     * ...������ DepositCommodity�� ���� ������ ����.(���� �ּ�)...
     */
    public CodeConvention() {
        // ...�̰��� ������ �Ѵ�...
    }
 
    /**
     * ...�޼��� doSomething�� ���� ������ ����.(���� �ּ�)...
     */
    public void doSomething() {
        // ...�̰��� ������ �Ѵ�... 
    }
 
    /**
     * ...�޼��� doSomethingElse�� ���� ������ ����.(���� �ּ�)...
     * @param someParam �Ķ���ͼ���
     * @return String ���ϰ�����
     * @exception exception ���ܻ��׼���
     */
    public String doSomethingElse(Object someParam) {
		return null;
        // ...�̰��� ������ �Ѵ�... 
    }
}
