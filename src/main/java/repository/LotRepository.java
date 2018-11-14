package repository;

import entity.LotEntity;
import entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface LotRepository extends CrudRepository<LotEntity, Integer> {
    Collection<LotEntity> findLotEntitiesBySellerByUsers(UsersEntity seller);
}