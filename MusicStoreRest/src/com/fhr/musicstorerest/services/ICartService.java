package com.fhr.musicstorerest.services;

import java.util.List;

import com.fhr.musicstorerest.models.Album;
import com.fhr.musicstorerest.models.Cart;

public interface ICartService {
	String findCartAlbumTitle(int cartRecordId);
    Cart findCartByCartIdAndAlbumId(String cartId, int albumId);
    Cart findCartByCartIdAndRecordId(String cartId, int recordId);
    List<Cart> findCartItemsByCartId(String cartId);
    void deleteCart(List<Cart> carts);
    void deleteCart(Cart cart);
    Integer staticAlbumCount(String cartId);
    double staticTotalMoney(String cartId);
    Cart initialAndCreatCart(Album album, String shoppingCartId);
    Cart editCart(Cart cart);
}
