package com.fhr.musicstorerest.models;

/**
 * Orderdetail entity. @author MyEclipse Persistence Tools
 */

public class Orderdetail implements java.io.Serializable {

	// Fields

	private Integer orderDetailId;
	private Album album;
	private Order order;
	private Integer quantity;
	private Double unitPrice;

	// Constructors

	/** default constructor */
	public Orderdetail() {
	}

	/** full constructor */
	public Orderdetail(Album album, Order order, Integer quantity, Double unitPrice) {
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