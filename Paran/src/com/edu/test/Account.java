package com.edu.test;

public class Account {
	private AccountHolder people;
	private int accountNumber;
	private int balance;

	public Account(AccountHolder people,int accountNumber,int balance){
		this.people = people;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public AccountHolder getPeople() {
		return people;
	}
	public void setPeople(AccountHolder people) {
		this.people = people;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int deposit(int money){
		return balance = balance + money;
	}

	public int withdraw(int money) throws Exception{
		if(balance - money < 0){
			throw new Exception(); 
		}
		return balance = balance - money;
	}
	
	
}
