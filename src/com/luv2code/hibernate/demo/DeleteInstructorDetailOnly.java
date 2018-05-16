package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class DeleteInstructorDetailOnly {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
			
		try {
			session.beginTransaction();

			
			// Get Instructor via primary key
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 4);
			
			// delete instructor
			System.out.println("Found the instructor detail " + instructorDetail);
			
			
			if (instructorDetail != null) {
				// will ALSO delete the associated details entity because of the CascadeType.ALL
				System.out.println("\nDeleteing: " + instructorDetail);
				
				// break bi-directional reference. Remove the associated object reference. Basically tell the constructor we do not have a instructorDetail
				instructorDetail.getInstructor().setInstructorDetail(null);
				session.delete(instructorDetail);
			}
			
			
			// commit
			session.getTransaction().commit();
			
		} catch(Exception exception) {
			exception.printStackTrace();
		} finally {
			factory.close();
		}
	}

}