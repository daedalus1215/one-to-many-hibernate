package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
			
		try {
			session.beginTransaction();

			// get the instructor from the db
			int theId = 8;
			Instructor theInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor: " + theInstructor);
			
			
			// get the course for the instructor
			System.out.println("Courses: " + theInstructor.getCourses());
			
			// commit
			session.getTransaction().commit();
			
		} catch(Exception exception) {
			exception.printStackTrace();
		} finally {			
			session.close();
			
			factory.close();
		}
	}

}