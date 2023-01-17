package com.ahmi.jdbc.sms_maven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

import com.ahmi.SMS.util.HibernateUtil;

import jpa.service.StudentService;

/**
 * Unit test for the SMS.
 */

public class AppTest {
    /**
     * Below, the method from StudentServices validateStudent is being tested.
     * The person running the test, will have to input the password "TWP4hf5j" to
     * properly run the test.
     */
    
	@Test
    public void validateStudentTest() {
		SessionFactory f = HibernateUtil.getSessionFactory();
		Session s = HibernateUtil.getConnection(f);
        StudentService studentServiceTest = new StudentService();
        boolean testResult = studentServiceTest.validateStudent(s, "aiannitti7@is.gd", "TWP4hf5j");
        
        Assert.assertEquals(true, testResult);
    }
}
