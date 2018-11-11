package repository;

import entity.LotEntity;
import org.springframework.data.repository.CrudRepository;

public interface LotRepository extends CrudRepository<LotEntity, Integer> {
}