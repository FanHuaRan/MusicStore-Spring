package com.fhr.musicstorerest.models;

/**
 * Orderdetail entity. @author MyEclipse Persistence Tools
 */

public class Orderdetail implements java.io.Serializable {

	// Fields

	private Integer orderDetailId;
	private Integer albumId;
	private Integer orderId;
	private Integer quantity;
	private Double unitPrice;

	// Constructors

	/** default constructor */
	public Orderdetail() {
	}

	/** full constructor */
	public Orderdetail(Integer albumId,Integer orderId,Integer quantity, Double unitPrice) {
		this.albumId = albumId;
		this.orderId = orderId;
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

	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	

}