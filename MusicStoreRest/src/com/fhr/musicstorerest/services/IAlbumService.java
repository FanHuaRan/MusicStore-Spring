package com.fhr.musicstorerest.services;

import java.util.List;

import com.fhr.musicstorerest.models.Album;

public interface IAlbumService {
    Album findAlbumById(int id);
    List<Album> findAlbums();
    Album createAlbum(Album album);
    Album editAlbum(Album album);
    void deleteAlbum(int id);
}
