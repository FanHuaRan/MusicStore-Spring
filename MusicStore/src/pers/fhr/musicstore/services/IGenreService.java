package pers.fhr.musicstore.services;

import java.util.List;
import java.util.Set;

public interface IGenreService {
	 Genre FindGenreByName(String genreName);
     Set<Genre> FindGenres();
}
