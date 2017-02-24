package pers.fhr.musicstore.ajaxcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import pers.fhr.musicstore.models.ShopingCart;
import pers.fhr.musicstore.services.IAlbumService;
import pers.fhr.musicstore.services.IShopCartService;
import pers.fhr.musicstore.viewmodels.ShoppingCartRemoveViewModel;

@Controller
@RequestMapping("/Shopping")
public class ShoppingAjaxController {
	 @Autowired
	 private final IShopCartService shopCartService =null;
	 @ResponseBody 
	 @RequestMapping(value="/RemoveFromCart",
						method=RequestMethod.POST,
						produces=MediaType.APPLICATION_JSON_VALUE)
	  public ShoppingCartRemoveViewModel RemoveFromCart(HttpSession session, int id){
	        ShopingCart cart = ShopingCart.GetCart(session);
	        String albumName = shopCartService.FindCartAlbumTitle(id);
	        int itemCount = cart.RemoveFromCart(id);
	        ShoppingCartRemoveViewModel results = new ShoppingCartRemoveViewModel();
	        results.setMessage(HtmlUtils.htmlEscape(albumName)+  "has been removed from your shopping cart.");
	        results.setCartTotal(cart.GetTotal());
	        results.setCartCount(cart.GetCount());
	        results.setItemCount(itemCount);
	        results.setDeleteId(id);
	        return results;
	    }
}
