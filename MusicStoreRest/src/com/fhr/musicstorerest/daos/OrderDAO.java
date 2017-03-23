package com.fhr.musicstorerest.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.fhr.musicstorerest.models.Order;

/**
 * 
 * @author fhr
 *
 */
@Repository
public class OrderDAO extends HibernateBaseDao<Order> {
	private static final Logger log = LoggerFactory.getLogger(OrderDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String ADDRESS = "address";
	public static final String CITY = "city";
	public static final String STATE = "state";
	public static final String POSTAL_CODE = "postalCode";
	public static final String COUNTRY = "country";
	public static final String PHONE = "phone";
	public static final String EMAIL = "email";
	public static final String TOTAL = "total";
	
	@Autowired
	public OrderDAO(SessionFactory sessionFactory){
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	protected void initDao() {
		// do nothing
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}

	public List findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByPostalCode(Object postalCode) {
		return findByProperty(POSTAL_CODE, postalCode);
	}

	public List findByCountry(Object country) {
		return findByProperty(COUNTRY, country);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByTotal(Object total) {
		return findByProperty(TOTAL, total);
	}

	public static OrderDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OrderDAO) ctx.getBean("OrderDAO");
	}
}