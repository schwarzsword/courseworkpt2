package repository;

import entity.EndDateEntity;

import entity.LotEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface EndDateRepository extends CrudRepository<EndDateEntity, Integer> {
    Optional<EndDateEntity> findByLotByLot(LotEntity lot);
    List<EndDateEntity> findAllByExpectingDate(Timestamp expectDate);
    List<EndDateEntity> findAllByState(boolean state);
}