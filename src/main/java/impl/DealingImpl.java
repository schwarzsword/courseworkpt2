package impl;

import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.DealRepository;
import repository.EndDateRepository;
import repository.LotRepository;
import repository.WalletRepository;
import service.DealingService;

@Service("dealingService")
public class DealingImpl implements DealingService {

    private final LotRepository lotRepository;
    private final DealRepository dealRepository;
    private final WalletRepository walletRepository;
    private final EndDateRepository endDateRepository;

    @Autowired
    public DealingImpl(LotRepository lotRepository, EndDateRepository endDateRepository, DealRepository dealRepository, WalletRepository walletRepository){
        this.lotRepository = lotRepository;
        this.dealRepository = dealRepository;
        this.walletRepository = walletRepository;
        this.endDateRepository = endDateRepository;
    }

    @Transactional
    @Override
    public PaymentEntity regPayment(long sum, WalletEntity seller, WalletEntity customer) {
        PaymentEntity newPayment = null;
        if(customer.getBalance()>=sum){
            newPayment = PaymentEntity.newBuilder()
                    .setSourceWallet(customer)
                    .setDestinationWallet(seller)
                    .setSum(sum)
                    .build();
            seller.setBalance(seller.getBalance()+sum);
            customer.setBalance(customer.getBalance()-sum);
            walletRepository.save(seller);
            walletRepository.save(customer);
        }

        return newPayment;
    }

    @Transactional
    @Override
    public DealEntity regDeal(PaymentEntity payment, EndDateEntity date, UsersEntity user) {
        date.setState(true);
        DealEntity newDeal = DealEntity.newBuilder()
                .setEndDate(date)
                .setCustomer(user)
                .setPayment(payment)
                .build();
        endDateRepository.save(date);
        dealRepository.save(newDeal);
        return newDeal;
    }
}
