package com.fhr.musicstorerest.models;

/**
 * Genre entity. @author MyEclipse Persistence Tools
 */

public class Genre implements java.io.Serializable {

	// Fields

	private Integer genreId;
	private String name;
	private String description;

	// Constructors

	/** default constructor */
	public Genre() {
	}

	/** full constructor */
	public Genre(String name, String description) {
		this.name = name;
		this.description = description;
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
}