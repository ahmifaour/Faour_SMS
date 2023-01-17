package com.ahmi.jdbc.sms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args) {

		System.out.println("Entry Point main()");
		SessionFactory f = new Configuration().configure().buildSessionFactory();
		Session s = f.openSession();
		System.out.println("The Session is now open.");
		
		Transaction t = s.beginTransaction();
		SMSRunner menu = new SMSRunner();
		menu.firstmenu(s);
		
		t.commit();
		f.close();
		s.close();
	}
}