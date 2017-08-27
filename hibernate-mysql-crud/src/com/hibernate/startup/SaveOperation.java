package com.hibernate.startup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveOperation {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for (int i = 1; i <= 10; i++) {
			Student student = new Student();
			student.setFirstName("firstName" + i);
			student.setLastName("lastName" + i);
			student.setAge(1 + i);
			student.setSchool("school" + i);
			student.setSection("section" + i);
			//session.save(student);
			session.persist(student);
		}
		session.getTransaction().commit();
		session.close();
	}
}
