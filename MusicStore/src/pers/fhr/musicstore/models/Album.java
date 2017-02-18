package pers.fhr.musicstore.models;

import java.util.Set;

/**
 * Album entity. @author MyEclipse Persistence Tools
 */
public class Album extends AbstractAlbum implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Album() {
	}

	/** minimal constructor */
	public Album(Artist artist, Genre genre, String title, Double price) {
		super(artist, genre, title, price);
	}

	/** full constructor */
	public Album(Artist artist, Genre genre, String title, Double price, String albumArtUrl, Set carts,
			Set orderdetails) {
		super(artist, genre, title, price, albumArtUrl, carts, orderdetails);
	}

}
