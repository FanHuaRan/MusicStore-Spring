package com.fhr.musicstorerest.daos;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.fhr.musicstorerest.models.Genre;

/**
 * 
 * @author fhr
 *
 */
@Repository
public class GenreDAO extends HibernateBaseDao<Genre> {
	private static final Logger log = LoggerFactory.getLogger(GenreDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";

	@Autowired
	public GenreDAO(SessionFactory sessionFactory){
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	protected void initDao() {
		// do nothing
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public static GenreDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GenreDAO) ctx.getBean("GenreDAO");
	}
}