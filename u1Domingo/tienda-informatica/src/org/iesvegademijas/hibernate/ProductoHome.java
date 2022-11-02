package org.iesvegademijas.hibernate;
// Generated 9 oct. 2022 14:12:31 by Hibernate Tools 5.6.9.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Producto.
 * 
 * @see org.iesvegademijas.hibernate.Producto
 * @author Hibernate Tools
 */
public class ProductoHome {

	private static final Logger logger = Logger.getLogger(ProductoHome.class.getName());

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

	public List<Producto> findAll() {

		List<Producto> lstProd = null;

		lstProd = sessionFactory.getCurrentSession().createQuery("SELECT p FROM Producto p", Producto.class)
				.getResultList();

		return lstProd;

	}

}
