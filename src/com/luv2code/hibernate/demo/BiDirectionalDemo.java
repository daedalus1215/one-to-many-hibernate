package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class BiDirectionalDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
			
		try {
			session.beginTransaction();

			
			int theId = 3;
			InstructorDetail tempInstructorDetail =
					session.get(InstructorDetail.class, theId);
			
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
			
			
//			session.save(tempInstructor);			
			// commit
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