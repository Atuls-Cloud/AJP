package com.anudip;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        //System.out.println(factory);
        Employee emp = new Employee();
        emp.setEid(102);
        emp.setEname("Rahul");
        emp.setCity("Pune");
        System.out.println(emp);
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(emp);
        session.getTransaction().commit();
        session.close();
    }
}
