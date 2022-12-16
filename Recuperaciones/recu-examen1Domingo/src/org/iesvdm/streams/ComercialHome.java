package org.iesvdm.streams;
// Generated 15 dic. 2022 23:59:33 by Hibernate Tools 5.6.9.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Comercial.
 * @see org.iesvdm.streams.Comercial
 * @author Hibernate Tools
 */
public class ComercialHome {

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

	public List<Comercial> findAll() {
		List<Comercial> lst = null;

		lst = sessionFactory.getCurrentSession().createQuery("SELECT c FROM Comercial c", Comercial.class)
				.getResultList();

		return lst;
	}
}
