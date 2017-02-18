package pers.fhr.musicstore.services.impl;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fhr.musicstore.controllers.HomeController;
import pers.fhr.musicstore.models.Order;
import pers.fhr.musicstore.services.ICheckoutService;
import pers.fhr.musicstore.services.IOrderService;
@Service
public class CheckoutServiceClass implements ICheckoutService {
	private static Logger logger = Logger.getLogger(CheckoutServiceClass.class);
	@Autowired
	 private  IOrderService orderService=null;
	 private  final String PromoCode="FREE";
	@Override
	public boolean AddressAndPayment(Order order, String userName, String userPromoCode) {
		try{
            //judge PromoCode
            if (!userPromoCode.equals(PromoCode))
            {
                return false;
            }
            else
            {
                order.setUsername(userName);
                order.setOrderDate(new Timestamp(System.currentTimeMillis()));
                order=orderService.CreateOrder(order);
                return true;
            }
        }
        catch(Exception e){
        	logger.error(e.getMessage());
            return false;
        }
	}

	@Override
	public boolean OrderIsValid(int orderId, String userName) {
		boolean isValid = orderService.OrderIsExist(orderId, userName);
        return isValid;
	}

}
