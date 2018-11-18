package repository;

import entity.DealEntity;
import entity.EndDateEntity;
import entity.PaymentEntity;
import entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DealRepository extends CrudRepository<DealEntity, Integer> {
    List<DealEntity> findAllByUsersByCustomer(UsersEntity customer);
    Optional<DealEntity> findByPaymentByPayment(PaymentEntity payment);
    Optional<DealEntity> findByEndDateBySoldDate(EndDateEntity endDate);
}