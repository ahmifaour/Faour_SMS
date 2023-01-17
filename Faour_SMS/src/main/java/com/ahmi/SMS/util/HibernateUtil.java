package com.ahmi.SMS.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
		
	public static Session getConnection(SessionFactory factory) {
		 SessionFactory f = new Configuration().configure().buildSessionFactory();
		 Session session = f.openSession();
		 return session;
	}
	
	public static SessionFactory getSessionFactory() {
		SessionFactory f = new Configuration().configure().buildSessionFactory();
		System.out.println("The Factory has now been created.");
		return f;
	}
}
