package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users", schema = "public", catalog = "s243884")
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


    @Enumerated(EnumType.STRING)
    private Role role;

    @Id
    @GeneratedValue
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
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
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
}
