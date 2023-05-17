package com.hibernate.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernate.model.PersonInfo;
import com.hibernate.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				int id = 10;
				PersonInfo personInfo = session.get(PersonInfo.class, id);
				if (personInfo != null) {
					System.out.println(personInfo);
				}else {
					System.out.println("Record not available for the given id:: "+id);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
