package pers.fhr.musicstore.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.models.ShopingCart;
import pers.fhr.musicstore.services.IAlbumService;
import pers.fhr.musicstore.services.IShopCartService;
import pers.fhr.musicstore.services.impl.AlbumServiceClass;
import pers.fhr.musicstore.services.impl.ShopCartServiceClass;
import pers.fhr.musicstore.viewmodels.ShoppingCartRemoveViewModel;
import pers.fhr.musicstore.viewmodels.ShoppingCartViewModel;

@Controller
@RequestMapping("/ShoppingCart")
public class ShoppingCartController {
    @Autowired
    private final IShopCartService shopCartService =null;
    @Autowired
    private final IAlbumService albumService =null;
    @RequestMapping()
    public ModelAndView Index(HttpSession session){
        ShopingCart cart = ShopingCart.GetCart(session);
        ShoppingCartViewModel viewModel = new ShoppingCartViewModel(cart.GetCartItems(),cart.GetTotal());
        return new ModelAndView("shoppingcart/index","viewModel",viewModel);
    }
    @RequestMapping("/AddToCart")
    public String AddToCart(HttpSession session, int id){
        Album addedAlbum = albumService.FindAlbumById(id);
        ShopingCart cart = ShopingCart.GetCart(session);
        cart.AddToCart(addedAlbum);
        return "redirect:";
    }
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
