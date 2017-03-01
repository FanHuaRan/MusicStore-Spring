package pers.fhr.musicstore.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import pers.fhr.musicstore.daos.GenreDAO;
import pers.fhr.musicstore.models.Genre;
import pers.fhr.musicstore.services.IGenreService;
@Service
public class GenreServiceClass implements IGenreService {
	@Autowired
	private GenreDAO genreDAO=null;
	
	@Cacheable(value="genreCache",key="#genreName")
	@Override
	public Genre findGenreByName(String genreName) {
		List<Genre> genres=genreDAO.findByName(genreName);
		return genres.size()==0?null:genres.get(0);
	}
	@Cacheable(value="genreCache",key="#root.methodName")
	@Override
	public List<Genre> findGenres() {
		return genreDAO.findAll();
	}

}
