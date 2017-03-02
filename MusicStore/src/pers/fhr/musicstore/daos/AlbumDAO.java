package pers.fhr.musicstore.daos;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import pers.fhr.musicstore.models.Album;

/**
 * A data access object (DAO) providing persistence and search support for Album
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see pers.fhr.musicstore.models.Album
 * @author MyEclipse Persistence Tools
 * @notice attachDirty  attachClean等很多dao里面方法还是用的自动生成  有错误
 */
@Repository
public class AlbumDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AlbumDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String PRICE = "price";
	public static final String ALBUM_ART_URL = "albumArtUrl";
	@SuppressWarnings("unchecked")
	public List<Album> getAlbumsOrderByOrderDetailsTopCount(int count){
		Session session=getSession();
		Query query=session.createQuery("from Album a order by a.orderdetails.size desc").setMaxResults(count);
		List<Album> albums=(List<Album>)query.list();
		return albums;
	}
	public Album save(Album transientInstance) {
		log.debug("saving Album instance");
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
	
	public Album update(Album transientInstance) {
		log.debug("updateing Album instance");
		try {
			getSession().clear();
			Transaction transaction=getSession().beginTransaction();
			getSession().update(transientInstance);
			transaction.commit();
			log.debug("update successful");
			getSession().close();
			return transientInstance;
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	public void delete(Album persistentInstance) {
		log.debug("deleting Album instance");
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
	public Album findById(java.lang.Integer id) {
		log.debug("getting Album instance with id: " + id);
		try {
			getSession().clear();
			Album instance = (Album) getSession().get("pers.fhr.musicstore.models.Album", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List findByExample(Album instance) {
		log.debug("finding Album instance by example");
		try {
			getSession().clear();
			List results = getSession().createCriteria("pers.fhr.musicstore.models.Album").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Album instance with property: " + propertyName + ", value: " + value);
		try {
			getSession().clear();
			String queryString = "from Album as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}
	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}
	public List findByAlbumArtUrl(Object albumArtUrl) {
		return findByProperty(ALBUM_ART_URL, albumArtUrl);
	}
	public List findAll() {
		log.debug("finding all Album instances");
		try {
			getSession().clear();
			String queryString = "from Album";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public Album merge(Album detachedInstance) {
		log.debug("merging Album instance");
		try {
			Transaction transaction=getSession().beginTransaction();
			Album result = (Album) getSession().merge(detachedInstance);
			transaction.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Album instance) {
		log.debug("attaching dirty Album instance");
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

	public void attachClean(Album instance) {
		log.debug("attaching clean Album instance");
		try {
			Transaction transaction=getSession().beginTransaction();
			getSession().lock(instance, LockMode.NONE);
			transaction.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}