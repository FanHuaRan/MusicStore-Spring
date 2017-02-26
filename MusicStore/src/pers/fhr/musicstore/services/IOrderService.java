package pers.fhr.musicstore.services;

import java.util.List;

import pers.fhr.musicstore.models.Cart;
import pers.fhr.musicstore.models.Order;

public interface IOrderService {
	  boolean orderIsExist(int orderId, String userName);
      Order createOrder(Order order);
      void editOrder(Order order);
      void initialUpdateOrderAndCreatOrderDetails(Order order, List<Cart> cartItems);
}
