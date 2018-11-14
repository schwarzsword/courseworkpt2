package repository;

import entity.DealEntity;
import org.springframework.data.repository.CrudRepository;

public interface DealRepository extends CrudRepository<DealEntity, Integer> {
}