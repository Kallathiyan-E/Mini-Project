package com.bank.main;

import java.util.Scanner;

import com.bank.Dao.ATMDao;
import com.bank.entity.*;
import com.bank.view.ATM;
//1111222233334444
public class ATMUI {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ATMDao bankDB = new ATMDao();
		Bank customerDetails = null;
		System.out.println("******Welcome*******");
		boolean flag=true;
		int limit=3;
		do {
			if(limit==0) {
				System.out.println("Limit Exceeded! Try again after 24 Hours.");
				flag=false;
			}
			else {
				limit--;
			System.out.print("Enter Credit Card Number:");
			long number = scan.nextLong();
			if(bankDB.validateCredit(number)) {
				customerDetails = bankDB.accountDetails(number);
				flag=false;
			}
			else
				System.out.println("Please Check the Credit Card Number.");
			}
		}while(flag);
		if(limit!=0) {
		ATM machine = new ATM(customerDetails.getMember(),customerDetails.getCard(),customerDetails.getBalance());
		int choice = 0;
		int amount =0;
		do {
			System.out.println("1->Show Balance\n2->Deposit\n"
					+ "3->Withdraw\n4->Swipe\n5->Exit");
			System.out.print("Your choice :");
			choice = scan.nextInt();
			switch(choice) {
			case 1:System.out.println("Balance USD:"+machine.getBalance());
				break;
			case 2:System.out.print("Enter Amount to deposit :");
				amount = scan.nextInt();
				System.out.println("Balance USD :"+machine.depositMoney(machine, amount));
				break;
			case 3:System.out.print("Enter Amount :");
				amount = scan.nextInt();
				machine.withdrawMoney(machine,amount);
				break;
			case 4:System.out.print("Enter Amount :");
				amount = scan.nextInt();
				machine.swipeCard(machine,amount);
				break;
			case 5:System.out.println("Thank You!");
				break;
			default:System.out.println("Please!Enter A Valid Option");
			}
		}while(choice!=5);
		}
	}

}
