package org.mest.assignment7_Rowdy;

import java.util.ArrayList;

public class Company {

	//Globals
	public String name;							//-the name of the company
	public int numEmps;						//-the number of employees in the company
	public ArrayList<Employee> empList;			//-data structure to hold employees ofthis company
	
	
	//constructor
	public Company (String name, int numEmps) {
		this.name = name;
		this.numEmps = numEmps;
		empList = new ArrayList<>(numEmps);
	}//--end constructor
	
/**
 * @name		 toString
 * @about		 overrides default toString method inherited from class Object
 * @param 		 none
 * @return		 the string representation of a company i.e the details (name etc)
 */
	public String toString () {
		StringBuilder strBuild = new StringBuilder();
		strBuild.append ("Company Name        : "+ name+ "\n");
		strBuild.append ("Number of Employees : "+ numEmps+ "\n");
		return strBuild.toString();
	}//--end method toString
	
	
/**
 * @name		 employeeRoster
 * @about		 prints a list of all employees in the company
 * @param 		 none
 * @return		 method is void
 */
	public void employeeRoster () {
		int a = 1;
		for (Employee emp : empList) {
			System.out.println("\t"+ (a++)+ ".");
			System.out.println(emp);
			System.out.println();
		}
	}//--end method employeeRoster
	
	
/**
 * @name		 runPayroll
 * @about		 processes the salaries of all employees in the company
 * @param 		 none
 * @return		 method is void
 */
	public void runPayroll () {
		for (Employee emp : empList) {
			emp.checkAc.deposit(emp.getSalary());
		}
	}//--end method runPayroll
	
	
/**
 * @name		 runPayroll
 * @about		 processes the salaries of all employees in a given deparment
 * @param 		 dept - the dept for which the payroll is to be run
 * @return		 method is void
 */
	public void runPayroll (String dept) {
		for (Employee emp : empList) {
			if (emp.deptartment.equalsIgnoreCase(dept)) {
				emp.checkAc.deposit(emp.getSalary());
			}
		}
	}//--end method runPayroll
	
/**
 * @name		 addEmployee
 * @about		 adds an employee to this company
 * @param 		 emp - the employee to be added
 * @return		 method is void
 */
	public void addEmployee (Employee emp) {
		empList.add(emp);
	}//--end method addEmployee
	
	
	public void removeEmployee (int index) {
		if (index>0 & index<empList.size()+1) {
			empList.remove(index-1);
			System.out.println("Employee has been removed \n");
			return;
		}
		System.out.println("Sorry! remove failed : Employee does not exist\n");
	}//--end method removeEmployee
	
	
/**
 * @name		 addEmployee
 * @about		 adds a list of  employees to this company
 * @param 		 e - the list of employees to be added
 * @return		 method is void
 */
	public void addEmployee (ArrayList<Employee> e) {
		empList.addAll(e);
	}//--end method add employee
	
	
/**
 * @name		 getEmployee
 * @about		 returns the employee at location of i of arraylist
 * @param 		 num - the index of the desired employee
 * @return		 an employee
 */
	public Employee getEmployee (int num) {
		return empList.get(num);
	}//--end method getEmployee
	
	
}//--end class
