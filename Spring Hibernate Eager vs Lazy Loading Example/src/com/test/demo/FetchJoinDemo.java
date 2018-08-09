package com.test.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.test.entity.Course;
import com.test.entity.Instructor;
import com.test.entity.InstructorDetail;

public class FetchJoinDemo {

	
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
			Query<Instructor> query=session.createQuery("select i from Instructor i "
					+ " JOIN FETCH i.courses where i.id=:id",Instructor.class);
			query.setParameter("id", 1);
			Instructor instructor=query.getSingleResult();
			System.out.println(instructor);
			
			session.getTransaction().commit();
			session.close();
			System.out.println(instructor.getCourses());
			System.out.println("done");
			
			 System.out.println("\n\nluv2code: Opening a NEW session \n");

	            session = factory.getCurrentSession();
	            
	            session.beginTransaction();
	            
	            // get courses for a given instructor
	            Query<Course> query2 = session.createQuery("select c from Course c "
	                                                    + "where c.instructor.id=:theInstructorId",    
	                                                    Course.class);
	            
	            query2.setParameter("theInstructorId", 1);
	            
	            List<Course> tempCourses = query2.getResultList();
	            
	            System.out.println("tempCourses: " + tempCourses);
	            
	            // now assign to instructor object in memory
	            instructor.setCourses(tempCourses);
	            
	            System.out.println("luv2code: Courses: " + instructor.getCourses());
	            
	            session.getTransaction().commit();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			factory.close();
			
		}
	}
	
}
