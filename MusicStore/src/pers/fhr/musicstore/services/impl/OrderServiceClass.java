package pers.fhr.musicstore.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fhr.musicstore.daos.OrderDAO;
import pers.fhr.musicstore.daos.OrderdetailDAO;
import pers.fhr.musicstore.models.Cart;
import pers.fhr.musicstore.models.Order;
import pers.fhr.musicstore.models.Orderdetail;
import pers.fhr.musicstore.services.IOrderService;
@Service
public class OrderServiceClass implements IOrderService {
	@Autowired
	private OrderDAO orderDao=null;
	@Autowired
	private OrderdetailDAO orderdetailDAO=null;
	@Override
	public boolean orderIsExist(int orderId, String userName) {
		Order order=orderDao.findById(orderId);
		if(order==null||!order.getUsername().equals(userName)){
			return false;
		}
		return true;
	}

	@Override
	public Order createOrder(Order order) {
		orderDao.save(order);
		return order;
	}

	@Override
	public void editOrder(Order order) {
		orderDao.update(order);
	}

	@Override
	public void initialUpdateOrderAndCreatOrderDetails(Order order, List<Cart> cartItems) {
		double orderTotal = 0;
        for(Cart cart : cartItems){
        	Orderdetail orderDetail = new Orderdetail();
        	orderDetail.setAlbumId(cart.getAlbum().getAlbumId());
        	orderDetail.setOrderId(order.getOrderId());  
        	orderDetail.setUnitPrice(cart.getAlbum().getPrice());
        	orderDetail.setQuantity(cart.getCount());
            orderTotal += (cart.getCount() * cart.getAlbum().getPrice());
            orderdetailDAO.save(orderDetail);
        }
        order.setTotal(orderTotal);
        orderDao.update(order);
	}

}
