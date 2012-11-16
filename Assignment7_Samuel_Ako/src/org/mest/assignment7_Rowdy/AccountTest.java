package org.mest.assignment7_Rowdy;

public class AccountTest {

	public static void main (String args[]) {
		
		//instantiating all account types
		CheckingAccount checkAc = new CheckingAccount("My Checking Account");
		SavingsAccount saveAc   = new SavingsAccount("My Savings Account");
		MoneyMarket moneyAc     = new MoneyMarket("My Money Market Account");
		
		//displaying accounts
		System.out.println(saveAc.toString());
		System.out.println();
		System.out.println(moneyAc.toString());
		System.out.println();
		System.out.println(checkAc.toString());
		
		
		//Depositing into all three accounts
		System.out.println("Depositing into all three accounts");
		System.out.println("new balance for checking : "+ checkAc.deposit(500));
		System.out.println("new balance for savings : "+ saveAc.deposit(500));
		System.out.println("new balance for money market : "+ moneyAc.deposit(500));
		
		//inquiring from all three accounts
		System.out.println("\n");
		System.out.println("calling method inquire from all three accounts");
		System.out.println(checkAc.inquiry());
		System.out.println(saveAc.inquiry());
		System.out.println(moneyAc.inquiry());
		
		
		//withdrawing from savings account
		System.out.println("\n");
		System.out.println("withdrawing from savings account");
		System.out.println(saveAc.withdraw(400));
		
		
		//calculating interest in savings
		System.out.println("\n");
		System.out.println("Calculating interest in savings account");
		System.out.println(saveAc.calculateInterest());
		
		//withdrawing from money market below and above 500
		System.out.println("\n");
		System.out.println("withdrawing from money market below and above 500");
		System.out.println("Withdrawing 200 : "+ moneyAc.withdraw(200));
		moneyAc.deposit(700);
		System.out.println("Withdrawing 600 : "+ moneyAc.withdraw(600));
		System.out.println("Withdrawing 30000 : "+ moneyAc.withdraw(30000));
		
		
		//calculating interest on money market
		System.out.println("\n");
		System.out.println("calculating interest on money market");
		System.out.println("new balance : "+ moneyAc.calculateInterest());
		
		
		
		System.out.println();
		
		System.out.println(saveAc.toString());
		System.out.println();
		System.out.println(moneyAc.toString());
		System.out.println();
		System.out.println(checkAc.toString());
	}
}
