package repository;

import entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {
    UsersEntity findUsersEntityByMail(String mail);
}