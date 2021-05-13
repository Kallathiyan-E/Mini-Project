package com.bank.entity;

public class Bank {

	private Customer member;
	private CreditCard card;
	private int balance;
	
	public Bank(Customer member, CreditCard card, int balance) {
		this.member = member;
		this.card = card;
		this.balance = balance;
	}

	public Customer getMember() {
		return member;
	}

	public void setMember(Customer member) {
		this.member = member;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public double transactionFee(int amount) {
		if(amount<100)
			return amount*0.02;
		else
			return amount*0.04;
	}
	
}
