package org.mest.assignment7_Rowdy;

public class Employee {
	
//Global Vars
	//Personal Info
	public String firstName;
	public String lastName;
	public String deptartment;
	private double salary;
	
	//accounts
	public CheckingAccount checkAc;
	public SavingsAccount saveAc;
	public MoneyMarket moneyAc;
	
	public Employee (String first, String last, String dept, double sal) {
		firstName = first;
		lastName = last;
		deptartment = dept;
		salary = sal;
		
		//initializing acounts
		String acctName = lastName;
		checkAc = new CheckingAccount(acctName+ " - checking");
		saveAc = new SavingsAccount(acctName+ " - savings");
		moneyAc = new MoneyMarket(acctName+ " - moneymarket");
	}//--end constructor
	
	
/**
 * @name		 transfer
 * @about		 transfers money between two accounts
 * @param 		 fromAcct - the account which will be debited
 * @param		 toAcct   - the account which will be credited
 * @return		 method is void
 */
	public void transfer (BankAccount fromAcct, BankAccount toAcct, double amnt) {
		if (fromAcct == null | toAcct == null) {
			System.out.println("One of the accounts is inactive! \n Cannot execute transaction! \n");
			return;
		}
		
		if (fromAcct.withdraw(amnt)) {
			toAcct.deposit(amnt);
			System.out.println();
			System.out.println("\t The Following Transaction :: ");
			System.out.println("\t\t Transfer From :");
			System.out.println(fromAcct.toString());
			System.out.println("\t\t Transfer To   :");
			System.out.println(toAcct.toString());
			System.out.println();
			
			System.out.println("Was Completed Successfully");
		} else {
			System.out.println("Transaction Failed....");
		}
		
	}//--end method transfer
	

	
/**
 * @name		 toString
 * @about		 overrides default toString method inherited from class Object
 * @param 		 none
 * @return		 the string representation of an employee i.e the details (name, age etc)
 */
	public String toString () {
		StringBuilder strBuild = new StringBuilder();
		strBuild.append("Firstname    : "+ this.firstName+ "\n");
		strBuild.append("Lastname     : "+ this.lastName+ "\n");
		strBuild.append("Department   : "+ this.deptartment+ "\n");
		strBuild.append("Salary       : "+ this.salary+ "\n");
		
		return strBuild.toString();
	}//--end method print
	
	
	
/**
 * @name		 getSalary
 * @about		 returns the salary of this employee
 * @param 		 none
 * @return		 this employee's salary
 */
	public double getSalary () {
		return salary;
	}
}
