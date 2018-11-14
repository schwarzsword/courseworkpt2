package repository;

import entity.PaintingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaintingRepository extends CrudRepository<PaintingEntity, Integer> {
    List<PaintingEntity> findByAuthor(String author);
    List<PaintingEntity> findAllByAuthor(String author);
}