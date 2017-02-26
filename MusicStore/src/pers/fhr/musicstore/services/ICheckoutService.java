package pers.fhr.musicstore.services;

import pers.fhr.musicstore.models.Order;

public interface ICheckoutService {

    boolean addressAndPayment(Order order, String userName, String userPromoCode);
    boolean orderIsValid(int orderId, String userName);
}
