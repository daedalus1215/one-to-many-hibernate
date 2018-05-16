package com.luv2code.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class TestJdbc {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
			
		try {
			// create a student object
			System.out.println("Creating new student object...");
			Student studentDTO = new Student("Paul", "Wall", "paul@luv2code.com");

			// start a transaction
			System.out.println("Starting a transaction...");
			session.beginTransaction();
			
			// save the student object
			session.save(studentDTO);
			System.out.println("Creating new student object...");
			System.out.println("Saving the student...");
			
			// commit transaction
			System.out.println("Creating new student object...");
			session.getTransaction().commit();
			
		} catch(Exception exception) {
			exception.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
