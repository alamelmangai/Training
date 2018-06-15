package com.cg.payroll.daoservices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.exceptions.PayrollServicesDownExceptions;
import com.cg.payroll.utility.AssociateMapper;
import com.cg.payroll.utility.PayrollUtility;
@Component("payrollDAOServices")
public class PayrollDAOServicesImpl implements PayrollDAOServices{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insertAssociate(Associate associate) throws SQLException {
		Session session =  sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			Integer AssociateId = (Integer) session.save(associate);
			tx.commit();
			return AssociateId;
		}
			catch (HibernateException e) {
				tx.rollback();
				throw e;}
			finally {
				session.close();
			}
	}

	@Override
	public boolean updateAssociate(Associate associate) throws SQLException {
		Session session =  sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			session.update(associate);
			tx.commit();
			return true;
		}
			catch (HibernateException e) {
				tx.rollback();
				throw e;}
			finally {
				session.close();
			}
	}


	@Override
	public boolean deleteAssociate(int associateId) {
		Session session =  sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			Associate associate=(Associate) session.get(Associate.class, associateId);
			session.delete(associate);
			tx.commit();
			return true;
		}
			catch (HibernateException e) {
				tx.rollback();
				throw e;}
			finally {
				session.close();
			}
	}

	@Override
	public Associate getAssociate(int associateID) {
		return (Associate) sessionFactory.openSession().get(Associate.class, associateID);
	}
	@Override
	public List<Associate> getAssociates() {
		return sessionFactory.openSession().createQuery("FROM Associate").list();
	}

}