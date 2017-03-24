package com.fhr.musicstorerest.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.fhr.musicstorerest.models.Album;

/**
 * 
 * @author fhr
 *
 */
@Repository
public class AlbumDAO extends HibernateBaseDao<Album> {
	private static final Logger log = LoggerFactory.getLogger(AlbumDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String PRICE = "price";
	public static final String ALBUM_ART_URL = "albumArtUrl";
	public static final String GENRE_Id="genreId";
	public static final String ARTIST_Id="artistId";
	@Autowired
	public AlbumDAO(SessionFactory sessionFactory){
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	protected void initDao() {
		// do nothing
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByArtistId(Object artistId) {
		return findByProperty(ARTIST_Id, artistId);
	}
	
	public List findByGenreId(Object genreId) {
		return findByProperty(GENRE_Id, genreId);
	}
	public List findByAlbumArtUrl(Object albumArtUrl) {
		return findByProperty(ALBUM_ART_URL, albumArtUrl);
	}
	public List findAll() {
		log.debug("finding all Album instances");
		try {
			String queryString = "from Album";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public static AlbumDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AlbumDAO) ctx.getBean("AlbumDAO");
	}
}