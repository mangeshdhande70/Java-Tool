package com.mangesh.persist;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mangesh.model.EmployeeDynamic;
import com.mangesh.util.HibernateUtil;


public class EmployeeDaoImpl implements EmployeeDao{
	
	Session session = null;
	Transaction transaction = null;
	boolean flag = false;

	public void addEmployee(EmployeeDynamic employee) {

		try {
			session = HibernateUtil.getSession();
	        if (session!=null) 
	    	  transaction = session.beginTransaction();
			
	        
	        if (transaction!=null) {
	        	session.save(employee);
	        	flag=true;
			}
		
		}catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if (flag) {
				transaction.commit();
				System.out.println("Data Save Successfully");
			}
	        else { 
				transaction.rollback();
				System.out.println("Data Not Save in DB");
	        }
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
				
		}
		
		
	}
	
	
	
	

}
