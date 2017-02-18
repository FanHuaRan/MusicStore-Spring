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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void CreateAlbum(Album album) {
		// TODO Auto-generated method stub

	}

	@Override
	public void EditAlbum(Album album) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DeleteAlbum(int id) {
		// TODO Auto-generated method stub

	}

}
