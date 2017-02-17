package pers.fhr.musicstore.services;

public interface ICheckoutService {

    boolean AddressAndPayment(Order order, String userName, String userPromoCode);
    boolean OrderIsValid(int orderId, String userName);
}
