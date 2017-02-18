package pers.fhr.musicstore.services;

import java.util.List;

import pers.fhr.musicstore.models.Album;

public interface IAlbumService {
	List<Album> GetTopSellingAlbums(int count);
    Album FindAlbumById(int id);
    List<Album> FindAlbums();
    void CreateAlbum(Album album);
    void EditAlbum(Album album);
    void DeleteAlbum(int id);
}
