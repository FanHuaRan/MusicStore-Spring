package pers.fhr.musicstore.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.models.Cart;
import pers.fhr.musicstore.models.Order;

public interface IShoppingComponet {
	 void addToCart(Album album, String shoppingCartId);
     void emptyCart(String shoppingCartId);
     String getCartId(HttpSession session);
     List<Cart> getCartItems(String shoppingCartId);
     int getCount(String shoppingCartId);
     double getTotal(String shoppingCartId);
     void migrateCart(String ShoppingCartId, String userName);
     int removeFromCart(String shoppingCartId, int recordId);
     String getCartSessionKey();
}
