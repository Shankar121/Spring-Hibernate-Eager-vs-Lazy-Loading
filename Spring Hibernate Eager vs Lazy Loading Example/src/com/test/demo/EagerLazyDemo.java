package com.test.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.entity.Course;
import com.test.entity.Instructor;
import com.test.entity.InstructorDetail;

public class EagerLazyDemo {

	
	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
		
			session.beginTransaction();
			Instructor instructor=session.get(Instructor.class, 1);
			System.out.println(instructor);
			
			session.getTransaction().commit();
			//session.close();
			System.out.println(instructor.getCourses());
			System.out.println("done");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			factory.close();
			
		}
	}
	
}
