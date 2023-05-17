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
				employee = session.get(Employee.class, id);

			transaction.commit();

			

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
