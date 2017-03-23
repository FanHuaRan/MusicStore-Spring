package com.fhr.musicstorerest.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.fhr.musicstorerest.models.Cart;
/**
 * 
 * @author fhr
 *
 */
@Repository
public class CartDAO extends HibernateBaseDao<Cart> {
	private static final Logger log = LoggerFactory.getLogger(CartDAO.class);
	// property constants
	public static final String CART_ID = "cartId";
	public static final String COUNT = "count";

	@Autowired
	public CartDAO(SessionFactory sessionFactory){
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	protected void initDao() {
		// do nothing
	}

	public List findByCartId(Object cartId) {
		return findByProperty(CART_ID, cartId);
	}

	public List findByCount(Object count) {
		return findByProperty(COUNT, count);
	}

	public static CartDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CartDAO) ctx.getBean("CartDAO");
	}
}