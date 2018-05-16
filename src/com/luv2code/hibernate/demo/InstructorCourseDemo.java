package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class InstructorCourseDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
			
		try {
			session.beginTransaction();

			
			int theId = 1;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("tempInstructor: " + tempInstructor);
			
			System.out.println("courses: " + tempInstructor.getCourses());
			
			
			session.getTransaction().commit();
			
		} catch(Exception exception) {
			exception.printStackTrace();
		} finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}