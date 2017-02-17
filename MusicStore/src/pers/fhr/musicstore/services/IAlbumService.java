package pers.fhr.musicstore.services;

import java.util.List;

public interface IAlbumService {
	Set<Album> GetTopSellingAlbums(int count);
    Album FindAlbumById(int id);
    Set<Album> FindAlbums();
    void CreateAlbum(Album album);
    void EditAlbum(Album album);
    void DeleteAlbum(Int32 id);
}
