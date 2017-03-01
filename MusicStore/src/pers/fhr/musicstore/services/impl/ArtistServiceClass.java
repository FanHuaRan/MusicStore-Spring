package pers.fhr.musicstore.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import pers.fhr.musicstore.daos.ArtistDAO;
import pers.fhr.musicstore.models.Artist;
import pers.fhr.musicstore.services.IArtistService;
@Service
public class ArtistServiceClass implements IArtistService {
	@Autowired
	private ArtistDAO artistDAO=null;
	
	@SuppressWarnings("unchecked")
	@Cacheable(value="artistCache",key="#root.methodName")
	@Override
	public List<Artist> findArtists() {
		return artistDAO.findAll();
	}
	
	@Cacheable(value="artistCache",key="#id")
	@Override
	public Artist findArtistById(int id) {
		return artistDAO.findById(id);
	}

}
