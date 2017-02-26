package pers.fhr.musicstore.services;

import java.util.List;

import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.models.Cart;

public interface IShopCartService {
	String findCartAlbumTitle(int cartRecordId);
    Cart findCartByCartIdAndAlbumId(String cartId, int albumId);
    Cart findCartByCartIdAndRecordId(String cartId, int recordId);
    List<Cart> findCartItemsByCartId(String cartId);
    void deleteCart(List<Cart> carts);
    void deleteCart(Cart cart);
    Integer staticAlbumCount(String cartId);
    double staticTotalMoney(String cartId);
    void initialAndCreatCart(Album album, String shoppingCartId);
    void editCart(Cart cart);
}
