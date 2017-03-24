package com.fhr.musicstorerest.services;

import java.util.List;

import com.fhr.musicstorerest.models.Genre;

public interface IGenreService {
	 List<Genre> findGenreByName(String genreName);
     List<Genre> findGenres();
     Genre findGenreById(int id);
}
