package repository;

import entity.WalletEntity;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<WalletEntity, Integer> {
}