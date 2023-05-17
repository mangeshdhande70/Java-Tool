package com.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.model.BankAccount;
import com.hibernate.util.HibernateUtil;

public class BankAccountDaoImpl implements IBankAccountDao {

	Session session = HibernateUtil.getSession();

	@SuppressWarnings("unchecked")
	@Override
	public List<BankAccount> getPageData(int pageSize, int startPos) {

		List<BankAccount> list = null;

		try {
			Query<BankAccount> query = session.getNamedQuery("GET_ALL_ACCOUNTS");

			// Performing Pagination
			query.setFirstResult(startPos);// 0,3,6
			query.setMaxResults(pageSize); // 3

			// Execution of Query
			list = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Long getTotalRecordCount() {
		Long count = 0L;

		try {

			Query query = session.getNamedQuery("GET_ACCOUNT_COUNT");
			List list = query.list();
			count = (Long) list.get(0);
			System.out.println(count);

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
