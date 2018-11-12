package repository;

import entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {
    Optional<UsersEntity> findUsersEntityByMail(String mail);
    Optional<UsersEntity> findUsersEntityByPhone(String phone);

}