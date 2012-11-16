package org.mest.assignment7_Rowdy;

public class MoneyMarket extends SavingsAccount {
	
	//Global Variables
	public static final double INTEREST_RATE = 0.1;
	private static final double WITHDRAWAL_LIMIT = 500;
	
	//constructor 1
	public MoneyMarket (String name) {
		super (name);
	}//--end constructor
	
	//constructor 2
	public MoneyMarket (double balance, String name) {
		super (balance, name);
	}//--end constructor
	
	
/**
 * @name		 withdraw - overrides super.withdraw
 * @about		 withraws money from this account 	
 * @param 		 amnt - the amount of money to take from this account
 * @return		 true if successfull and false otherwise
 */
	@Override
	public boolean withdraw (double amnt) {
		if (amnt <= 500)
			return super.withdraw(amnt);
		else
			System.out.printf("Sorry. %f exceeds the withdrawal limit %f.%n",amnt,WITHDRAWAL_LIMIT);
		return false;
	}//--end method withdraw
	
	
/**
 * @name		 calculateInterest - overides super.calculateInterest
 * @about		 calculates the interest for this account
 * @param 		 none 
 * @return		 returns the new balance after interest has been added
 */
	public double calculateInterest () {
		return calculateInterest(INTEREST_RATE);
	}
	
	
	
/**
 * @name		 toString - overrides super.toString()
 * @about		 creats a string representation for this object
 * @param 		 none
 * @return		 the string representation
 */
	@Override
	public String toString () {
		@SuppressWarnings("static-access")
		StringBuilder strBuild =       //replaces interest rate in savings with that of money market
				new StringBuilder(super.toString().replaceFirst(Double.toString(super.INTEREST_RATE), Double.toString(INTEREST_RATE)));
		
		strBuild.append("Withdrawal Limit : "+ WITHDRAWAL_LIMIT+ "\n");
		
		return strBuild.toString();
	}//--end method toString

}//--end class
