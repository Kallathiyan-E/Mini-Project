package com.bank.view;

import com.bank.entity.*;

public class ATM extends Bank implements MoneyDispenserMachine,MoneyDepositMachine{		
		
	public ATM(Customer member, CreditCard card, int balance) {
		super(member, card, balance);
	}

	public int depositMoney(ATM machine,int amount) {
		machine.setBalance(amount+machine.getBalance());
		return machine.getBalance();
	}
	@Override
	public boolean checkMinimumBalance(int amount) {
		if(amount<100) {
			System.out.println("Minimum Limit Reached!Please deposit Later.");
			return true;
		}else
			return false;
	}

	@Override
	public void changePin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawMoney(ATM machine,int amount) {
		int balance = machine.getBalance();
		int fee = (int) machine.transactionFee(amount);
		if(amount+fee>balance)
			System.out.println("Insufficient Balance.Transaction Failed!");
		else if(machine.checkMinimumBalance(balance-(amount+fee))) {
			System.out.println("Charges USD :"+fee);
			System.out.println("Balance USD :"+(balance-(fee+amount)));
			machine.setBalance(balance-(fee+amount));
		}
		else {
			System.out.println("Charges USD :"+fee);
			System.out.println("Balance USD :"+(balance-(fee+amount)));
			machine.setBalance(balance-(fee+amount));
		}
		
	}

	public void swipeCard(ATM machine,int amount) {
		int balance = machine.getBalance();
		int cashBack = (int) machine.getCard().cashBack(amount);
		if(amount+cashBack>balance)
			System.out.println("Insufficient Balance.Transaction Failed!");
		else if(machine.checkMinimumBalance((balance+cashBack)-amount)) {
			System.out.println("Cashback USD :"+cashBack);
			System.out.println("Balance USD :"+(balance+cashBack-amount));
			machine.setBalance(balance+cashBack+amount);
		}
		else {
			System.out.println("CashBack USD :"+cashBack);
			System.out.println("Balance USD :"+(balance+cashBack-amount));
			machine.setBalance(balance+cashBack-amount);
		}
		
		
	}
}
