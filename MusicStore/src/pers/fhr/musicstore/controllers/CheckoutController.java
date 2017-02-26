package pers.fhr.musicstore.controllers;

import java.sql.Timestamp;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pers.fhr.musicstore.models.Cart;
import pers.fhr.musicstore.models.Order;
import pers.fhr.musicstore.models.ShopingCart;
import pers.fhr.musicstore.services.ICheckoutService;
import pers.fhr.musicstore.viewmodels.AddressAndPaymentViewModel;

@Controller
@RequestMapping("/Checkout")
public class CheckoutController {
	 private final static Logger logger = Logger.getLogger(CheckoutController.class);
	 @Autowired
	 private  ICheckoutService CheckOutService =null;
	 @RequestMapping()
	 public ModelAndView index(){
		 AddressAndPaymentViewModel addressAndPaymentViewModel=new AddressAndPaymentViewModel();
		 return new ModelAndView("checkout/index","addressAndPaymentViewModel",addressAndPaymentViewModel);
	 }
	 @RequestMapping(value="/AddressAndPayment",
			 		 method=RequestMethod.POST)
	 public String AddressAndPayment(HttpSession session, Model model,AddressAndPaymentViewModel addressAndPaymentViewModel){
         Order order = new Order();
         TryUpdateModel(order,addressAndPaymentViewModel);
         ShopingCart cart = ShopingCart.GetCart(session);
         UserDetails userDetails=getUserDetails();
         if(CheckOutService.addressAndPayment(order, cart,userDetails.getUsername(),addressAndPaymentViewModel.getPromoCode())){
                 return "redirect:Complete?id="+order.getOrderId();
         }
         else{
        	 model.addAttribute("addressAndPaymentViewModel",addressAndPaymentViewModel);
             return"checkout/index";
         }
     }
	 @RequestMapping("/Complete")
	 public ModelAndView Complete(int id){
         // Validate customer owns this order
         boolean isValid = CheckOutService.orderIsValid(id,getUserDetails().getUsername());
         if (isValid){
             return new ModelAndView("checkout/complete","id",id);
         }
         else{
             return new ModelAndView("checkout/error");
         }
     }
	private void TryUpdateModel(Order order, AddressAndPaymentViewModel addressAndPaymentViewModel) {
		order.setAddress(addressAndPaymentViewModel.getAddress());
		order.setCity(addressAndPaymentViewModel.getCity());
		order.setCountry(addressAndPaymentViewModel.getCountry());
		order.setEmail(addressAndPaymentViewModel.getEmail());
		order.setFirstName(addressAndPaymentViewModel.getFirstName());
		order.setLastName(addressAndPaymentViewModel.getLastName());
		order.setOrderDate(new Timestamp(System.currentTimeMillis()));
		order.setPhone(addressAndPaymentViewModel.getPhone());
		order.setPostalCode(addressAndPaymentViewModel.getPostalCode());
		order.setState(addressAndPaymentViewModel.getState());
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
}