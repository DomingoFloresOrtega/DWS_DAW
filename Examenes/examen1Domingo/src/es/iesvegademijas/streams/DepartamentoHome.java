package es.iesvegademijas.streams;
// Generated 28 oct. 2022 5:19:18 by Hibernate Tools 5.6.9.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;


/**
 * Home object for domain model class Departamento.
 * @see es.iesvegademijas.streams.Departamento
 * @author Hibernate Tools
 */
public class DepartamentoHome {

	

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception e) {
			throw new IllegalStateException("No puedo crear SessionFactory");
		}
	}

	public void beginTransaction() {
		sessionFactory.getCurrentSession().beginTransaction();
	}

	public void commitTransaction() {
		sessionFactory.getCurrentSession().getTransaction().commit();
	}

	public void rollbackTransaction() {
		sessionFactory.getCurrentSession().getTransaction().rollback();
	}

	public List<Departamento> findAll() {
		List<Departamento> lstDep = null;

		lstDep = sessionFactory.getCurrentSession().createQuery("SELECT d FROM Departamento d", Departamento.class)
				.getResultList();

		return lstDep;
	}
}
