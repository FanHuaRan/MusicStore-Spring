package com.fhr.musicstorerest.daos;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.fhr.musicstorerest.models.Oauthclient;


@Repository
public class OauthclientDAO extends HibernateBaseDao<Oauthclient> {
	private static final Logger log = LoggerFactory.getLogger(OauthclientDAO.class);
	
	// property constants
	public static final String CLIENT_ID = "clientId";
	public static final String CLIENT_SECRET = "clientSecret";
	@Autowired
	public OauthclientDAO(SessionFactory sessionFactory){
		super();
		this.setSessionFactory(sessionFactory);
	}
	protected void initDao() {
		// do nothing
	}

	public List findByClientId(Object clientId) {
		return findByProperty(CLIENT_ID, clientId);
	}

	public List findByClientSecret(Object clientSecret) {
		return findByProperty(CLIENT_SECRET, clientSecret);
	}
	public static OauthclientDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OauthclientDAO) ctx.getBean("OauthclientDAO");
	}
}