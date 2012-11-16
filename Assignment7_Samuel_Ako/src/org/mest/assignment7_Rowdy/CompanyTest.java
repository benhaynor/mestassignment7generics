package org.mest.assignment7_Rowdy;

import com.imagine.general.Interact;

public class CompanyTest {

	
	static boolean exitFlag = false;				//used to escape from employee menu
	private static Company company;
	public static void main (String args[]) {
		
		//instantiating a company
		company = new Company("The Meltwater Foundation", 5);
		
		//adding employees to company
		company.addEmployee(new Employee("Fui", "Nusenu", "EIT", 200));
		company.addEmployee(new Employee("Sarsah", "Kyemenu", "EIT", 50));
		company.addEmployee(new Employee("Claude", "Ayitey", "EIT", 250));
		company.addEmployee(new Employee("Samuel", "Ako", "EIT", 9000));
		company.addEmployee(new Employee("Rowdy", "Sholes", "FELLOW", 20000));
		company.addEmployee(new Employee("Ben", "Haynor", "FELLOW", 20000));
		company.addEmployee(new Employee("Afua", "Antwi", "Admin", 5000));
		company.addEmployee(new Employee("Richard", "Tanksley", "FACULTY", 100000));
		
		System.out.println("Please Select Your Choice");
		System.out.println("1. I want to run a boring program");
		System.out.println("2. I love fun, so hit me with the fun-stuff");
		
		int option = (Integer) Interact.getInput("Enter option", "int");
		if (option == 1) menu2();
		else if (option == 2) {
			System.out.printf("\t\t Welcome To %s  - Integrated System \n", company.name);
			System.out.println("\t ------------------------------------------------------------------------------\n");
			while (true) {
				menu1();
			}
		}
		else {
			System.out.println("Enter a valid option next time, bye");
			Interact.shutdown();
		}
	}
	
	public static void menu1 () {
		System.out.println("\n");
		System.out.println("Please Select A Task To Perform");
		System.out.println("1. Add employee");
		System.out.println("2. Remove employee");
		System.out.println("3. Select an employee");
		System.out.println("4. View employee roster");
		System.out.println("5. Run payroll by department");
		System.out.println("6. Run payroll for entire company");
		System.out.println("7. Exit \n");
		
		int option = (Integer) Interact.getInput("Select option", "int");
		
		switch (option) {
			case 1:
				addEmployee();
				System.out.println();
				break;
			case 2:
				company.employeeRoster();
				System.out.println();
				int selectEmp = (Integer) Interact.getInput("Select Employee", "int");
				company.removeEmployee(selectEmp);
				break;
				
			case 3:
				company.employeeRoster();
				System.out.println();
				exitFlag = false;
				int chooseEmp = (Integer) Interact.getInput("Select Employee", "int");
				while (!exitFlag) {
					employeeMenu (chooseEmp);
				}
				
			case 4:
				company.employeeRoster();
				System.out.println();
				break;
				
			case 5:
				company.runPayroll((String) Interact.getInput("Enter Department", "string"));
				System.out.println("Payroll Execution Complete\n");
				break;
				
			case 6:
				company.runPayroll();
				System.out.println("Payroll Execution Complete\n");
				break;
				
			case 7:
				System.out.println();
				Interact.shutdown();
				break;
				
			default:
				System.out.println("");
		}//-end switch
		
	}//--end method menu1
	
	public static void employeeMenu (int index) {
		System.out.println("\n\t Employee Menu");
		
		System.out.println("1. Transfer from current to savings and calculate interest");
		System.out.println("2. Transfer from current to money market and calculate interest");
		System.out.println("3. View Savings account info");
		System.out.println("4. View Checking account info");
		System.out.println("5. View Money market account info");
		System.out.println("6. Exit this menu\n\n");
		
		Employee employee = company.getEmployee(index-1);
		int option = (Integer) Interact.getInput("Select option", "int");
		switch (option) {
			case 1:
				employee.transfer(employee.checkAc, employee.saveAc, (Double) Interact.getInput("Enter amount to transfer", "double"));
				employee.saveAc.calculateInterest();
				break;
			
			case 2:
				employee.transfer(employee.checkAc, employee.moneyAc, (Double) Interact.getInput("Enter amount to transfer", "double"));
				employee.moneyAc.calculateInterest();
				break;
				
			case 3:
				System.out.println(employee.saveAc);
				System.out.println();
				break;
				
			case 4:
				System.out.println(employee.checkAc);
				System.out.println();
				break;
				
			case 5:
				System.out.println(employee.moneyAc);
				System.out.println();
				break;
				
			case 6:
				exitFlag = true;
				return;
				
			default:
				System.out.println("Please select a valid option");
				employeeMenu(index);
		}
	}//--end method employeeMenu
	
	public static void addEmployee () {
		System.out.println("\n\t Add Employee");
		Employee emp = new Employee((String) Interact.getInput("Firstname", "string"), 
				(String) Interact.getInput("Lastname", "string"), 
				(String) Interact.getInput("Department", "string"),
				(Double) Interact.getInput("Salary", "double"));
		company.addEmployee(emp);
		System.out.println();
	}//--end method addEmployee
	
	public static void menu2 () {
		//listing employees
		System.out.println("\t List of employees");
		company.employeeRoster();
		
		//running payroll
		System.out.println("\n\t Running payroll");
		company.runPayroll();
		
		//running payroll by department
		System.out.println("\n\t Running payroll for fellows");
		company.runPayroll("fellows");
		
		//transfering from checking to saving
		System.out.println("\n\t transfering from checking to saving");
		Employee emp1 = company.getEmployee(6);
		emp1.transfer(emp1.checkAc, emp1.saveAc, emp1.getSalary());
		System.out.println("Interest  : "+ emp1.saveAc.calculateInterest());
		
		//transfering from checking to saving
		System.out.println("\n\t transfering from checking to saving");
		Employee emp2 = company.getEmployee(5);
		emp2.transfer(emp2.checkAc, emp2.moneyAc, emp1.getSalary());
		System.out.println("After adding Interest  : "+ emp2.moneyAc.calculateInterest());
	}
}
