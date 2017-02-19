package pers.fhr.musicstore.services;

import pers.fhr.musicstore.models.Order;

public interface ICheckoutService {

    boolean AddressAndPayment(Order order, String userName, String userPromoCode);
    boolean OrderIsValid(int orderId, String userName);
}
