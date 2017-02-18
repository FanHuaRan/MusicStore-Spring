package pers.fhr.musicstore.services;

import java.util.List;

import pers.fhr.musicstore.models.Genre;

public interface IGenreService {
	 Genre FindGenreByName(String genreName);
     List<Genre> FindGenres();
}
