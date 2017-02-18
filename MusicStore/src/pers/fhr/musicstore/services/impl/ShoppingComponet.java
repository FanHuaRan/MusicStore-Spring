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
	public void AddToCart(Album album, String shoppingCartId) {
		 Cart cartItem = shopCartService.FindCartByCartIdAndAlbumId(shoppingCartId, album.getAlbumId());
         if (cartItem == null){
             shopCartService.InitialAndCreatCart(album, shoppingCartId);
         }
         else{
             cartItem.setCount(cartItem.getCount()+1);
             shopCartService.EditCart(cartItem);
         }
	}

	@Override
	public int CreateOrder(Order order, String shoppingCartId) {
		  List<Cart> cartItems = GetCartItems(shoppingCartId);
          orderService.InitialUpdateOrderAndCreatOrderDetails(order, cartItems);
          EmptyCart(shoppingCartId);
          return order.getOrderId();
	}

	@Override
	public void EmptyCart(String shoppingCartId) {
		List<Cart> cartItems = shopCartService.FindCartItemsByCartId(shoppingCartId);
        shopCartService.DeleteCart(cartItems);
	}

	@Override
	public String GetCartId(HttpSession session) {
		if (session.getAttribute(cartSessionKey).equals(null)||session.getAttribute(cartSessionKey).equals("")){
			UserDetails userDetails=GetUserDetails();
            if (userDetails.getUsername()!=null&&!userDetails.getUsername().equals("")){
            	session.setAttribute(cartSessionKey, userDetails.getUsername());
            }
            else{
            	UUID tempCartId=UUID.randomUUID();
            	session.setAttribute(cartSessionKey,tempCartId);
            }
        }
        return session.getAttribute(cartSessionKey).toString();
	}

	private UserDetails GetUserDetails() {
		return (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
	}

	@Override
	public List<Cart> GetCartItems(String shoppingCartId) {
		 return shopCartService.FindCartItemsByCartId(shoppingCartId);
	}

	@Override
	public int GetCount(String shoppingCartId) {
        return  shopCartService.StaticAlbumCount(shoppingCartId);
	}

	@Override
	public double GetTotal(String shoppingCartId) {
		 return  shopCartService.StaticTotalMoney(shoppingCartId);
	}

	@Override
	public void MigrateCart(String ShoppingCartId, String userName) {
		List<Cart> shoppingCarts = shopCartService.FindCartItemsByCartId(ShoppingCartId);
		shoppingCarts.forEach(cart->{
			cart.setCartId(userName);
			shopCartService.EditCart(cart);
		});
	}

	@Override
	public int RemoveFromCart(String shoppingCartId, int recordId) {
		 Cart cartItem = shopCartService.FindCartByCartIdAndRecordId(shoppingCartId, recordId);
         int itemCount = 0;
         if (cartItem != null){
             if (cartItem.getCount() > 1){
                 cartItem.setCount(cartItem.getCount()-1);
                 itemCount = cartItem.getCount();
                 shopCartService.EditCart(cartItem);
             }
             else{
                 shopCartService.DeleteCart(cartItem);
             }
         }
         return itemCount;
	}

	@Override
	public String getCartSessionKey() {
		return this.cartSessionKey;
	}

}
