package com.mapping;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mapping.Entity.Marks;
import com.mapping.Entity.Student;
import com.mapping.Utility.HibernateUtility;

/**
 * Hello world!
 *
 */
public class AppAddStudent 
{
    public static void main( String[] args ) {

    	Marks m = new Marks();
    	m.setMarks(89);
    	
    	
    	Student s = new Student();
    	s.setName("Vishal");
    	s.setEmail("vishalpatil00@gmail.com");
    	s.setCourse("JavaFullStack");
    	s.setMarks(m);
    	
    	
    	SessionFactory factory = HibernateUtility.getSessionFactory();
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	session.persist(s);
    	transaction.commit();
    	session.close();
    	System.out.println("Student added: " + s);
    	
    }
}
