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
         cart.setShoppingCartId(cart.GetCartId(session));
         return cart;
     }
	 private String shoppingCartId;
	 public String getShoppingCartId() {
		return shoppingCartId;
	 }
	 public List<Cart> GetCartItems(){
         return shoppingComponet.GetCartItems(shoppingCartId);
     }
	 public void setShoppingCartId(String shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	 }
	 @Override
	public void AddToCart(Album album) {
		 shoppingComponet.AddToCart(album, shoppingCartId);
	}

	@Override
	public int RemoveFromCart(int recordId) {
		return shoppingComponet.RemoveFromCart(shoppingCartId, recordId);
	}

	@Override
	public void EmptyCart() {
		 shoppingComponet.EmptyCart(shoppingCartId);
	}

	@Override
	public int GetCount() {
		 return shoppingComponet.GetCount(shoppingCartId);
	}

	@Override
	public double GetTotal() {
		return shoppingComponet.GetTotal(shoppingCartId);
	}

	@Override
	public int CreateOrder(Order order) {
		 return shoppingComponet.CreateOrder(order,shoppingCartId);
	}

	@Override
	public String GetCartId(HttpSession session) {
		return shoppingComponet.GetCartId(session);
	}

	@Override
	public void MigrateCart(String userName) {
		 shoppingComponet.MigrateCart(shoppingCartId, userName);
	}
	public static String getCartSessionKey(){ 
		return shoppingComponet.getCartSessionKey();
	}

}