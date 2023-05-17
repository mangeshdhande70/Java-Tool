package com.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.StudentInfoGEC;
import com.hibernate.util.HibernateUtil;

public class StudentDaoImpl implements IStudentDao {

	private Session session = null;
	private Transaction transaction = null;
	Integer id = null;

	public Integer addStudent(StudentInfoGEC student) {

		boolean flag = false;

		session = HibernateUtil.getSession();

		try {

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {

//				StudentInfoGEC student2 = new StudentInfoGEC();
//				student.setStudentName("Rakesh Pawar");
//				student.setBranch("Electrical");
//				student.setProjects(List.of("Electrical power", "Solar Panel", "Electricity through tree"));
//				student.setMarksSemWise(Map.of("sem1", 8.98f, "sem2", 9.00f, "sem3", 8.99f));
//				student.setContactNo(Set.of(7897655439L, 999999988L));

				id = (Integer) session.save(student);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
			} else {
				transaction.rollback();
			}
			HibernateUtil.closeSession(session);
		}
		return id;
	}

	public StudentInfoGEC findStudentById(Integer id) {

		StudentInfoGEC student = null;

		session = HibernateUtil.getSession();

		if (session != null)
			student = session.load(StudentInfoGEC.class, id);

		return student;
	}

}
