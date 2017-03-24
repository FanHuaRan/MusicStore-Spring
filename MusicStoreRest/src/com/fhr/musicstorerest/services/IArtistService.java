package com.fhr.musicstorerest.services;

import java.util.List;

import com.fhr.musicstorerest.models.Artist;

public interface IArtistService {
	List<Artist> findArtists();
	Artist findArtistById(int id);
	List<Artist> findArtistByName(String name);
}
