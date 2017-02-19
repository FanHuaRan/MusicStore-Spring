package pers.fhr.musicstore.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fhr.musicstore.daos.GenreDAO;
import pers.fhr.musicstore.models.Genre;
import pers.fhr.musicstore.services.IGenreService;
@Service
public class GenreServiceClass implements IGenreService {
	@Autowired
	private GenreDAO genreDAO=null;
	@Override
	public Genre FindGenreByName(String genreName) {
		List<Genre> genres=genreDAO.findByName(genreName);
		return genres.size()==0?null:genres.get(0);
	}

	@Override
	public List<Genre> FindGenres() {
		return genreDAO.findAll();
	}

}
