package com.mapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mapping.Entity.Student;
import com.mapping.Utility.HibernateUtility;

public class UpdateMarks {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		List<Student> sList = session.createQuery("from Student", Student.class).list();
		
		for (Student s : sList) {
			
			s.getMarks().setMarks(78);
			System.out.println("Updated marks for Student ID: " + s.getId());
		}
		transaction.commit();
		session.close();
	}
}
