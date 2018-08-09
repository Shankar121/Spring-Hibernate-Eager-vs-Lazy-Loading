package com.test.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.entity.Instructor;
import com.test.entity.InstructorDetail;
import com.test.entity.Student;

public class CreateDemo {

	
	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
		
			Instructor instructor=new Instructor("Shankar", "Gupta", "shankar@gmail.com");
			InstructorDetail instructorDetail=new InstructorDetail("https://youtube.com/shankar", "coding");
			instructor.setInstructorDetail(instructorDetail);
			session.beginTransaction();
			session.save(instructor);
			System.out.println("Saving instructor: "+ instructor);
			session.getTransaction().commit();
			System.out.println("done");
		}catch(Exception ex) {
			System.out.println(ex);
		}finally {
			factory.close();
			
		}
	}
	
}
