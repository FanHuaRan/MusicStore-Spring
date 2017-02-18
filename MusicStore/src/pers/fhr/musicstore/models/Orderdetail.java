package pers.fhr.musicstore.models;

/**
 * Orderdetail entity. @author MyEclipse Persistence Tools
 */
public class Orderdetail extends AbstractOrderdetail implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Orderdetail() {
	}

	/** full constructor */
	public Orderdetail(Album album, Order order, Integer quantity, Double unitPrice) {
		super(album, order, quantity, unitPrice);
	}

}
