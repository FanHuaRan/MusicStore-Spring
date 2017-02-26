package pers.fhr.musicstore.services;

import javax.servlet.http.HttpSession;

import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.models.Order;

public interface IShoppingCart {
	void addToCart(Album album);
    int removeFromCart(int recordId);
    void emptyCart();
    int getCount();
    double getTotal();
    String getCartId(HttpSession session);
    void migrateCart(String userName);
}
