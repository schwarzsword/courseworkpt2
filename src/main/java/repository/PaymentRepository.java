package repository;

import entity.PaymentEntity;
import entity.WalletEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<PaymentEntity, Integer> {
    List<PaymentEntity> findAllBySum(long sum);
    List<PaymentEntity> findAllByWalletBySource(WalletEntity source);
    List<PaymentEntity> findAllByWalletByDestination(WalletEntity destination);
}