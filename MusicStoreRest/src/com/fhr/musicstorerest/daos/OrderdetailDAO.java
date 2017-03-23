package com.fhr.musicstorerest.daos;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.fhr.musicstorerest.models.Orderdetail;

/**
 * 
 * @author fhr
 *
 */
@Repository
public class OrderdetailDAO extends HibernateBaseDao<Orderdetail> {
	private static final Logger log = LoggerFactory.getLogger(OrderdetailDAO.class);
	// property constants
	public static final String QUANTITY = "quantity";
	public static final String UNIT_PRICE = "unitPrice";

	@Autowired
	public OrderdetailDAO(SessionFactory sessionFactory){
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	protected void initDao() {
		// do nothing
	}

	public List findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	public List findByUnitPrice(Object unitPrice) {
		return findByProperty(UNIT_PRICE, unitPrice);
	}

	public static OrderdetailDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OrderdetailDAO) ctx.getBean("OrderdetailDAO");
	}
}