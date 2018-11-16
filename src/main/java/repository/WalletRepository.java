package repository;

import entity.UsersEntity;
import entity.WalletEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WalletRepository extends CrudRepository<WalletEntity, Integer> {
    List<WalletEntity> findAllByBalance(long sum);
    List<WalletEntity> findAllByUserByOwner(UsersEntity owner);
}