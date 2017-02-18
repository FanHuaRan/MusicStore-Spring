package pers.fhr.musicstore.models;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
public class Order extends AbstractOrder implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(Timestamp orderDate, String firstName, String lastName, String address, String city, String state,
			String postalCode, String country, String phone, String email, Double total) {
		super(orderDate, firstName, lastName, address, city, state, postalCode, country, phone, email, total);
	}

	/** full constructor */
	public Order(String username, Timestamp orderDate, String firstName, String lastName, String address, String city,
			String state, String postalCode, String country, String phone, String email, Double total,
			Set orderdetails) {
		super(username, orderDate, firstName, lastName, address, city, state, postalCode, country, phone, email, total,
				orderdetails);
	}

}
