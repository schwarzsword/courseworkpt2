package service;

import entity.*;

public interface DealingService {
    PaymentEntity regPayment(long sum, WalletEntity seller, WalletEntity buyer); //TODO check if buyer has money; reg new paymentEntity
    DealEntity regDeal(PaymentEntity payment, EndDateEntity date, UsersEntity user); //TODO set state in Date as true, set date in Deal, set customer

}
