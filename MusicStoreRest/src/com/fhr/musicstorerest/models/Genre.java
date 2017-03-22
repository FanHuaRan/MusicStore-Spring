package com.fhr.musicstorerest.models;

import java.util.HashSet;
import java.util.Set;

/**
 * Genre entity. @author MyEclipse Persistence Tools
 */

public class Genre implements java.io.Serializable {

	// Fields

	private Integer genreId;
	private String name;
	private String description;
	private Set albums = new HashSet(0);

	// Constructors

	/** default constructor */
	public Genre() {
	}

	/** full constructor */
	public Genre(String name, String description, Set albums) {
		this.name = name;
		this.description = description;
		this.albums = albums;
	}

	// Property accessors

	public Integer getGenreId() {
		return this.genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getAlbums() {
		return this.albums;
	}

	public void setAlbums(Set albums) {
		this.albums = albums;
	}

}