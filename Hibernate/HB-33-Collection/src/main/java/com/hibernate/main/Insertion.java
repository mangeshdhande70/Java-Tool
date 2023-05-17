package com.hibernate.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtilClass;


public class Insertion {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		session = HibernateUtilClass.getSession();
	
		
		try {	
			
			
			if (session!=null)
				transaction = session.beginTransaction();
			
			if (transaction != null) {
				Employee employee = new Employee();
				employee.setEmployeeId(10);
				employee.setEmployeeName("Jayant Karemore");
				
//				List<String> list = new ArrayList<>();
//				list.add("Mangesh");
//				list.add("Shubham");
//				
//				Set<Long> set = new HashSet<>();
//				set.add(1234567898765L);
//				set.add(12345678765432L);
//				
//				
//				Map<String, Long> map = new HashMap<>();
//				map.put("ICICI" , 1244L);
//				map.put("SBI", 9865456L);
//				
//				
//				employee.setFreindList(list);
//				employee.setBankAccount(map);
//				employee.setContactNo(set);
				
				

				employee.setFreindList(List.of("Mangesh", "Shubham", "Rakesh"));
				employee.setContactNo(Set.of(8765320989L, 1234567899L, 9876567898L));
				employee.setBankAccount(Map.of("ICICI", 1230L, "AXIS", 10989L));
				
				session.save(employee);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object added successfully");
			} else {
				transaction.rollback();
				System.out.println("Faild to added object in DB");
			}

			HibernateUtilClass.closeSession(session);
			HibernateUtilClass.closeSessionFactory();
		}

	}

}
