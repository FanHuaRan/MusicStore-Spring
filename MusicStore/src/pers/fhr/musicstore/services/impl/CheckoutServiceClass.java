package pers.fhr.musicstore.services.impl;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fhr.musicstore.controllers.HomeController;
import pers.fhr.musicstore.models.Order;
import pers.fhr.musicstore.models.ShopingCart;
import pers.fhr.musicstore.services.ICheckoutService;
import pers.fhr.musicstore.services.IOrderService;
@Service
public class CheckoutServiceClass implements ICheckoutService {
	private static Logger logger = Logger.getLogger(CheckoutServiceClass.class);
	@Autowired
	 private  IOrderService orderService=null;
	 private  final String PromoCode="FREE";
	@Override
	public boolean addressAndPayment(Order order, ShopingCart cart,String userName, String userPromoCode) {
		try{
            //judge PromoCode
            if (!userPromoCode.equals(PromoCode)){
                return false;
            }
            else{
            	order.setTotal(cart.getTotal());
                order.setUsername(userName);
                order.setOrderDate(new Timestamp(System.currentTimeMillis()));
                order=orderService.createOrder(order);
                orderService.creatOrderDetails(order, cart.GetCartItems());
                cart.emptyCart();
                return true;
            }
        }
        catch(Exception e){
        	logger.error(e.getMessage());
            return false;
        }
	}

	@Override
	public boolean orderIsValid(int orderId, String userName) {
		boolean isValid = orderService.orderIsExist(orderId, userName);
        return isValid;
	}

}
