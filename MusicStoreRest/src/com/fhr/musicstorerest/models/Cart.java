package com.fhr.musicstorerest.models;

import java.sql.Timestamp;

/**
 * Cart entity. @author MyEclipse Persistence Tools
 */

public class Cart implements java.io.Serializable {

	// Fields

	private Integer recordId;
	private Album album;
	private String cartId;
	private Integer count;
	private Timestamp dateCreated;

	// Constructors

	/** default constructor */
	public Cart() {
	}

	/** minimal constructor */
	public Cart(Album album, Integer count, Timestamp dateCreated) {
		this.album = album;
		this.count = count;
		this.dateCreated = dateCreated;
	}

	/** full constructor */
	public Cart(Album album, String cartId, Integer count, Timestamp dateCreated) {
		this.album = album;
		this.cartId = cartId;
		this.count = count;
		this.dateCreated = dateCreated;
	}

	// Property accessors

	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getCartId() {
		return this.cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

}