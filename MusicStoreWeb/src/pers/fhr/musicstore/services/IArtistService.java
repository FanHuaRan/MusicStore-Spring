package pers.fhr.musicstore.services;

import java.util.List;

import pers.fhr.musicstore.models.Artist;

public interface IArtistService {
	List<Artist> findArtists();
	Artist findArtistById(int id);
}
