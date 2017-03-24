package com.fhr.musicstorerest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fhr.musicstorerest.daos.ArtistDAO;
import com.fhr.musicstorerest.models.Artist;
import com.fhr.musicstorerest.services.IArtistService;
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

	@Override
	public List<Artist> findArtistByName(String name) {
		return artistDAO.findByName(name);
	}

}
