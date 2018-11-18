package repository;

import entity.CertificateEntity;
import entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface CertificateRepository extends CrudRepository<CertificateEntity, Integer> {
    List<CertificateEntity> findAllByUsersByExpert(UsersEntity user);
    List<CertificateEntity> findAllByDate(Timestamp date);
}
