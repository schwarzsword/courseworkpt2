package service;

import entity.RegistrationEntity;
import entity.UsersEntity;

import java.security.NoSuchAlgorithmException;

public interface AuthorizationService {
    RegistrationEntity isRegistered(String login);
    RegistrationEntity setNewEntering(String login, String password)  throws NoSuchAlgorithmException;
    UsersEntity setNewUser(RegistrationEntity registrationEntity, String mail, String name, String surname, String phone, String role);
    //может еще можно сделать изменение полей юзера, хз
}
