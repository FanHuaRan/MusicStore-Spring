package pers.fhr.musicstore.models;

import java.util.Set;

/**
 * Genre entity. @author MyEclipse Persistence Tools
 */
public class Genre extends AbstractGenre implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Genre() {
	}

	/** full constructor */
	public Genre(String name, String description, Set albums) {
		super(name, description, albums);
	}

}
