package com.fhr.musicstorerest.component;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * GenreNotFound异常
 * @author fhr
 * @date 2017/05/03
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Genre")  // 404
public class GenreNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int genreId;

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public GenreNotFoundException(int genreId) {
		super();
		this.genreId = genreId;
	}
}
