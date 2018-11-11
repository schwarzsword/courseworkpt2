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

    private WalletEntity(){}

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "balance")
    public Long getBalance() {
        return balance;
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

    @OneToMany(mappedBy = "walletByDestination")
    public Collection<PaymentEntity> getPaymentsByIdDestination() {
        return paymentsByIdDestination;
    }

    @OneToOne
    @JoinColumn(name = "owner", referencedColumnName = "id", nullable = false)
    public UsersEntity getUserByOwner() {
        return userByOwner;
    }

    public static Builder newBuilder(){
        return new WalletEntity().new Builder();
    }

    public class Builder{
        private Builder(){}

        public Builder setID(int id){
            WalletEntity.this.id = id;

            return this;
        }

        public Builder setBalance(Long balance){
            WalletEntity.this.balance = balance;

            return this;
        }

        public Builder setPaymentsSource(Collection<PaymentEntity> paymentsByIdSource){
            WalletEntity.this.paymentsByIdSource = paymentsByIdSource;

            return this;
        }

        public Builder setPaymentsDest(Collection<PaymentEntity> paymentsDest){
            WalletEntity.this.paymentsByIdDestination = paymentsDest;

            return this;
        }

        public Builder setOwner(UsersEntity owner){
            WalletEntity.this.userByOwner = owner;

            return this;
        }

        public WalletEntity build(){
            WalletEntity wall = new WalletEntity();
            wall.id = WalletEntity.this.id;
            wall.balance = WalletEntity.this.balance;
            wall.paymentsByIdSource = WalletEntity.this.paymentsByIdSource;
            wall.paymentsByIdDestination = WalletEntity.this.paymentsByIdDestination;
            wall.userByOwner = WalletEntity.this.userByOwner;

            return wall;
        }

    }
}
