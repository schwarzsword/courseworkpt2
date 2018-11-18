package impl;

import com.sun.prism.PixelFormat;
import entity.RegistrationEntity;
import entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.RegistrationRepository;
import repository.UsersRepository;
import service.AuthorizationService;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service("authorizationService")
public class AuthorizationImpl implements AuthorizationService {
    private final RegistrationRepository registrationRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public AuthorizationImpl(RegistrationRepository registrationRepository, UsersRepository usersRepository){
        this.registrationRepository = registrationRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public RegistrationEntity isRegistered(String login) {
        return registrationRepository.findRegistrationEntityByLogin(login).get();
    }

    @Transactional
    @Override
    public RegistrationEntity setNewEntering(String login, String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String encr = DatatypeConverter.printHexBinary(digest).toUpperCase();
        RegistrationEntity reg = RegistrationEntity.newBuilder()
                .setLogin(login)
                .setPassword(encr)
                .build();
        return null;
    }

    @Transactional
    @Override
    public UsersEntity setNewUser(RegistrationEntity registrationEntity, String mail, String name, String surname, String phone, String role) {
        UsersEntity usr = UsersEntity.newBuilder()
                .setRegistration(registrationEntity)
                .setMail(mail)
                .setName(name)
                .setSurname(surname)
                .setPhone(phone)
                .setRole(role)
                .build();
        usersRepository.save(usr);
        return usr;
    }
}
