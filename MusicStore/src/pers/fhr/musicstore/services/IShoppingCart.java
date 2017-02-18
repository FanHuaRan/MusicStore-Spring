package pers.fhr.musicstore.services;

import javax.servlet.http.HttpSession;

import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.models.Order;

public interface IShoppingCart {
	void AddToCart(Album album);
    int RemoveFromCart(int recordId);
    void EmptyCart();
    int GetCount();
    float GetTotal();
    int CreateOrder(Order order);
    String GetCartId(HttpSession session);
    void MigrateCart(String userName);
}
