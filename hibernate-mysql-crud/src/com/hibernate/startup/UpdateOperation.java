package com.hibernate.startup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateOperation {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Student student = (Student) session.get(Student.class, 9);
		System.out.println("Fetched Student - " + student.toString());
		session.getTransaction().commit();
		session.close();
		student.setLastName("updated-lastName");
		student.setFirstName("updated-firstName");
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		session1.update(student);
		session1.getTransaction().commit();
		session1.close();
	}
}
