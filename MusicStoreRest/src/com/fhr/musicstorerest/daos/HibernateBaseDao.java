package com.fhr.musicstorerest.daos;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 * Hibernate Dao泛型基类
 * 基本的增删改查实现
 * @author fhr
 * @param <T>
 */
public class HibernateBaseDao<T extends Object> extends HibernateDaoSupport {
	protected static final Logger log = LoggerFactory.getLogger(HibernateBaseDao.class);
	//实体名
	private String entityName=null;
	//实体名带包
	private String entityFullName=null;
	
	@SuppressWarnings("unchecked")
	public HibernateBaseDao(){
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		Class<T> entityClass = (Class<T>) params[0];
		entityName = entityClass.getSimpleName();
		entityFullName = entityClass.getName();
	}
	
	protected void initDao() {
		// do nothing
	}
	public void save(T transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	public void update(T transientInstance) {
		try {
			getHibernateTemplate().update(transientInstance);
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	public void delete(T persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public void deleteByProperty(String propertyName, Object value) {
		try {
			List<T> instances=findByProperty(propertyName, value);
			for(T instance : instances){
				getHibernateTemplate().delete(instance);
			}
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void delete(Integer id) {
		try {
			T persistentInstance=findById(id);
			if(persistentInstance!=null){
				getHibernateTemplate().delete(persistentInstance);
			}
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public void deleteAll(){
		try {
			List<T> instances=findAll();
			for(T instance : instances){
				getHibernateTemplate().delete(instance);
			}
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public T findById(java.lang.Integer id) {
		try {
			T instance =(T)getHibernateTemplate().get(entityFullName, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List findAll() {
		try {
			String queryString = "from " +entityName;
			return  getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	@SuppressWarnings("deprecation")
	public List findTopNByHQL(String hql,int n){
		try{
			Query query=this.getSession().createQuery(hql);
			query.setFirstResult(n);
			List result=query.list();
			this.getSession().close();
			return result;
		}catch(RuntimeException re){
			log.error("find by "+hql+" name failed", re);
			throw re;
		}
	}
	@SuppressWarnings("deprecation")
	public List findByHQL(String hql){
		try{
			return getHibernateTemplate().find(hql);
		}catch(RuntimeException re){
			log.error("find by "+hql+" failed", re);
			throw re;
		}
	}
	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from "+entityName+" as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findByExample(T instance) {
		try {
			List results = getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public T merge(T detachedInstance) {
		try {
			T result = (T)getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(T instance) {
		try {
			 getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(T instance) {
		try {
			 getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
