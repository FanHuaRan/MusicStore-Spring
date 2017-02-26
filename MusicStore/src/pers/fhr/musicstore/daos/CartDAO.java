package pers.fhr.musicstore.daos;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.fhr.musicstore.models.Cart;

/**
 * A data access object (DAO) providing persistence and search support for Cart
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see pers.fhr.musicstore.models.Cart
 * @author MyEclipse Persistence Tools
 */
@Repository
public class CartDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CartDAO.class);
	// property constants
	public static final String CART_ID = "cartId";
	public static final String COUNT = "count";

	public void save(Cart transientInstance) {
		log.debug("saving Cart instance");
		try {
			Transaction transaction=getSession().beginTransaction();
			getSession().save(transientInstance);
			transaction.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	public void update(Cart transientInstance) {
		log.debug("updateing Cart instance");
		try {
			getSession().clear();
			Transaction transaction=getSession().beginTransaction();
			getSession().update(transientInstance);
			transaction.commit();
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public void delete(Cart persistentInstance) {
		log.debug("deleting Cart instance");
		try {
			Transaction transaction=getSession().beginTransaction();
			getSession().delete(persistentInstance);
			transaction.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cart findById(java.lang.Integer id) {
		log.debug("getting Cart instance with id: " + id);
		try {
			Cart instance = (Cart) getSession().get("pers.fhr.musicstore.models.Cart", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Cart instance) {
		log.debug("finding Cart instance by example");
		try {
			List results = getSession().createCriteria("pers.fhr.musicstore.models.Cart").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Cart instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Cart as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List FindCartByCartIdAndAlbumId(String cartId, int albumId){
		log.debug("finding Cart instance with CartId And AlbumId: " + cartId + " " + albumId);
		try {
			String queryString = "from Cart as model where model.album.albumId=? and model.cartId=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, albumId);
			queryObject.setParameter(1, cartId);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("finding Cart instance with CartId And AlbumId failed", re);
			throw re;
		}
	}
	public List findByCartId(Object cartId) {
		return findByProperty(CART_ID, cartId);
	}

	public List findByCount(Object count) {
		return findByProperty(COUNT, count);
	}

	public List findAll() {
		log.debug("finding all Cart instances");
		try {
			String queryString = "from Cart";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cart merge(Cart detachedInstance) {
		log.debug("merging Cart instance");
		try {
			Transaction transaction=getSession().beginTransaction();
			Cart result = (Cart) getSession().merge(detachedInstance);
			transaction.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cart instance) {
		log.debug("attaching dirty Cart instance");
		try {
			Transaction transaction=getSession().beginTransaction();
			getSession().saveOrUpdate(instance);
			transaction.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cart instance) {
		log.debug("attaching clean Cart instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}