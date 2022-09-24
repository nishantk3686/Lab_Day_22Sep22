
/**
 * @author Nishant Kumar
 * Illustrating STUDENT MANAGEMENT SYSTEM TO CREATE STUDENT, LAPTOP AND ADD TO DATABASE USING HIBERNATE 
 * AND PRINT DATA OF ONE OR ALL STUDENTS AND LAPTOPS, DELETE STUDENT USING DATA ACCESS OBJECT AND HQL 
 * ILLUSTRATING ONE TO MANY MAPPING OF ENTITY IN DATABASE USING HIBERNATE
 * ONE STUDENT -> MANY LAPTOP
 */
package oneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 */
public class App 
{
    public static void main( String[] args )
    {
    	// CREATING SCANNER OBJECT
    	Scanner scan = new Scanner(System.in);
    	int id,age,ram,choice=0,n;
    	String name,domain,email,contact,os,ip;
    	List<laptop> lapList = new ArrayList<laptop>();
    	List<student> stList = new ArrayList<student>();
    	
    	// CREATING STUDENT OBJECT
    	student s = new student();
    	// CREATING LAPTOP OBJECT
    	laptop l = new laptop();
    	// CREATING STUDENT DAO OBJECT
    	studentDao dao = new studentDao();
    	
    	while(choice<7) {
			System.out.println("\nPress 1 - Add Student \nPress 2 - Print Student \nPress 3 - Print Laptop \nPress 4 - Print All Student \nPress 5 - Print All Laptop \nPress 6 - Remove Student \nPress 7 - Exit");
			System.out.print("ENTER CHOICE : ");
			choice = scan.nextInt();
			
			
			switch(choice) {
			
			// FIRST CASE
			// TO ESTABLISH ONE TO MANY MAPPING
			// ONE STUDENT MANY LAPTOP
			// ADDING STUDENT AND LAPTOP IN DATABASE
			case 1->{
				
				System.out.print("\nEnter First Name : ");
				name = scan.next();// ASKING USER TO STUDENT NAME
				s.setStFirstName(name);
				System.out.print("\nEnter Last Name : ");
				name = scan.next();// ASKING USER TO STUDENT NAME
				s.setStLastName(name);
				System.out.print("\nEnter Domain Name : ");
				domain = scan.next();// ASKING USER TO STUDENT DOMAIN
				s.setStDoamin(domain);
				System.out.print("\nEnter Email : ");
				email = scan.next();// ASKING USER TO STUDENT EMAIL
				s.setStEmail(email);
				System.out.print("\nEnter Contact No : ");
				contact = scan.next();// ASKING USER TO STUDENT PHONE NO
				s.setStContact(contact);
				System.out.print("\nEnter Age : ");
				age = scan.nextInt();// ASKING USER TO STUDENT AGE
				s.setStAge(age);
				System.out.print("\nEnter How many laptop : ");
				n = scan.nextInt();// ASKING USER TO STUDENT LAPTOP
				dao.connect();
				//FOR LOOP TO TAKE INPUT LAPTOP DATA UNTILL ALL LAPTOP IS NOT STORED
				for(int i = 1;i<=n;i++) {
					laptop lap = new laptop();
					System.out.println("Enter "+i+" Laptop Name : ");
					name = scan.next();
					lap.setLapName(name);
					System.out.println("\nEnter "+i+" Laptop IP : ");
					ip = scan.next();
					lap.setLapIp(ip);
					System.out.println("\nEnter "+i+" Laptop RAM :");
					ram = scan.nextInt();
					lap.setLapRAM(ram);
					System.out.println("\nEnter "+i+" Operating System : ");
					os = scan.next();
					lap.setLapOs(os);
					dao.registerLap(lap);// SAVING LAPTOP IN SESSION OBJECT
					lapList.add(lap);// PASSING LAPTOP OBJECT IN THE ARRAYLIST TO STORE 
				}
				s.setL(lapList); // ADDING MANY LAPTOP TO ONE STUDENT
				dao.registerStu(s);// SAVING STUDENT IN SESSION
				dao.disconnect();// COMMITING DATA IN DATABASE AND CLOSING SESSION
				
			}
			
			
			// SECOND CASE
			// TO FETCH A STUDENT
			// FETCH DATA USING PRIMARY KEY
			case 2->{
				System.out.print("\nEnter Id : ");
				id = scan.nextInt();// ASKING USER STUDENT id
				dao.connect();// STARING SESSION
				s=dao.fetchStd(id);// FETCHING DATA OF A STUDENT
				System.out.println(s);
				dao.disconnect();// COMMITING AND CLOSING SESSION
			}
			
			// THIRD CASE
			// TO FETCH A LAPTOP
			// FETCH LAPTOP USING PRIMARY KEY
			case 3->{
				System.out.print("\nEnter Id : ");
				id = scan.nextInt();// ASKING USER LAPTOP id
				dao.connect();
				l = (laptop) dao.fetchLap(id);// FETCHING DATA OF A LAPTOP
				System.out.println(l);
				dao.disconnect();
			}
			
			// FOURTH CASE
			// TO FETCH ALL STUDENT
			case 4->{
				dao.connect();
				stList = dao.fetchAll();// FETCHING STUDENT DATA
				for(student st : stList)
					System.out.println(st);
				dao.disconnect();
			}
			
			// FIFTH CASE
			// TO FETCH ALL LAPTOP FROM DATABASE
			case 5 ->{
				dao.connect();
				lapList = dao.fetchAllLap();// FETCHING LAPTOP DETAILS
				for(laptop lap : lapList)
					System.out.println(lap);
				dao.disconnect();
			}
			
			// SIXTH CASE
			// TO DELETE A STUDENT
			// DELETE STUDENT USING PRIMARY KEY
			case 6->{
				System.out.print("\nEnter Id : ");
				id = scan.nextInt();// ASKING USER FOR STUDENT ID
				dao.connect();
				n=dao.deleteStd(id); // DELETING STUDENT FROM DATABASE
				if(n==1)
					System.out.println("Student Deleted.");
				else
					System.out.println("Student does not exist.");
				dao.disconnect();
			}
			
			}
    	}
    	
    	
		scan.close();			// CLOSING SCANNER OBJECT
    }
}