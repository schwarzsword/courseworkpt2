package repository;

import entity.RegistrationEntity;
import entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {
    Optional<UsersEntity> findUsersEntityByMail(String mail);
    Optional<UsersEntity> findUsersEntityByPhone(String phone);
    List<UsersEntity> findAllByName(String name);
    List<UsersEntity> findAllBySurname(String surname);
    List<UsersEntity> findAllByRegistrationByRegist(RegistrationEntity registration);
    List<UsersEntity> findAllByRole(String role);
}