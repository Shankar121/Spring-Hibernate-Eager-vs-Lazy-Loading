package com.test.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.entity.Instructor;
import com.test.entity.InstructorDetail;
import com.test.entity.Student;

public class GetInstructorDetailDemo {

	
	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
//			session.beginTransaction();
//			Instructor instructor=session.get(Instructor.class, 3);
//			InstructorDetail detail=new InstructorDetail("https://youtube.com/puja", "singing");
//			instructor.setInstructorDetail(detail);
//			session.getTransaction().commit();
			session=factory.getCurrentSession();
			session.beginTransaction();
			InstructorDetail instructorDetail=session.get(InstructorDetail.class, 4);
			System.out.println("fetch instructor detail: "+ instructorDetail);
			System.out.println("fetch instructor: "+ instructorDetail.getInstructor());
			session.getTransaction().commit();
			System.out.println("done");
		}catch(Exception ex) {
			System.out.println(ex);
		}finally {
			session.close();
			factory.close();
		}
	}
	
}
