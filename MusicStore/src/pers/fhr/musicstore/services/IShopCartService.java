package pers.fhr.musicstore.services;

import java.util.List;

public interface IShopCartService {
	String FindCartAlbumTitle(int cartRecordId);
    Cart FindCartByCartIdAndAlbumId(String cartId, int albumId);
    Cart FindCartByCartIdAndRecordId(String cartId, int recordId);
    set<Cart> FindCartItemsByCartId(String cartId);
    void DeleteCart(List<Cart> carts);
    void DeleteCart(Cart cart);
    Integer StaticAlbumCount(String cartId);
    float StaticTotalMoney(String cartId);
    void InitialAndCreatCart(Album album, string shoppingCartId);
    void EditCart(Cart cart);
}
