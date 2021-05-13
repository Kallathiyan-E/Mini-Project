package com.bank.view;

public interface MoneyDepositMachine {
	public boolean checkMinimumBalance(int amount);
	public abstract void swipeCard(ATM machine,int amount);
	public int depositMoney(ATM machine,int amount);
}