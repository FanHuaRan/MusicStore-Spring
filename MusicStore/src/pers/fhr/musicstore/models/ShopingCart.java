package pers.fhr.musicstore.models;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import pers.fhr.musicstore.services.IShoppingCart;
import pers.fhr.musicstore.services.IShoppingComponet;
import pers.fhr.musicstore.services.impl.ShoppingComponet;

public class ShopingCart implements IShoppingCart {
	 private static  IShoppingComponet shoppingComponet=null;
	 static{
		 WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();  
		 shoppingComponet=wac.getBean(ShoppingComponet.class);
	 }
	 @Autowired
	 public void setShoppingComponet(IShoppingComponet shoppingComponet){
		 ShopingCart.shoppingComponet=shoppingComponet;
	 }
	 public static ShopingCart GetCart(HttpSession session){
		 ShopingCart cart = new ShopingCart();
         cart.setShoppingCartId(cart.getCartId(session));
         return cart;
     }
	 private String shoppingCartId;
	 public String getShoppingCartId() {
		return shoppingCartId;
	 }
	 public List<Cart> GetCartItems(){
         return shoppingComponet.getCartItems(shoppingCartId);
     }
	 public void setShoppingCartId(String shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	 }
	 @Override
	public void addToCart(Album album) {
		 shoppingComponet.addToCart(album, shoppingCartId);
	}

	@Override
	public int removeFromCart(int recordId) {
		return shoppingComponet.removeFromCart(shoppingCartId, recordId);
	}

	@Override
	public void emptyCart() {
		 shoppingComponet.emptyCart(shoppingCartId);
	}

	@Override
	public int getCount() {
		 return shoppingComponet.getCount(shoppingCartId);
	}

	@Override
	public double getTotal() {
		return shoppingComponet.getTotal(shoppingCartId);
	}

	@Override
	public int createOrder(Order order) {
		 return shoppingComponet.createOrder(order,shoppingCartId);
	}

	@Override
	public String getCartId(HttpSession session) {
		return shoppingComponet.getCartId(session);
	}

	@Override
	public void migrateCart(String userName) {
		 shoppingComponet.migrateCart(shoppingCartId, userName);
	}
	public static String getCartSessionKey(){ 
		return shoppingComponet.getCartSessionKey();
	}

}
