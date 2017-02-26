package pers.fhr.musicstore.services;

import java.util.List;

import pers.fhr.musicstore.models.Genre;

public interface IGenreService {
	 Genre findGenreByName(String genreName);
     List<Genre> findGenres();
}
