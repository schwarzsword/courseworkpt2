package service;

import entity.*;

public interface DealingService {
    PaymentEntity regPayment(long sum, WalletEntity seller, WalletEntity buyer);
    DealEntity regDeal(PaymentEntity payment, EndDateEntity date, UsersEntity user);
}
