package com.hibernate.startup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoadOperation {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Student student = (Student) session.load(Student.class, 8);
		System.out.println(student.getFirstName());
		/* Load() will throw an error if the row is not present in the database.
		 * 
		 * Exception in thread "main" org.hibernate.ObjectNotFoundException: No
		 * row with the given identifier exists:
		 * [com.hibernate.startup.Student#8]
		 */
		session.getTransaction().commit();
		session.close();
	}
}
