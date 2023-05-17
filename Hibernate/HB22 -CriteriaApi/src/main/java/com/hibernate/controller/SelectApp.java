package com.hibernate.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hibernate.model.InsurancePolicy;
import com.hibernate.util.HibernateUtil;

public class SelectApp {
	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSession();

			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(InsurancePolicy.class);
			
			ProjectionList projectionList = Projections.projectionList();
			
			projectionList.add(Projections.property("policyType"));
			projectionList.add(Projections.property("company"));
			
			criteria.setProjection(projectionList);
			Criterion cond1 = Restrictions.ge("tenure", 3);
			criteria.add(cond1);
			Order order = Order.asc("policyName");
			criteria.addOrder(order);
			List<Object[]> policies = criteria.list();
			

			System.out.println("policyType\tcompany");
			policies.forEach(row -> {
				for (Object object : row) {
					System.out.print(object + "\t\t");
				}
				System.out.println();
			});

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
