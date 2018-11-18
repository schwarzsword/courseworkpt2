package repository;

import entity.SertificateEntity;
import entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface SertificateRepository extends CrudRepository<SertificateEntity, Integer> {
     List<SertificateEntity> findAllByUsersByExpert(UsersEntity user);
    List<SertificateEntity> findAllByDate(Timestamp date);
}
