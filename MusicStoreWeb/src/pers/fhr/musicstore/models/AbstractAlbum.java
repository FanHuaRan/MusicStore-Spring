package pers.fhr.musicstore.models;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractAlbum entity provides the base persistence definition of the Album
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAlbum implements java.io.Serializable {

	// Fields

	private Integer albumId;
	private Integer artistId;
	private Integer genreId;
	private Artist artist;
	private Genre genre;
	private String title;
	private Double price;
	private String albumArtUrl;
	private Set carts = new HashSet(0);
	private Set orderdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractAlbum() {
	}

	/** minimal constructor */
	public AbstractAlbum(Artist artist, Genre genre, String title, Double price) {
		this.artist = artist;
		this.genre = genre;
		this.title = title;
		this.price = price;
	}

	/** full constructor */
	public AbstractAlbum(Artist artist, Genre genre, String title, Double price, String albumArtUrl, Set carts,
			Set orderdetails) {
		this.artist = artist;
		this.genre = genre;
		this.title = title;
		this.price = price;
		this.albumArtUrl = albumArtUrl;
		this.carts = carts;
		this.orderdetails = orderdetails;
	}

	// Property accessors

	public Integer getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	public Integer getArtistId(){
		return this.artistId;
	}
	public void setArtistId(Integer artistId){
		this.artistId=artistId;
	}
	public Integer getGenreId(){
		return this.genreId;
	}
	public void setGenreId(Integer genreId){
		this.genreId=genreId;
	}
	public Artist getArtist() {
		return this.artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return this.title;
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

	public Set getCarts() {
		return this.carts;
	}

	public void setCarts(Set carts) {
		this.carts = carts;
	}

	public Set getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set orderdetails) {
		this.orderdetails = orderdetails;
	}

}