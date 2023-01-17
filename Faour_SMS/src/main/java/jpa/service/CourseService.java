package jpa.service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.ahmi.SMS.util.HibernateUtil;
import com.ahmi.jpa.entitymodels.Course;
import com.ahmi.jpadao.CourseDAO;

public class CourseService extends HibernateUtil implements CourseDAO {

	/*
	 * The overwritten method below is the actual body for the getAllCourses method
	 * located within the CourseDAO file.
	 */
	
	@Override
	public List<Course> getAllCourses(Session session) {
		String hql = "FROM Course";
		TypedQuery<Course> q = session.createQuery(hql, Course.class);
		List<Course> results = q.getResultList();
		Iterator<Course> courseList = results.iterator();
		while(courseList.hasNext()) {
			Course c = courseList.next();
			System.out.println("Course ID: " + c.getcId() + ", Name: " + c.getcName() + ", Instructor: " + c.getcInstructorName());
		}
		
		return results;
	}

}
