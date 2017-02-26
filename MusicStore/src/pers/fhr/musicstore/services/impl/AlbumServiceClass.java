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
	private AlbumDAO  albumDAO=null;
	@Override
	public List<Album> getTopSellingAlbums(int count) {
		return albumDAO.getAlbumsOrderByOrderDetailsTopCount(count);
	}

	@Override
	public Album findAlbumById(int id) {
		return albumDAO.findById(id);
	}

	@Override
	public List<Album> findAlbums() {
		return albumDAO.findAll();
	}

	@Override
	public void createAlbum(Album album) {
		albumDAO.save(album);
	}

	@Override
	public void editAlbum(Album album) {
		albumDAO.update(album);
	}

	@Override
	public void deleteAlbum(int id) {
		 Album album=albumDAO.findById(id);
		 if(album!=null){
			 albumDAO.delete(album);
		 }
	}

}
