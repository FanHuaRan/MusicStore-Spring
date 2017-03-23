package com.fhr.musicstorerest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fhr.musicstorerest.daos.AlbumDAO;
import com.fhr.musicstorerest.models.Album;
import com.fhr.musicstorerest.services.IAlbumService;;
@Service
public class AlbumServiceClass implements IAlbumService {
	@Autowired
	private AlbumDAO  albumDAO=null;
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
		 albumDAO.save(album);
		 return album;
	}
	@CacheEvict(value="albumCache", allEntries=true,beforeInvocation=true)
	@CachePut(value="albumCache",key="#result.albumId")
	@Override
	public Album editAlbum(Album album) {
		 albumDAO.update(album);
		 return album;
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
