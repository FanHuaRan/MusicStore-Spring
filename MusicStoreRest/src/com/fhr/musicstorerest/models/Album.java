package com.fhr.musicstorerest.models;

/**
 * Album entity. @author MyEclipse Persistence Tools
 */

public class Album implements java.io.Serializable {

	// Fields

	private Integer albumId;
	private Integer artistId;
	private Integer genreId;
	private String title;
	private Double price;
	private String albumArtUrl;
	// Constructors

	/** default constructor */
	public Album() {
	}

	/** minimal constructor */
	public Album(Integer artistId,Integer genreId,String title, Double price) {
		this.artistId = artistId;
		this.genreId = genreId;
		this.title = title;
		this.price = price;
	}

	/** full constructor */
	public Album(Integer artistId,Integer genreId,String title, Double price, String albumArtUrl) {
		this.artistId = artistId;
		this.genreId = genreId;
		this.title = title;
		this.price = price;
		this.albumArtUrl = albumArtUrl;
	}

	// Property accessors

	public Integer getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public Integer getArtistId() {
		return artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAlbumArtUrl() {
		return this.albumArtUrl;
	}

	public void setAlbumArtUrl(String albumArtUrl) {
		this.albumArtUrl = albumArtUrl;
	}
}