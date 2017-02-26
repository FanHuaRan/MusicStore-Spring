package pers.fhr.musicstore.services.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fhr.musicstore.daos.CartDAO;
import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.models.Cart;
import pers.fhr.musicstore.services.IShopCartService;
@Service
public class ShopCartServiceClass implements IShopCartService {
	@Autowired
	private CartDAO cartDAO=null;
	@Override
	public String findCartAlbumTitle(int cartRecordId) {
		Cart cart=cartDAO.findById(cartRecordId);
		if(cart==null){
			return null;
		}
		return cart.getAlbum().getTitle();
	}

	@Override
	public Cart findCartByCartIdAndAlbumId(String cartId, int albumId) {
		List<Cart> carts=cartDAO.FindCartByCartIdAndAlbumId(cartId, albumId);
		return carts.size()==0?null:carts.get(0);
	}

	@Override
	public Cart findCartByCartIdAndRecordId(String cartId, int recordId) {
		Cart cart=cartDAO.findById(recordId);
		if(cart!=null&&cart.getCartId().equals(cartId)){
			return cart;
		}
		return null;
	}

	@Override
	public List<Cart> findCartItemsByCartId(String cartId) {
		return cartDAO.findByCartId(cartId);
	}

	@Override
	public void deleteCart(List<Cart> carts) {
		carts.stream().forEach(cart->
		cartDAO.delete(cart));
	}

	@Override
	public void deleteCart(Cart cart) {
		cartDAO.delete(cart);
	}

	@Override
	public Integer staticAlbumCount(String cartId) {
		List<Cart> carts=cartDAO.findByCartId(cartId);
		if(carts.size()==0){
			return 0;
		}
		if(carts.size()==1){
			return carts.get(0).getCount();
		}
		return carts.stream().map(p->p.getCount())
		.reduce(0, (a, b) -> a + b);
	}

	@Override
	public double staticTotalMoney(String cartId) {
		List<Cart> carts=cartDAO.findByCartId(cartId);
		if(carts.size()==0){
			return 0;
		}
		if(carts.size()==1){
			return carts.get(0).getCount()*carts.get(0).getAlbum().getPrice();
		}
		return carts.stream().map(p->p.getAlbum().getPrice()*p.getCount())
		.reduce((a, b) -> a + b).get();
	}

	@Override
	public void initialAndCreatCart(Album album, String shoppingCartId) {
		Cart cartItem = new Cart();
		cartItem.setAlbum(album);		
		cartItem.setCartId(shoppingCartId); 
		cartItem.setCount(1);    
		cartItem.setDateCreated(new Timestamp(System.currentTimeMillis()));
		cartDAO.save(cartItem);
	}

	@Override
	public void editCart(Cart cart) {
		cartDAO.update(cart);
	}

}
