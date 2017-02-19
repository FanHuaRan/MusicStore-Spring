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
	public List<Album> GetTopSellingAlbums(int count) {
		return albumDAO.getAlbumsOrderByOrderDetailsTopCount(count);
	}

	@Override
	public Album FindAlbumById(int id) {
		return albumDAO.findById(id);
	}

	@Override
	public List<Album> FindAlbums() {
		return albumDAO.findAll();
	}

	@Override
	public void CreateAlbum(Album album) {
		albumDAO.save(album);
	}

	@Override
	public void EditAlbum(Album album) {
		albumDAO.update(album);
	}

	@Override
	public void DeleteAlbum(int id) {
		 Album album=albumDAO.findById(id);
		 if(album!=null){
			 albumDAO.delete(album);
		 }
	}

}
