package pers.fhr.musicstore.services;

import java.util.List;

import pers.fhr.musicstore.models.Album;

public interface IAlbumService {
	List<Album> getTopSellingAlbums(int count);
    Album findAlbumById(int id);
    List<Album> findAlbums();
    Album createAlbum(Album album);
    Album editAlbum(Album album);
    void deleteAlbum(int id);
}
