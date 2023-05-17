package com.ineuron.persis;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ineuron.model.Student;
import com.ineuron.util.HibernateUtil;

//Persistence logic using hibernate
public class StudentDaoImpl implements IStudentDao {

	Session session = HibernateUtil.getSession();

	@SuppressWarnings("finally")
	@Override
	public String addStudent(Student student) {
		System.out.println(student);

		Transaction transaction = null;
		Boolean flag = false;
		try {
			transaction = session.beginTransaction();
			session.save(student);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				return "success";
			} else {
				transaction.rollback();
				return "failure";
			}
		}
	}

	@Override
	public Student searchStudent(Integer sid) {

		Student student = session.get(Student.class, sid);

		if (student != null) {
			return student;
		}
		return null;
	}

	@Override
	public String deleteStudent(Integer sid) {
		Transaction transaction = null;
		boolean flag = false;

//		String idString = sid;

		Student student = session.get(Student.class, sid);

		if (student != null) {
			try {
				transaction = session.beginTransaction();

				if (transaction != null) {
					session.delete(student);
					flag = true;
					return "success";
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
			}
			return "failure";
		} else {
			return "Not found";
		}

	}

	@Override
	public String updateStudent(Student student) {

		boolean flag = false;
		Transaction transaction = null;
		Student student2 = null;

		student2 = session.get(Student.class, student.getId());

		if (student2 != null) {
			try {

				transaction = session.beginTransaction();

				if (transaction != null) {
					student2.setSaddress(student.getSaddress());
					student2.setSage(student.getSage());
					student2.setSname(student.getSname());
					session.update(student2);
					flag = true;
					return "success";
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
			}
			return "failure";

		} else {
			System.out.println("retunr not found");
			return "not found";
		}
	}
}