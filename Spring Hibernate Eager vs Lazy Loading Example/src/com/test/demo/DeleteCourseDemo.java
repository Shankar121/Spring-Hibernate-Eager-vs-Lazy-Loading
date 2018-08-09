package com.test.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.entity.Course;
import com.test.entity.Instructor;
import com.test.entity.InstructorDetail;
import com.test.entity.Student;

public class DeleteCourseDemo {

	
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
			Course course=session.get(Course.class, 10);
			System.out.println("deleting course: "+ course);
			//remove bi-directional link
			//instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(course);
			session.getTransaction().commit();
			System.out.println("done");
		}catch(Exception ex) {
			System.out.println(ex);
		}finally {
			factory.close();
			
		}
	}
	
}
