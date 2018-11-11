package repository;

import entity.PaintingEntity;
import org.springframework.data.repository.CrudRepository;

public interface PaintingRepository extends CrudRepository<PaintingEntity, Integer> {
}