package com.fhr.musicstorerest.models;

import java.util.HashSet;
import java.util.Set;

/**
 * Artist entity. @author MyEclipse Persistence Tools
 */

public class Artist implements java.io.Serializable {

	// Fields

	private Integer artistId;
	private String name;
	private Set albums = new HashSet(0);

	// Constructors

	/** default constructor */
	public Artist() {
	}

	/** full constructor */
	public Artist(String name, Set albums) {
		this.name = name;
		this.albums = albums;
	}

	// Property accessors

	public Integer getArtistId() {
		return this.artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getAlbums() {
		return this.albums;
	}

	public void setAlbums(Set albums) {
		this.albums = albums;
	}

}