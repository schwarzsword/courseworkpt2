package service;

import entity.*;
import org.springframework.transaction.annotation.Transactional;

public interface DealingService {
    /**
     * Returns PaymentEntity with valid information
     * about passed payment
     * <p>
     * Method allows to check state of user's wallets
     * If payment can't be executed, sends a letter to administrator
     * As result one user gets money and another loses
     *
     * @param  sum  amount of transfered money
     * @param  seller seller's wallet
     * @param  customer customer's wallet
     * @return     registred payment between users
     */
    PaymentEntity regPayment(long sum, WalletEntity seller, WalletEntity customer); //TODO check if buyer has money; reg new paymentEntity
    /**
     * Returns DealEntity with valid information
     * about deal with selling lot, date and payment info
     * <p>
     * Method allows to register deal between users
     * Marks user as new owner of lot
     *
     *
     * @param  payment  payment info
     * @param date date of selling lot
     * @param  user user, who will be new owner
     * @return      information about deal
     */
    DealEntity regDeal(PaymentEntity payment, EndDateEntity date, UsersEntity user); //TODO set state in Date as true, set date in Deal, set customer

}
