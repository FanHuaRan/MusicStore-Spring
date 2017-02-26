package pers.fhr.musicstore.services;

import pers.fhr.musicstore.models.Order;
import pers.fhr.musicstore.models.ShopingCart;

public interface ICheckoutService {

    boolean addressAndPayment(Order order,ShopingCart cart,String userName, String userPromoCode);
    boolean orderIsValid(int orderId, String userName);
}
