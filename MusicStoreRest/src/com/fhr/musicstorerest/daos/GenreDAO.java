package com.fhr.musicstorerest.daos;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fhr.musicstorerest.models.Genre;

/**
 * A data access object (DAO) providing persistence and search support for Genre
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.fhr.musicstorerest.models.Genre
 * @author MyEclipse Persistence Tools
 */
public class GenreDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(GenreDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";

	protected void initDao() {
		// do nothing
	}

	public void save(Genre transientInstance) {
		log.debug("saving Genre instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Genre persistentInstance) {
		log.debug("deleting Genre instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Genre findById(java.lang.Integer id) {
		log.debug("getting Genre instance with id: " + id);
		try {
			Genre instance = (Genre) getHibernateTemplate().get("com.fhr.musicstorerest.models.Genre", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Genre instance) {
		log.debug("finding Genre instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Genre instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Genre as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all Genre instances");
		try {
			String queryString = "from Genre";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Genre merge(Genre detachedInstance) {
		log.debug("merging Genre instance");
		try {
			Genre result = (Genre) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Genre instance) {
		log.debug("attaching dirty Genre instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Genre instance) {
		log.debug("attaching clean Genre instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GenreDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GenreDAO) ctx.getBean("GenreDAO");
	}
}