package com.ahmi.jpadao;

import java.util.List;

import org.hibernate.Session;

import com.ahmi.jpa.entitymodels.Course;
import com.ahmi.jpa.entitymodels.Student;

public interface StudentDAO {
	
	/*
	 * This method will get create a list of all the Student data.
	 */
	
	List<Student> getAllStudents(Session session);
	
	/*
	 * This method will find a student based on their email address.
	 */
	
	Student getStudentByEmail(String sEmail, Session session);
	
	/*
	 * This method will validate a student based on their email, the unique identifier.
	 */
	
	boolean validateStudent(Session session, String sEmail, String sPass);
	
	/*
	 * This method will register a student to a particular course.
	 */
	
	void registerStudentToCourse(Student student, Session session, int cId, List<Course> courseList);
	
	/*
	 * This method will list the courses a student is enrolled into.
	 */
	
	List<Course> getStudentCourses(Student student, Session session);
	
}
