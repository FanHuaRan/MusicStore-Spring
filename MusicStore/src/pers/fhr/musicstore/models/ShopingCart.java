package pers.fhr.musicstore.models;

import javax.servlet.http.HttpSession;

import pers.fhr.musicstore.services.IShoppingCart;
import pers.fhr.musicstore.services.IShoppingComponet;
import pers.fhr.musicstore.services.impl.ShoppingComponet;

public class ShopingCart implements IShoppingCart {
	
	 private static final IShoppingComponet shoppingComponet=new ShoppingComponet();
	 private String shoppingCartId;
	 public String getShoppingCartId() {
		return shoppingCartId;
	 }

	 public void setShoppingCartId(String shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	 }
	 @Override
	public void AddToCart(Album album) {
		 shoppingComponet.AddToCart(album, shoppingCartId);
	}

	@Override
	public int RemoveFromCart(int recordId) {
		return shoppingComponet.RemoveFromCart(shoppingCartId, recordId);
	}

	@Override
	public void EmptyCart() {
		 shoppingComponet.EmptyCart(shoppingCartId);
	}

	@Override
	public int GetCount() {
		 return shoppingComponet.GetCount(shoppingCartId);
	}

	@Override
	public double GetTotal() {
		return shoppingComponet.GetTotal(shoppingCartId);
	}

	@Override
	public int CreateOrder(Order order) {
		 return shoppingComponet.CreateOrder(order,shoppingCartId);
	}

	@Override
	public String GetCartId(HttpSession session) {
		return shoppingComponet.GetCartId(session);
	}

	@Override
	public void MigrateCart(String userName) {
		 shoppingComponet.MigrateCart(shoppingCartId, userName);
	}
	public static String getCartSessionKey(){ 
		return shoppingComponet.getCartSessionKey();
	}

}
