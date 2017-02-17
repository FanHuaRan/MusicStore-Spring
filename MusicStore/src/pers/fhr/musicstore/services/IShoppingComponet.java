package pers.fhr.musicstore.services;

import javax.servlet.http.HttpSession;

public interface IShoppingComponet {
	 void AddToCart(Album album, String shoppingCartId);
     int CreateOrder(Order order, String shoppingCartId);
     void EmptyCart(String shoppingCartId);
     String GetCartId(HttpSession session);
     set<Cart> GetCartItems(String shoppingCartId);
     int GetCount(String shoppingCartId);
     float GetTotal(String shoppingCartId);
     void MigrateCart(String ShoppingCartId, String userName);
     int RemoveFromCart(String shoppingCartId, int recordId);
     String getCartSessionKey;
}
