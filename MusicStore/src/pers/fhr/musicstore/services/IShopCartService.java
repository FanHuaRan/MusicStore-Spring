package pers.fhr.musicstore.services;

import java.util.List;

import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.models.Cart;

public interface IShopCartService {
	String FindCartAlbumTitle(int cartRecordId);
    Cart FindCartByCartIdAndAlbumId(String cartId, int albumId);
    Cart FindCartByCartIdAndRecordId(String cartId, int recordId);
    List<Cart> FindCartItemsByCartId(String cartId);
    void DeleteCart(List<Cart> carts);
    void DeleteCart(Cart cart);
    Integer StaticAlbumCount(String cartId);
    float StaticTotalMoney(String cartId);
    void InitialAndCreatCart(Album album, String shoppingCartId);
    void EditCart(Cart cart);
}
