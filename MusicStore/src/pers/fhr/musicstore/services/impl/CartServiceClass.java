package pers.fhr.musicstore.services.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import pers.fhr.musicstore.daos.CartDAO;
import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.models.Cart;
import pers.fhr.musicstore.services.ICartService;
@Service
public class CartServiceClass implements ICartService {
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
	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> findCartItemsByCartId(String cartId) {
		return cartDAO.findByCartId(cartId);
	}
	@CacheEvict(value="cartCache",allEntries=true)
	@Override
	public void deleteCart(List<Cart> carts) {
		carts.stream().forEach(cart->
		cartDAO.delete(cart));
	}
	@CacheEvict(value="cartCache",key="#cart.recordId")
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
	@CacheEvict(value="cartCache",allEntries=true,beforeInvocation=true)
	@CachePut(value="cartCache",key="#result.recordId")
	@Override
	public Cart initialAndCreatCart(Album album, String shoppingCartId) {
		Cart cartItem = new Cart();
		cartItem.setAlbum(album);		
		cartItem.setCartId(shoppingCartId); 
		cartItem.setCount(1);    
		cartItem.setDateCreated(new Timestamp(System.currentTimeMillis()));
		return cartDAO.save(cartItem);
	}
	@CacheEvict(value="cartCache",key="#cart.recordId",beforeInvocation=true)
	@CachePut(value="cartCache",key="#cart.recordId")
	@Override
	public Cart editCart(Cart cart) {
		return cartDAO.update(cart);
	}

}
