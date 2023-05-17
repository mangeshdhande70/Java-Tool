package in.ineuron.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class Insert {
	
	public static void main(String[] args) {
		
		
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Student.class);
		
		Session session = configuration.buildSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		
		Student student = new Student();
		
		student.setSname("Mangesh");
		student.setSaddress("Nirli");
		student.setSage(24);
		
		session.save(student);
		
		transaction.commit();
		session.close();
		
		
		
	}

}
