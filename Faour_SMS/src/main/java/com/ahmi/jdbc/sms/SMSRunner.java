package com.ahmi.jdbc.sms;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.ahmi.jpa.entitymodels.Course;
import com.ahmi.jpa.entitymodels.Student;

import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {
	
	public StudentService sService = new StudentService();
	public CourseService cService =  new CourseService();
	
	public void firstmenu(Session session) {
		
		boolean usingMenu = true;
		int uResponse = 0;
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * The code below is the display for the main menu in the SMS.
		 */
		
		while(usingMenu) {
			System.out.println("\n====== Main Menu ======\nAre you a(n)");
			System.out.println("1. Student");
			System.out.println("2. Quit\n");
			System.out.println("Please, enter 1 or 2.");
			uResponse = scanner.nextInt();
			
			switch(uResponse) {
			case 1:
				System.out.println("Currently logging in...");
				@SuppressWarnings("unused") boolean isLoggedIn = false;
				
				/*
				 * Below is the code asking the user to enter their login
				 * information.
				 */
				
				System.out.println("Please Enter Your Email: ");
				Scanner iScanner = new Scanner(System.in);
				String userEmail = iScanner.nextLine();
				System.out.println("Please Enter Your Password: ");
				String userPass = iScanner.nextLine();
				
				/*
				 * Below, this code is in charge of the login process.
				 */
				
				if(login(session, sService, userEmail, userPass)) {
					isLoggedIn = true;
					
					/*
					 * Retrieves the current student from the database.
					 */
					
					Student student = sService.getStudentByEmail(userEmail, session);

					System.out.println("\n====== Hello: "+ student.getsName()+ " ========\n");
					System.out.println("My Classes:\n");
					System.out.println("COURSE ID  COURSE NAME  INSTRUCTOR NAME\n");
					sService.getStudentCourses(student, session);
					
					System.out.println("\n====== Select An Option ====\n");
					System.out.println("1. Register to Class");
					System.out.println("2. Logout");
					
					int courseChoice = iScanner.nextInt();
					
					switch (courseChoice) {
					case 1:
						
						/*
						 * This code displays all of the courses the current
						 * student is eligible to register for.
						 */
						
						System.out.println("\nAll Courses:\n");
						System.out.println("COURSE ID  COURSE NAME  INSTRUCTOR NAME\n");
						List <Course> clist = cService.getAllCourses(session);
						System.out.println("\nWhich Course?");
						
						int courseId = scanner.nextInt();
						sService.registerStudentToCourse(student, session, courseId, clist);
						
						/*
						 * The code below will display all of the courses that
						 * the current student is current enrolled in.
						 */
						
						System.out.println("My Classes:\n");
						System.out.println("COURSE ID  COURSE NAME  INSTRUCTOR NAME\n");
						sService.getStudentCourses(student, session);
						break;
					
					case 2:
						usingMenu = logout();
						break;
						
					default:
						break;
					}
				}
				
				break;
			
			case 2:
				usingMenu = logout();
				break;
			
			default:
				System.out.println("Invalid response, please try again.");
				break;
			}
		}
		
		scanner.close();
	}
	
	public boolean login(Session session, StudentService service, String userEmail, String userPass){
		
		/*
		 * The "isReal" method validates whether or not the email is a valid
		 * student email.
		 */
		
		boolean isReal = sService.validateStudent(session, userEmail, userPass);
		
		if(isReal) {
			System.out.println("Login complete.");
			return true;
		}else {
			System.out.println("Login failed.");
			return false;
		}
	}
	
	/*
	 * The "logout" method prints a line to the console, notifying the student
	 * that they have successfully logged out of the SMS.
	 */
	
	public boolean logout() {
		System.out.println("You have successfully logged out.");
		return false;
	}
}