package lab.day;

import java.util.Scanner;
import static java.lang.System.*;

public class App {
	public static void main(String[] args) {
		
		employeeDao ed = new employeeDao();
		Scanner nk = new Scanner(System.in); 		 // Here we create object of Scanner class
		employee e = new employee();
		fresherEmployee fe = new fresherEmployee();
		experienceEmployee ee = new experienceEmployee();
		
		int empId;									 // This is a instance variable empId
		String empFirstName; 						 // This is a instance variable empFirstName
		String empLastName;							//  This is a instance variable empLastName
		int contractPeriod;							//  This is a instance variable contractPeriod
		int increment;								//  This is a instance variable increment
		int experience;								//  This is a instance variable experience
		int hike;									//  This is a instance variable hike
	
		int count=0;								// it return 
		while(count<6) {							// While loop
			out.println(" Press 1 to Add Employee.\n Press 2 to Add Fresher Employee.\n Press 3 to Add Experience Employee.\n Press 4 to Get Employee details.\n Press 5 to Remove Employee.\n Press 6 or any other to Exit.");
			count = nk.nextInt();					// Taking Input
			
			switch(count) {							// Switch case
			 	case 1-> {										
			 		out.print("Enter your Employee id:- ");
			 		empId = nk.nextInt();					// Taking Input
			 		e.setEmpId(empId);						
			 		out.print("Enter your first name:- ");
			 		empFirstName = nk.next();				// taking input
			 		e.setEmpFirstName(empFirstName);		
			 		out.print("Enter your last name:- ");
			 		empLastName = nk.next();				// taking input
			 		e.setEmpLastName(empLastName);			
			 		ed.connect();							// connecting to hibernate
			 		ed.addEmployee(e);
			 	}
			 	case 2->{
			 		out.print("Enter your Employee id ");			
			 		empId = nk.nextInt();							// Taking Input
			 		fe.setEmpId(empId);														
			 		out.print("Enter your first name ");
			 		empFirstName = nk.next();						// Taking Input
			 		fe.setEmpFirstName(empFirstName);
			 		out.print("Enter your last name ");	
			 		empLastName = nk.next();						// Taking Input
			 		fe.setEmpLastName(empLastName);
			 		out.print("Enter your Contract period ");
			 		contractPeriod = nk.nextInt();					// Taking Input
			 		fe.setContractPeriod(contractPeriod);
			 		out.print("Enter your Increment percentage ");
			 		increment = nk.nextInt();						// Taking Input
			 		fe.setIncrement(increment);
			 		ed.connect();
			 		ed.addEmployee(fe);
			 	}
			 	case 3->{
			 		out.print("Enter your Employee id ");			
			 		empId = nk.nextInt();							// Taking Input
			 		ee.setEmpId(empId);
			 		out.print("Enter your first name ");
			 		empFirstName = nk.next();						// Taking Input
			 		ee.setEmpFirstName(empFirstName);
			 		out.print("Enter your last name ");
			 		empLastName = nk.next();						// Taking Input
			 		ee.setEmpLastName(empLastName);
			 		out.print("Enter how many years of experience do you have ");
			 		experience = nk.nextInt();						// Taking Input
			 		ee.setExperience(experience);
			 		out.print("Enter yout hike percentage ");
			 		hike = nk.nextInt();							// Taking Input
			 		ee.setHike(hike);
			 		ed.connect();
			 		ed.addEmployee(ee);
			 	}
			 	case 4->{
			 		System.out.print("Enter your id for get information of employees ");
					 empId= nk.nextInt();													// Taking Input
					 ed.connect();
					 e = ed.getEmployee(empId);
					 out.println(e);
			 	}
			 	case 5->{
			 		 out.print("Enter your id to delete employee ");
					 empId = nk.nextInt();													// Taking Input
					 ed.connect();
					 int delete = ed.removeEmployee(empId);
					 if(delete==1)                                  
						 out.println(" Employee successfully removed");
					 else
						 out.println(" Employee not found ");
			 	}
			}
		}
	}
}