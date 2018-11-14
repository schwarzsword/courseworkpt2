package entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "wallet", schema = "public", catalog = "s243884")
@EqualsAndHashCode
public class WalletEntity {
    private int id;
    private Long balance;
    private Collection<PaymentEntity> paymentsByIdSource;
    private Collection<PaymentEntity> paymentsByIdDestination;
    private UsersEntity userByOwner;


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
    @Column(name = "balance")
    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
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
