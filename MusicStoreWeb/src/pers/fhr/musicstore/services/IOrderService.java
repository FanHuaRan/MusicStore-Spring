package pers.fhr.musicstore.services;

import java.util.List;

import pers.fhr.musicstore.models.Cart;
import pers.fhr.musicstore.models.Order;

public interface IOrderService {
	  boolean OrderIsExist(int orderId, String userName);
      Order CreateOrder(Order order);
      void EditOrder(Order order);
      void InitialUpdateOrderAndCreatOrderDetails(Order order, List<Cart> cartItems);
}
