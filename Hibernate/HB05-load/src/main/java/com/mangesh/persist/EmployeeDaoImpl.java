package com.mangesh.persist;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mangesh.model.Employee;
import com.mangesh.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	Session session = null;
	Transaction transaction = null;
	boolean flag = false;
	Employee employee = null;

	public Employee getEmployee(int id) {

		try {
			session = HibernateUtil.getSession();
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null)
				employee = session.load(Employee.class, id);
			
			if (employee != null) {
				System.out.println("Student id is      :: " + employee.getEmployeeId());
				
				System.in.read();
				
				
				System.out.println("EMPLOYEE NAME IS    :: " + employee.getEmpolyeeName());
				System.out.println("EMPLOYEE EXPERIECS IS     :: " + employee.getExperience());
				System.out.println("EMPLOYEE SALARY IS :: " + employee.getSalary());
			} else
				System.out.println("Record not found for the given id :: " + id);
		   
      

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();

		}
		return employee;
	}

}
