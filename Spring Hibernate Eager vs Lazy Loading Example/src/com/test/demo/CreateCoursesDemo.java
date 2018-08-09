package com.test.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.entity.Course;
import com.test.entity.Instructor;
import com.test.entity.InstructorDetail;

public class CreateCoursesDemo {

	
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
			Instructor instructor=session.get(Instructor.class,1);
			Course tempCourse1=new Course("Java Tutorial");
			Course tempCourse2=new Course("Spring Tutorial");
			instructor.add(tempCourse1);
			instructor.add(tempCourse2);
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.getTransaction().commit();
			System.out.println("done");
		}catch(Exception ex) {
			System.out.println(ex);
		}finally {
			factory.close();
			
		}
	}
	
}
