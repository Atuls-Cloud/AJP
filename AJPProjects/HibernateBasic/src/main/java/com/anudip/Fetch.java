package com.anudip;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Employee emp = session.get(Employee.class,101);
		System.out.println(emp);
		System.out.println("Empployee information...");
		Employee emp2 = session.get(Employee.class,101);
		System.out.println(emp2);
		session.close();
		
		Session session1 = factory.openSession();
		Employee emp1 = session1.get(Employee.class,101);
		System.out.println(emp1);
		session.close();
	}

}

