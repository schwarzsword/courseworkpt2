package service;

import entity.RegistrationEntity;
import entity.UsersEntity;

import java.security.NoSuchAlgorithmException;

public interface AuthorizationService {
    /**
     * Returns RegistrationEntity instance by login to put
     * into Spring Security
     * <p>
     * Method allows find registration set of user by login to validate
     *
     * @param  login  User's login
     * @return      registration info
     */
    RegistrationEntity isRegistered(String login);

    /**
     * Returns RegistrationEntity with filled fields that deployed into database
     * <p>
     * Method allows set up new registration log for user to work with.
     *
     *
     * @param  login  User's login
     * @param   password  User's password to be encrypted
     * @return      Ready to use registration user's data
     */
    RegistrationEntity setNewEntering(String login, String password)  throws NoSuchAlgorithmException;

    /**
     * Returns UsersEntity with filled fields that deployed into database
     * <p>
     * Method allows set up new user
     * Contains registration information to authorisation
     *
     * @param  registrationEntity needed to identify user
     * @return      Ready to use user's data
     */
    UsersEntity setNewUser(RegistrationEntity registrationEntity);

}
