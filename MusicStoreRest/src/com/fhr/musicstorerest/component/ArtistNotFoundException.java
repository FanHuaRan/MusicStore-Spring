package com.fhr.musicstorerest.component;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * ArtistNotFound异常
 * @author fhr
 * @date 2017/05/03
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Artist")  // 404
public class ArtistNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int artistId;

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public ArtistNotFoundException(int artistId) {
		super();
		this.artistId = artistId;
	}
}
