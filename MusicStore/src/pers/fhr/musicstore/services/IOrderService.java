package pers.fhr.musicstore.services;

import java.util.List;

public interface IOrderService {
	  boolean OrderIsExist(int orderId, String userName);
      Order CreateOrder(Order order);
      void EditOrder(Order order);
      void InitialUpdateOrderAndCreatOrderDetails(Order order, List<Cart> cartItems);
}
