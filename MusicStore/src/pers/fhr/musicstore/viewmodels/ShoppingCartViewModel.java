package pers.fhr.musicstore.viewmodels;

import java.util.List;

import pers.fhr.musicstore.models.Cart;

public class ShoppingCartViewModel {
	 private List<Cart> cartItems;
	 private double cartTotal;
	 public ShoppingCartViewModel(List<Cart> cartItems,double cartTotal){
		 this.cartItems=cartItems;
		 this.cartTotal=cartTotal;
	 }
	public List<Cart> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<Cart> cartItems) {
		this.cartItems = cartItems;
	}
	public double getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}
}
