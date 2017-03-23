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

import com.fhr.musicstorerest.models.Album;
import com.fhr.musicstorerest.models.Artist;

/**
 * 
 * @author fhr
 *
 */
@Repository
public class ArtistDAO extends HibernateBaseDao<Artist> {
	private static final Logger log = LoggerFactory.getLogger(ArtistDAO.class);
	// property constants
	public static final String NAME = "name";

	@Autowired
	public ArtistDAO(SessionFactory sessionFactory){
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	protected void initDao() {
		// do nothing
	}
	
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public static ArtistDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ArtistDAO) ctx.getBean("ArtistDAO");
	}
}