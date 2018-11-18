package repository;

import entity.LotEntity;
import entity.PaintingEntity;
import entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface LotRepository extends CrudRepository<LotEntity, Integer> {
    List<LotEntity> findAllByPaintingByPainting(PaintingEntity painting);
    List<LotEntity> findAllByStartDate(Timestamp startDate);
    List<LotEntity> findAllByState(String state);
    List<LotEntity> findAllByStartPrice(long startPrice);
    List<LotEntity> findAllBySellerByUsers(UsersEntity seller);
}