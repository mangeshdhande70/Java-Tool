package in.ineuron.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import in.ineuron.model.StudentGen1;

public class Insert {
	
	public static void main(String[] args) {
		
		
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(StudentGen1.class);
		
		Session session = configuration.buildSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		
		StudentGen1 student = new StudentGen1();
		
		student.setSname("Mangesh");
		student.setSaddress("Nirli");
		student.setSage(24);
		
		Integer id =(Integer)session.save(student);
		
		transaction.commit();
		session.close();
		
		System.out.println("Record is inserted with id :: "+id);
		
	}

}
