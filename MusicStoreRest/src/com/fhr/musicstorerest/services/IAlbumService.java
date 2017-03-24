package com.fhr.musicstorerest.services;

import java.util.List;

import com.fhr.musicstorerest.models.Album;

public interface IAlbumService {
    Album findAlbumById(int id);
    List<Album> findAlbums();
    List<Album> findAlbumsByTitle(String title);
    List<Album> findAlbumsByGenreId(int genreId);
    List<Album> findAlbumsByPriceInterval(double minPrice,double maxPrice);
    List<Album> findAlbums(String hql);
    Album createAlbum(Album album);
    Album editAlbum(Album album);
    void deleteAlbum(int id);
}
