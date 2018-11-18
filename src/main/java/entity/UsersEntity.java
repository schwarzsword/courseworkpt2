package entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users", schema = "public", catalog = "s243884")
@EqualsAndHashCode
public class UsersEntity {
    private int id;
    private String name;
    private String surname;
    private String mail;
    private String phone;
    private Collection<DealEntity> dealsById;
    private WalletEntity walletById;
    private RegistrationEntity registrationByRegist;
    private Collection<LotEntity> lotsById;
    private Collection<SertificateEntity> sertificatesById;

    @Enumerated(EnumType.STRING)
    private String role;


    public UsersEntity(){}//private constructor

    public static Builder newBuilder(){
        return new UsersEntity().new Builder();
    }

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToMany(mappedBy = "usersByCustomer")
    public Collection<DealEntity> getDealsById() {
        return dealsById;
    }

    public void setDealsById(Collection<DealEntity> dealsById) {
        this.dealsById = dealsById;
    }

    @OneToOne
    @JoinColumn(name = "regist", referencedColumnName = "id", nullable = false)
    public RegistrationEntity getRegistrationByRegist() {
        return registrationByRegist;
    }

    public void setRegistrationByRegist(RegistrationEntity registrationByRegist) {
        this.registrationByRegist = registrationByRegist;
    }

    @OneToOne(mappedBy = "userByOwner")
    public WalletEntity getWalletById() {
        return walletById;
    }

    public void setWalletById(WalletEntity walletById) {
        this.walletById = walletById;
    }

    @OneToMany(mappedBy = "sellerByUsers")
    public Collection<LotEntity> getLotsById() {
        return lotsById;
    }

    public void setLotsById(Collection<LotEntity> lotsById) {this.lotsById = lotsById;}

    @OneToMany(mappedBy = "usersByExpert")
    public Collection<SertificateEntity> getSertificatesById() {
        return sertificatesById;
    }

    public void setSertificatesById(Collection<SertificateEntity> sertificatesById) {
        this.sertificatesById = sertificatesById;
    }

    public class Builder{
        private Builder(){}//private constructor

        public Builder setID(int id){
            UsersEntity.this.id = id;

            return this;
        }

        public Builder setName(String name){
            UsersEntity.this.name = name;

            return this;
        }

        public Builder setSurname(String surname){
            UsersEntity.this.surname = surname;

            return this;
        }

        public Builder setMail(String mail){
            UsersEntity.this.mail = mail;

            return this;
        }

        public Builder setPhone(String phone){
            UsersEntity.this.phone = phone;

            return this;
        }

        public Builder setDeals(Collection<DealEntity> deals){
            UsersEntity.this.dealsById =  deals;

            return this;
        }

        public Builder setWallet(WalletEntity wallet){
            UsersEntity.this.walletById =  wallet;

            return this;
        }

        public Builder setRegistration(RegistrationEntity reg){
            UsersEntity.this.registrationByRegist =  reg;

            return this;
        }

        public Builder setLots(Collection<LotEntity> lots){
            UsersEntity.this.lotsById =  lots;

            return this;
        }

        public Builder setRole(String role){
            UsersEntity.this.role =  role;

            return this;
        }

        public UsersEntity build(){
            UsersEntity user = new UsersEntity();
            user.id = UsersEntity.this.id;
            user.name = UsersEntity.this.name;
            user.surname = UsersEntity.this.surname;
            user.mail = UsersEntity.this.mail;
            user.phone = UsersEntity.this.phone;
            user.dealsById = UsersEntity.this.dealsById;
            user.lotsById = UsersEntity.this.lotsById;
            user.walletById = UsersEntity.this.walletById;
            user.registrationByRegist = UsersEntity.this.registrationByRegist;
            user.role = UsersEntity.this.role;

            return user;
        }
    }
}
