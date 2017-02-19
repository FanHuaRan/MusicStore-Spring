package pers.fhr.musicstore.models;

/**
 * AbstractOrderdetail entity provides the base persistence definition of the
 * Orderdetail entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOrderdetail implements java.io.Serializable {

	// Fields

	private Integer orderDetailId;
	private Integer albumId;
	private Integer orderId;
	private Album album;
	private Order order;
	private Integer quantity;
	private Double unitPrice;

	// Constructors

	/** default constructor */
	public AbstractOrderdetail() {
	}

	/** full constructor */
	public AbstractOrderdetail(Album album, Order order, Integer quantity, Double unitPrice) {
		this.album = album;
		this.order = order;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	// Property accessors

	public Integer getOrderDetailId() {
		return this.orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public Integer getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

}