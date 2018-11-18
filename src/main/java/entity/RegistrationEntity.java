package entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "registration", schema = "public", catalog = "s243884")
@EqualsAndHashCode
public class RegistrationEntity {
    private int id;
    private String login;
    private String password;
    private UsersEntity userByRegist;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne(mappedBy = "registrationByRegist")
    public UsersEntity getUserByRegist() {
        return userByRegist;
    }

    public void setUserByRegist(UsersEntity userByRegist) {
        this.userByRegist = userByRegist;
    }

    public static Builder newBuilder(){
        return new RegistrationEntity().new Builder();
    }

    public class Builder{
        private Builder(){}//private constructor

        public Builder setID(int id){
            RegistrationEntity.this.id = id;

            return this;
        }

        public Builder setLogin(String login){
            RegistrationEntity.this.login = login;

            return this;
        }

        public Builder setPassword(String password){
            RegistrationEntity.this.password = password;

            return this;
        }

        public Builder setUser(UsersEntity user){
            RegistrationEntity.this.userByRegist = user;

            return this;
        }

        public RegistrationEntity build(){
            RegistrationEntity reg = new RegistrationEntity();
            reg.id = RegistrationEntity.this.id;
            reg.login = RegistrationEntity.this.login;
            reg.password = RegistrationEntity.this.password;
            reg.userByRegist = RegistrationEntity.this.userByRegist;

            return reg;
        }
    }

}
