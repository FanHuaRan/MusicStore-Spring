package com.fhr.musicstorerest.services;

import java.util.List;

import com.fhr.musicstorerest.models.Cart;
import com.fhr.musicstorerest.models.Order;

public interface IOrderService {
	  boolean orderIsExist(int orderId, String userName);
      Order createOrder(Order order);
      Order editOrder(Order order);
      void creatOrderDetails(Order order, List<Cart> cartItems);
}
