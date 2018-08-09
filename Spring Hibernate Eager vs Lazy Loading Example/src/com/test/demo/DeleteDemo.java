package com.test.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.entity.Instructor;
import com.test.entity.InstructorDetail;
import com.test.entity.Student;

public class DeleteDemo {

	
	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			InstructorDetail instructorDetail=session.get(InstructorDetail.class, 5);
			System.out.println("deleting instructor Detail: "+ instructorDetail);
			//remove bi-directional link
			//instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetail);
			session.getTransaction().commit();
			System.out.println("done");
		}catch(Exception ex) {
			System.out.println(ex);
		}finally {
			factory.close();
			
		}
	}
	
}
