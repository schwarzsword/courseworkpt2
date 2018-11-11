package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "wallet", schema = "public", catalog = "s243884")
public class WalletEntity {
    private int id;
    private Long balance;
    private Collection<PaymentEntity> paymentsByIdSource;
    private Collection<PaymentEntity> paymentsByIdDestination;
    private UsersEntity userByOwner;

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
    @Column(name = "balance")
    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WalletEntity that = (WalletEntity) o;

        if (id != that.id) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "walletBySource")
    public Collection<PaymentEntity> getPaymentsByIdSource() {
        return paymentsByIdSource;
    }

    public void setPaymentsByIdSource(Collection<PaymentEntity> paymentsByIdSource) {
        this.paymentsByIdSource = paymentsByIdSource;
    }

    @OneToMany(mappedBy = "walletByDestination")
    public Collection<PaymentEntity> getPaymentsByIdDestination() {
        return paymentsByIdDestination;
    }

    public void setPaymentsByIdDestination(Collection<PaymentEntity> paymentsByIdDestination) {
        this.paymentsByIdDestination = paymentsByIdDestination;
    }

    @OneToOne
    @JoinColumn(name = "owner", referencedColumnName = "id", nullable = false)
    public UsersEntity getUserByOwner() {
        return userByOwner;
    }

    public void setUserByOwner(UsersEntity userByOwner) {
        this.userByOwner = userByOwner;
    }
}
