package com.ahmi.jpadao;

import java.util.List;

import org.hibernate.Session;

import com.ahmi.jpa.entitymodels.Course;

public interface CourseDAO {

/*
 * This method, will create a list of all the course data.
 */
	
	List<Course> getAllCourses(Session session);
	
}
