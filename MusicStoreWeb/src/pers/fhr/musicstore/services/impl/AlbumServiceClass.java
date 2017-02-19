package pers.fhr.musicstore.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.services.IAlbumService;
import pers.fhr.musicstore.daos.AlbumDAO;;
@Service
public class AlbumServiceClass implements IAlbumService {
	@Autowired
	private AlbumDAO  albumDao=null;
	@Override
	public List<Album> GetTopSellingAlbums(int count) {
		return albumDao.getAlbumsOrderByOrderDetailsTopCount(count);
	}

	@Override
	public Album FindAlbumById(int id) {
		return albumDao.findById(id);
	}

	@Override
	public List<Album> FindAlbums() {
		return albumDao.findAll();
	}

	@Override
	public void CreateAlbum(Album album) {
		albumDao.save(album);
	}

	@Override
	public void EditAlbum(Album album) {
		albumDao.update(album);
	}

	@Override
	public void DeleteAlbum(int id) {
		 Album album=albumDao.findById(id);
		 if(album!=null){
			 albumDao.delete(album);
		 }
	}

}
