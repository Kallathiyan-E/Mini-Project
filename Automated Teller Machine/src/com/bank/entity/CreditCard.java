package com.bank.entity;

public class CreditCard {

	private final long creditCardNumber;
	private int pin;
	
	public CreditCard(long creditCardNumber, int pin) {
		this.creditCardNumber = creditCardNumber;
		this.pin = pin;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(short pin) {
		this.pin = pin;
	}

	public long getCreditCardNumber() {
		return creditCardNumber;
	}
	
	public double cashBack(int amount) {
		return amount*0.01;
	}
}
