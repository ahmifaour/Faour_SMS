package jpa.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.ahmi.jpa.entitymodels.Course;
import com.ahmi.jpa.entitymodels.Student;
import com.ahmi.jpadao.StudentDAO;

public class StudentService implements StudentDAO {

	/*
	 * The various overwritten methods below, all contain the code for the methods
	 * declared in the StudentDAO interface. Their purpose or function is stated
	 * in the StudentDAO interface.
	 */
	
	@Override
	public List<Student> getAllStudents(Session session) {
		
		String hql = "FROM Student";
		TypedQuery<Student> q = session.createQuery(hql, Student.class);
		List<Student> result = new ArrayList<>();
		try {
			result = q.getResultList();
			Iterator<Student> iterator = result.iterator();
			while(iterator.hasNext()) {
				Student student = iterator.next();
				System.out.println("Name: " + student.getsName() + ", Email: " + student.getsEmail() + ", Password: " + student.getsPass() + ", Course: " + student.getsCourses());
			}
		} catch (NoResultException e) {
			System.out.println("There are no rows found in the Students table.");
			return result;
		}
		
		return result;
	}

	@Override
	public Student getStudentByEmail(String sEmail, Session session) {
		
		String hql = "FROM Student WHERE email = :email";
		TypedQuery<Student> q = session.createQuery(hql, Student.class);
		q.setParameter("email", sEmail);
		Student student = (Student) q.getSingleResult();
		System.out.println("Name: " + student.getsName() + ", Email: " + student.getsEmail() + ", Password: " + student.getsPass() + ", Course: " + student.getsCourses());
		return student;
	}

	@Override
	public boolean validateStudent(Session session, String sEmail, String sPass) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Validating Login Information...");
		String hql = "FROM Student WHERE email = :email";
		TypedQuery<Student> q = session.createQuery(hql, Student.class);
		q.setParameter("email", sEmail);
		
		try {
			Student student = (Student) q.getSingleResult();
			System.out.println("\nYour Email has been confirmed.");
			System.out.println("Please Enter Your Password.");
			String userPassword = scanner.nextLine();
			String storedPassword = student.getsPass();
			scanner.close();
			if(storedPassword.equals(userPassword)) {
				System.out.println("Your credentials have been validated. Thank you!");
				return true;
			} else {
				System.out.println("The password entered is incorrect. Please try again.");
				return false;
			}
			
			} catch (NoResultException e) {
				e.printStackTrace();
				System.out.println("No result has been found.");
				return false;
		}
	}

	@Override
	public void registerStudentToCourse(Student student, Session session, int cId, List<Course> courseList) {
		Course c2 =  courseList.get(cId);
		List<Course> list = student.getsCourses();
		list.add(c2);
		session.save(c2);
		student.setsCourses(list);
		session.save(student);
	}

	@Override
	public List<Course> getStudentCourses(Student student, Session session) {
		List<Course> list = student.getsCourses();
		Iterator<Course> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			Course c = iterator.next();
			System.out.println(c.getcId() + " " + c.getcName() + " " + c.getcInstructorName());
		}
		return list;
	}

}
