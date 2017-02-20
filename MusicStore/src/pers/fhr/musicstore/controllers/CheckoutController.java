package pers.fhr.musicstore.controllers;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pers.fhr.musicstore.models.Order;
import pers.fhr.musicstore.models.ShopingCart;
import pers.fhr.musicstore.services.ICheckoutService;
import pers.fhr.musicstore.viewmodels.AddressAndPaymentViewModel;

@Controller
@RequestMapping("/Checkout")
@RolesAllowed({"Admin","User"}) 
public class CheckoutController {
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
         UserDetails userDetails=getUserDetails();
         if(CheckOutService.AddressAndPayment(order, userDetails.getUsername(), addressAndPaymentViewModel.getPromoCode())){
                 ShopingCart cart = ShopingCart.GetCart(session);
                 cart.CreateOrder(order);
                 return "redirect:Complete?id="+order.getOrderId();
         }
         else{
        	 model.addAttribute("addressAndPaymentViewModel",addressAndPaymentViewModel);
             return"checkout/index";
         }
     }
	 public ModelAndView Complete(int id){
         // Validate customer owns this order
         boolean isValid = CheckOutService.OrderIsValid(id,getUserDetails().getUsername());
         if (isValid)
         {
             return new ModelAndView("checkout/complete","id",id);
         }
         else
         {
             return new ModelAndView("checkout/error");
         }
     }
	private void TryUpdateModel(Order order, AddressAndPaymentViewModel addressAndPaymentViewModel) {
		// TODO Auto-generated method stub
		
	}
	private UserDetails getUserDetails() {
		return (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
	}
}