package com.cg.payroll.daoservices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

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
	@Autowired(required=true)
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	@Override
	public int insertAssociate(Associate associate) throws SQLException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(associate);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return associate.getAssociateID();

	}

	@Override
	public boolean updateAssociate(Associate associate) throws SQLException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		associate = entityManager.merge(associate);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@Override
	public boolean deleteAssociate(int associateId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Associate assid=entityManager.find(Associate.class,associateId);
		entityManager.getTransaction().begin();
		if(assid!=null){
			entityManager.remove(assid);
		entityManager.flush();
		entityManager.getTransaction().commit();
		}
		entityManager.close();
		return true;
	}

	@Override
	public Associate getAssociate(int associateId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Associate.class,associateId);
	}

	@Override
	public List<Associate> getAssociates() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Associate> query = entityManager.createQuery("Select a from Associate a",Associate.class);
		return query.getResultList();
	}
	/*@Autowired
	private SessionFactory sessionFactory;
	 */
}