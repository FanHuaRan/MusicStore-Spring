package pers.fhr.musicstore.daos;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.fhr.musicstore.models.Genre;

/**
 * A data access object (DAO) providing persistence and search support for Genre
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see pers.fhr.musicstore.models.Genre
 * @author MyEclipse Persistence Tools
 */
@Repository
public class GenreDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(GenreDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";

	public Genre save(Genre transientInstance) {
		log.debug("saving Genre instance");
		try {
			Transaction transaction=getSession().beginTransaction();
			getSession().save(transientInstance);
			transaction.commit();
			log.debug("save successful");
			getSession().close();
			return transientInstance;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Genre persistentInstance) {
		log.debug("deleting Genre instance");
		try {
			Transaction transaction=getSession().beginTransaction();
			getSession().delete(persistentInstance);
			transaction.commit();
			log.debug("delete successful");
			getSession().close();
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Genre findById(java.lang.Integer id) {
		log.debug("getting Genre instance with id: " + id);
		try {
			getSession().clear();
			Genre instance = (Genre) getSession().get("pers.fhr.musicstore.models.Genre", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Genre instance) {
		log.debug("finding Genre instance by example");
		try {
			getSession().clear();
			List results = getSession().createCriteria("pers.fhr.musicstore.models.Genre").add(Example.create(instance))
					.list();
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
			getSession().clear();
			String queryString = "from Genre as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
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
			getSession().clear();
			String queryString = "from Genre";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Genre merge(Genre detachedInstance) {
		log.debug("merging Genre instance");
		try {
			Transaction transaction=getSession().beginTransaction();
			Genre result = (Genre) getSession().merge(detachedInstance);
			transaction.commit();
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
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Genre instance) {
		log.debug("attaching clean Genre instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}