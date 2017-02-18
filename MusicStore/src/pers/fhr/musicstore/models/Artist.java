package pers.fhr.musicstore.models;

import java.util.Set;

/**
 * Artist entity. @author MyEclipse Persistence Tools
 */
public class Artist extends AbstractArtist implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Artist() {
	}

	/** full constructor */
	public Artist(String name, Set albums) {
		super(name, albums);
	}

}
