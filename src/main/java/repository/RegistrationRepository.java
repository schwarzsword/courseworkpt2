package repository;

import entity.RegistrationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RegistrationRepository extends CrudRepository<RegistrationEntity, Integer> {
    Optional<RegistrationEntity> findRegistrationEntityByLogin(String login);
}
