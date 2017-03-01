package pers.fhr.musicstore.services.impl;

import java.util.List;

import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.services.IAlbumService;
import pers.fhr.musicstore.daos.AlbumDAO;;
@Service
public class AlbumServiceClass implements IAlbumService {
	@Autowired
	private AlbumDAO  albumDAO=null;
	@Override
	@Cacheable(value="albumCache",key="#root.methodName")
	public List<Album> getTopSellingAlbums(int count) {
		return albumDAO.getAlbumsOrderByOrderDetailsTopCount(count);
	}
	@Cacheable(value="albumCache",key="#id")
	@Override
	public Album findAlbumById(int id) {
		return albumDAO.findById(id);
	}
	@SuppressWarnings("unchecked")
	@Cacheable(value="albumCache",key="#root.methodName")
	@Override
	public List<Album> findAlbums() {
		return albumDAO.findAll();
	}
	@CacheEvict(value="albumCache", allEntries=true,beforeInvocation=true)
	@CachePut(value="albumCache",key="#result.albumId")
	@Override
	public Album createAlbum(Album album) {
		return albumDAO.save(album);
	}
	@CacheEvict(value="albumCache", allEntries=true,beforeInvocation=true)
	@CachePut(value="albumCache",key="#result.albumId")
	@Override
	public Album editAlbum(Album album) {
		return albumDAO.update(album);
	}
	//清除albumCache中的所有缓存
	@CacheEvict(value="albumCache",allEntries=true)
	@Override
	public void deleteAlbum(int id) {
		 Album album=albumDAO.findById(id);
		 if(album!=null){
			 albumDAO.delete(album);
		 }
	}

}
