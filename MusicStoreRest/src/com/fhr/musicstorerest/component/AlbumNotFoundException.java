package com.fhr.musicstorerest.component;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * AlbumNotFoundException异常
 * ResponseStatus在此是非必需的
 * @author fhr
 * @date 2017/05/03
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Album")  // 404
public class AlbumNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int albumId;

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public AlbumNotFoundException(int albumId) {
		super();
		this.albumId = albumId;
	}	
}
