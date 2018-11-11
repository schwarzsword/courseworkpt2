package repository;

import entity.RegistrationEntity;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepository extends CrudRepository<RegistrationEntity, Integer> {
    RegistrationEntity findRegistrationEntityByLogin(String login);
}
