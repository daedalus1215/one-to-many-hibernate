package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
			
		try {
			session.beginTransaction();

			InstructorDetail instructorDetail = new InstructorDetail("youtube channel.com", "coding");
			
			
			// Get Instructor via primary key
			Instructor tempInstructor = new Instructor("Larry", "Adams", "lad@yahoo");
			
			
			tempInstructor.setInstructorDetail(instructorDetail);
			
			
			
			session.save(tempInstructor);			
			// commit
			session.getTransaction().commit();
			
		} catch(Exception exception) {
			exception.printStackTrace();
		} finally {
			factory.close();
		}
	}

}