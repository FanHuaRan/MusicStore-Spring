package pers.fhr.musicstore.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.models.Cart;
import pers.fhr.musicstore.models.Order;

public interface IShoppingComponet {
	 void AddToCart(Album album, String shoppingCartId);
     int CreateOrder(Order order, String shoppingCartId);
     void EmptyCart(String shoppingCartId);
     String GetCartId(HttpSession session);
     List<Cart> GetCartItems(String shoppingCartId);
     int GetCount(String shoppingCartId);
     float GetTotal(String shoppingCartId);
     void MigrateCart(String ShoppingCartId, String userName);
     int RemoveFromCart(String shoppingCartId, int recordId);
     String getCartSessionKey();
}
