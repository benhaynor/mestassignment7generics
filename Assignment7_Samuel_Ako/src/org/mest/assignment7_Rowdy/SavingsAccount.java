package org.mest.assignment7_Rowdy;

public class SavingsAccount extends BankAccount{
	
	//Global Variables
	protected static final double INTEREST_RATE = 0.02;
	
	//constructor 1
	public SavingsAccount (String name) {
		super (name);
	}//--end constructor
	
	//constructor 2
	public SavingsAccount (double balance, String name) {
		super (balance, name);
	}//--end constructor
	
	
/**
 * @name		 calculateInterest - overloaded
 * @about		 calculates the interest for this account
 * @param 		 none 
 * @return		 returns the new balance after interest has been added
 */
	public double calculateInterest () {
		return calculateInterest(INTEREST_RATE );
	}//--end method calculateInterest
	
/**
 * @name		 calculateInterest - overloaded
 * @about		 calculates the interest for this account
 * @param 		 none 
 * @return		 returns the new balance after interest has been added
 */
	public double calculateInterest (double rate) {
		balance += (rate* balance);
		return balance;
	}//--end method calculateInterest
	
	
	
/**
 * @name		 toString - overrides super.toString()
 * @about		 creats a string representation for this object
 * @param 		 none
 * @return		 the string representation
 */
	@Override
	public String toString () {
		StringBuilder strBuild = new StringBuilder(super.toString());
		strBuild.append("Interest Rate    : "+ INTEREST_RATE+ "\n");
		
		return strBuild.toString();
	}//--end method toString
	
}//--end class
