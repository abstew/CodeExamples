package stewartAnna_Week8Project;
// This program will create a menu operation that will allow users to pick from 5 functionalities.
// Programmed by Anna Stewart, CMIS 141-7380, May 11th 2020.
import java.util.Scanner;
import java.util.*;
public class StewartAnna_Project {
		
	public static int loadEmployeeData(String employeeNamesArray[], int employeeIdArray[], double annualSalaryArray[] ) {
		Scanner scanstr = new Scanner(System.in);
		Scanner scanint = new Scanner(System.in);
		Scanner scandb = new Scanner(System.in);
		// Call for number of employees to be loaded
		System.out.println("How many employee's would you like to enter?");
		int numEntries = scanint.nextInt();
		int arrayLength = numEntries;
		// For loop to populate arrays with employee info
		for(int i=0; i < numEntries; i++) { // Each loop will populate respective array
			System.out.println("Enter employee name: ");
			employeeNamesArray[i]=scanstr.nextLine();
			System.out.print("Enter employee ID: ");
			employeeIdArray[i]=scanint.nextInt();
			System.out.println("Enter annual salary: ");
			annualSalaryArray[i] = scandb.nextDouble();
		}
		return arrayLength;
	}
	
	public static void addNewEmployee (String employeeNamesArray[], int employeeIdArray[], double annualSalaryArray[], int arrayLength) {
		// Initalize scanners to collect input from user
		Scanner scanstr = new Scanner(System.in);
		Scanner scanint = new Scanner(System.in);
		Scanner scandb = new Scanner(System.in);
		// For loop only allowing one entry 
		for (int i=arrayLength; i < arrayLength + 1; i++) {
			System.out.println("Enter employee name: ");
			employeeNamesArray[i] = scanstr.nextLine();
			System.out.print("Enter employee ID: ");
			employeeIdArray[i]=scanint.nextInt();
			System.out.println("Enter annual salary: ");
			annualSalaryArray[i] = scandb.nextDouble();	
		}
	}
	
	public static void displayAll(String employeeNamesArray[], int employeeIdArray[], double annualSalaryArray[]) {
		// DisplayAll will print all array items
		for(int i=0;  i < employeeNamesArray.length; i++) {
			if(employeeIdArray[i] != 0) {
				System.out.println("Employee name: "+ employeeNamesArray[i] + " Employee ID: " + employeeIdArray[i] + " Annual salary: " + annualSalaryArray[i]);
			}
			else{
				break;
			}
			}
	}
	public static void retrieveSpecificEmployee(String employeeNamesArray[], int employeeIdArray[], double annualSalaryArray[]) {
		Scanner scanint = new Scanner(System.in);
		// Enter intended student ID
		System.out.println("Enter employee ID: ");
		int idInput = scanint.nextInt();
		int indexFound = 0;
		for(int i = 0; i < employeeIdArray.length; i++) { // Loop will look for the ID in question and break loop once it has identified the ID
			if (indexFound == employeeIdArray[i]);
			indexFound = i; // Index Found represents the matching ID 
			break;
		}
		// Print output
		System.out.println("For ID input: " + idInput + " Employee Name: " + employeeNamesArray[indexFound] + "Annual salary: " + annualSalaryArray[indexFound]);
			
		}
	
	public static void retrieveEmployeesWithRange(String employeeNamesArray[], int employeeIdArray[], double annualSalaryArray[]) {
		Scanner scandb = new Scanner(System.in);
		System.out.println("Enter minimum and maximum salary seperated by space: ");
		double minimumSalary = scandb.nextDouble(); // Minimum Salary, lower bound
		double maximumSalary = scandb.nextDouble(); // Maximum salary, upper bound
		for (int i = 0; i < annualSalaryArray.length; i++ ) {
			if (annualSalaryArray[i] < maximumSalary && annualSalaryArray[i] > minimumSalary) { // All matching index values must be above min and below max
				System.out.println("Name: " + employeeNamesArray[i] + " ID: " + employeeIdArray[i] + " Annual Salary: " + annualSalaryArray[i]); // Print output
			}
		}
		
	}
	
	
		
	
	
	



	public static void main(String[] args) {
		// Introduce Programmer
		System.out.println("Anna Stewart" + "\nCMIS 141-7380" + "\nMay 11, 2021");
		
		// Initialize arrays to be populated via functions
		String employeeNamesArray[] = new String[100];
		int employeeIdArray[] = new int[100];
		double annualSalaryArray[] = new double[100];
		
	
		int userSelection = 0;
		while(userSelection  !=6 ) {
			// Introduce menu selection options within loop to allow for re-prompting
			System.out.print("\n");
			System.out.println("1: Load employees' data");
			System.out.println("2: Add new employee");
			System.out.println("3: Display all employees");
			System.out.println("4: Retrieve specific employee's data");
			System.out.println("5: Retrieve employees with salaries based on range");
			System.out.println("6: Exit");
						
			// Collect user input
			Scanner scanInt = new Scanner(System.in);
			userSelection = scanInt.nextInt();
		
			switch (userSelection) { // Selection menu with each "case" representing a user selection.
			
			case 1: loadEmployeeData(employeeNamesArray, employeeIdArray, annualSalaryArray);
					continue;
			
			case 2:
				addNewEmployee(employeeNamesArray, employeeIdArray, annualSalaryArray, userSelection);
					continue;
	
			case 3: displayAll(employeeNamesArray, employeeIdArray, annualSalaryArray);
					continue;
					
			case 4: retrieveSpecificEmployee(employeeNamesArray, employeeIdArray, annualSalaryArray);
					continue;
					
			case 5: retrieveEmployeesWithRange(employeeNamesArray, employeeIdArray, annualSalaryArray);
					continue;
					
			case 6: System.out.println("Thank you for using the employee data program. Have a nice day!");
				break;
			}
		
			
		}
		
		}
		
	}
		


