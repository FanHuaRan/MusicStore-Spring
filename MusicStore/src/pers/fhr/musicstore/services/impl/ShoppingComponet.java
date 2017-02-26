package pers.fhr.musicstore.services.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.models.Cart;
import pers.fhr.musicstore.models.Order;
import pers.fhr.musicstore.services.IOrderService;
import pers.fhr.musicstore.services.IShopCartService;
import pers.fhr.musicstore.services.IShoppingComponet;
@Service
public class ShoppingComponet implements IShoppingComponet {
	@Autowired
	 private  IShopCartService shopCartService=null;
	 @Autowired
     private  IOrderService orderService=null;
	  //存在Session中的键值 保存ShoppingCartId
    private  final  String cartSessionKey = "CartId";
	@Override
	public void addToCart(Album album, String shoppingCartId) {
		 Cart cartItem = shopCartService.findCartByCartIdAndAlbumId(shoppingCartId, album.getAlbumId());
         if (cartItem == null){
             shopCartService.initialAndCreatCart(album, shoppingCartId);
         }
         else{
             cartItem.setCount(cartItem.getCount()+1);
             shopCartService.editCart(cartItem);
         }
	}

	@Override
	public int createOrder(Order order, String shoppingCartId) {
		  List<Cart> cartItems = getCartItems(shoppingCartId);
          orderService.initialUpdateOrderAndCreatOrderDetails(order, cartItems);
          emptyCart(shoppingCartId);
          return order.getOrderId();
	}

	@Override
	public void emptyCart(String shoppingCartId) {
		List<Cart> cartItems = shopCartService.findCartItemsByCartId(shoppingCartId);
        shopCartService.deleteCart(cartItems);
	}

	@Override
	public String getCartId(HttpSession session) {
		if (session.getAttribute(cartSessionKey)==null||session.getAttribute(cartSessionKey).equals("")){
			UserDetails userDetails=getUserDetails();
            if (userDetails!=null&&userDetails.getUsername()!=null&&!userDetails.getUsername().equals("")){
            	session.setAttribute(cartSessionKey, userDetails.getUsername());
            }
            else{
            	UUID tempCartId=UUID.randomUUID();
            	session.setAttribute(cartSessionKey,tempCartId);
            }
        }
        return session.getAttribute(cartSessionKey).toString();
	}

	private UserDetails getUserDetails() {
		Object user=SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		if(user.equals("anonymousUser")){
			return null;
		}
		return (UserDetails)user;
	}

	@Override
	public List<Cart> getCartItems(String shoppingCartId) {
		 return shopCartService.findCartItemsByCartId(shoppingCartId);
	}

	@Override
	public int getCount(String shoppingCartId) {
        return  shopCartService.staticAlbumCount(shoppingCartId);
	}

	@Override
	public double getTotal(String shoppingCartId) {
		 return  shopCartService.staticTotalMoney(shoppingCartId);
	}

	@Override
	public void migrateCart(String ShoppingCartId, String userName) {
		List<Cart> shoppingCarts = shopCartService.findCartItemsByCartId(ShoppingCartId);
		shoppingCarts.forEach(cart->{
			cart.setCartId(userName);
			shopCartService.editCart(cart);
		});
	}

	@Override
	public int removeFromCart(String shoppingCartId, int recordId) {
		 Cart cartItem = shopCartService.findCartByCartIdAndRecordId(shoppingCartId, recordId);
         int itemCount = 0;
         if (cartItem != null){
             if (cartItem.getCount() > 1){
                 cartItem.setCount(cartItem.getCount()-1);
                 itemCount = cartItem.getCount();
                 shopCartService.editCart(cartItem);
             }
             else{
                 shopCartService.deleteCart(cartItem);
             }
         }
         return itemCount;
	}

	@Override
	public String getCartSessionKey() {
		return this.cartSessionKey;
	}

}
