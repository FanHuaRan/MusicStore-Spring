package pers.fhr.musicstore.models;

import java.sql.Timestamp;

/**
 * Cart entity. @author MyEclipse Persistence Tools
 */
public class Cart extends AbstractCart implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Cart() {
	}

	/** minimal constructor */
	public Cart(Album album, Integer count, Timestamp dateCreated) {
		super(album, count, dateCreated);
	}

	/** full constructor */
	public Cart(Album album, String cartId, Integer count, Timestamp dateCreated) {
		super(album, cartId, count, dateCreated);
	}

}
