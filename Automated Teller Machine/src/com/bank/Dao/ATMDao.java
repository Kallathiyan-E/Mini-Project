package com.bank.Dao;

import java.util.ArrayList;

import com.bank.entity.Bank;
import com.bank.entity.CreditCard;
import com.bank.entity.Customer;

public class ATMDao {
	private static ArrayList<Bank> bankDB = new ArrayList<>(); 
	static {
			
			bankDB.add(new Bank(new Customer("Modi","narendramodi@indiapm.com",23012312),new CreditCard(1111222233334444L,1077),1000000000));
			bankDB.add(new Bank(new Customer("Farmer","nomailid@india.com",10810010),new CreditCard(1111333322224444L,1000),1000));
			bankDB.add(new Bank(new Customer("Employee","employee@itcompany.com",10810010),new CreditCard(1111777799994444L,1000),100000));
		}
	public boolean validateCredit(long number) {
		for(Bank info:bankDB) {
			if(info.getCard().getCreditCardNumber()==number) {
				return true;
			}
		}
		return false;
	}
	
	public Bank accountDetails(long number) {
		for(Bank info:bankDB) {
			if(info.getCard().getCreditCardNumber()==number) {
				return info;
			}
		}
		return null;
	}
}
