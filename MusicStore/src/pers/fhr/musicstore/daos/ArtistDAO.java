package pers.fhr.musicstore.daos;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.fhr.musicstore.models.Artist;

/**
 * A data access object (DAO) providing persistence and search support for
 * Artist entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pers.fhr.musicstore.models.Artist
 * @author MyEclipse Persistence Tools
 */
@Repository
public class ArtistDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ArtistDAO.class);
	// property constants
	public static final String NAME = "name";

	public Artist save(Artist transientInstance) {
		log.debug("saving Artist instance");
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

	public void delete(Artist persistentInstance) {
		log.debug("deleting Artist instance");
		try {
			getSession().clear();
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

	public Artist findById(java.lang.Integer id) {
		log.debug("getting Artist instance with id: " + id);
		try {
			getSession().clear();
			Artist instance = (Artist) getSession().get("pers.fhr.musicstore.models.Artist", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Artist instance) {
		log.debug("finding Artist instance by example");
		try {
			getSession().clear();
			List results = getSession().createCriteria("pers.fhr.musicstore.models.Artist")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Artist instance with property: " + propertyName + ", value: " + value);
		try {
			getSession().clear();
			String queryString = "from Artist as model where model." + propertyName + "= ?";
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

	public List findAll() {
		log.debug("finding all Artist instances");
		try {
			getSession().clear();
			String queryString = "from Artist";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Artist merge(Artist detachedInstance) {
		log.debug("merging Artist instance");
		try {
			Transaction transaction=getSession().beginTransaction();
			Artist result=(Artist)getSession().merge(detachedInstance);
			transaction.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Artist instance) {
		log.debug("attaching dirty Artist instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Artist instance) {
		log.debug("attaching clean Artist instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}