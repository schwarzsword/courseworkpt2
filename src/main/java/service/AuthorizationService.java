package service;

import entity.RegistrationEntity;
import entity.UsersEntity;

public interface AuthorizationService {
    boolean isRegistered(); //TODO check in registrationEntity if login and pswd matches;
    RegistrationEntity setNewEntering(); //TODO write login and encrypt pswd;
    UsersEntity setNewUser(RegistrationEntity registrationEntity); //TODO set fields and registration for new user;
    //может еще можно сделать изменение полей юзера, хз
}
