package com.fhr.musicstorerest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fhr.musicstorerest.daos.GenreDAO;
import com.fhr.musicstorerest.models.Genre;
import com.fhr.musicstorerest.services.IGenreService;
@Service
public class GenreServiceClass implements IGenreService {
	@Autowired
	private GenreDAO genreDAO=null;
	
	@Cacheable(value="genreCache",key="#genreName")
	@Override
	public List<Genre> findGenreByName(String genreName) {
		return genreDAO.findByName(genreName);
	}
	@Cacheable(value="genreCache",key="#root.methodName")
	@Override
	public List<Genre> findGenres() {
		return genreDAO.findAll();
	}
	@Override
	public Genre findGenreById(int id) {
		return genreDAO.findById(id);
	}

}
