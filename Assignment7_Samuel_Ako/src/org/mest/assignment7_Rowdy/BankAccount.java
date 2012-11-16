package org.mest.assignment7_Rowdy;

import com.imagine.general.Interact;

public class BankAccount {

	//Global Variables
	public String name;								//-the name of this account
	public int acctNum;							//-the account number
	public double balance;
	
	private static final int ACCT_NUM_LENGTH = 6;		//-the length of all account numbers
	
	//constructor 1
	public BankAccount (String name) {
		this.acctNum = generateAcctNum();
		this.name = name;
		balance = 0.0;
	}//--end constructor
	
	//constructor 2
	public BankAccount (double balance, String name) {
		this.acctNum = generateAcctNum();			//account number
		this.balance = balance;
		this.name = name;
	}//--end constructor
	
	
/**
 * @name		 inquiry
 * @about		 returns the balance of this account	
 * @param 		 none
 * @return		 balance - the balance of this account
 */
	public double inquiry () {
		return balance;
	}//--end method inquiry
	
	
/**
 * @name		 withdraw
 * @about		 withraws money from this account 	
 * @param 		 amnt - the amount of money to take from this account
 * @return		 true if successfull and false otherwise
 */
	public boolean withdraw (double amnt) {
		if (amnt <= balance) {
			balance -= amnt;
			return true;
		}
		else 
			System.out.println("Insufficient Funds");
		return false;
	}//--end method withdraw
	
	public double deposit (double amnt) {
		balance += amnt;
		return balance;
	}//--end method deposit
	
	
/**
 * @name		 generateAcctNum
 * @about		 generates an account number for this account
 * @param 		 none
 * @return		 the generated account number
 */
	private int generateAcctNum () {
		return Interact.getRandomNum(9, ACCT_NUM_LENGTH);
	}
	
/**
 * @name		 toString
 * @about		 creats a string representation for this object
 * @param 		 none
 * @return		 the string representation
 */
	@Override
	public String toString () {
		StringBuilder strBuild = new StringBuilder();
		strBuild.append("Account Name     : "+ name+ "\n");
		strBuild.append("Account Number   : "+ acctNum+ "\n");
		strBuild.append("Account Balance  : "+ balance+ "\n");
		
		return strBuild.toString();
	}//--end method toString
}
