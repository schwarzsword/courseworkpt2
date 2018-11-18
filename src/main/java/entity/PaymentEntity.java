package entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "payment", schema = "public", catalog = "s243884")
@EqualsAndHashCode
public class PaymentEntity {
    private int id;
    private Long sum;
    private DealEntity dealById;
    private WalletEntity walletBySource;
    private WalletEntity walletByDestination;

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
    @Column(name = "sum")
    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    @OneToOne(mappedBy = "paymentByPayment")
    public DealEntity getDealById() {
        return dealById;
    }

    public void setDealById(DealEntity dealById) {
        this.dealById = dealById;
    }

    @ManyToOne
    @JoinColumn(name = "source", referencedColumnName = "id", nullable = false)
    public WalletEntity getWalletBySource() {
        return walletBySource;
    }

    public void setWalletBySource(WalletEntity walletBySource) {
        this.walletBySource = walletBySource;
    }

    @ManyToOne
    @JoinColumn(name = "destination", referencedColumnName = "id", nullable = false)
    public WalletEntity getWalletByDestination() {
        return walletByDestination;
    }

    public void setWalletByDestination(WalletEntity walletByDestination) {
        this.walletByDestination = walletByDestination;
    }

    public static Builder newBuilder(){
        return new PaymentEntity().new Builder();
    }


    public class Builder{
        private Builder(){}//private constructor

        public Builder setID(int id){
            PaymentEntity.this.id = id;

            return this;
        }

        public Builder setSum(Long sum){
            PaymentEntity.this.sum = sum;

            return this;
        }

        public Builder setDeal(DealEntity deal){
            PaymentEntity.this.dealById = deal;

            return this;
        }

        public Builder setSourceWallet(WalletEntity srcWallet){
            PaymentEntity.this.walletBySource = srcWallet;

            return this;
        }

        public Builder setDestinationWallet(WalletEntity destinationWallet){
            PaymentEntity.this.walletByDestination = destinationWallet;

            return this;
        }

        public PaymentEntity build(){
             PaymentEntity payment = new PaymentEntity();
             payment.id = PaymentEntity.this.id;
             payment.sum = PaymentEntity.this.sum;
             payment.dealById = PaymentEntity.this.dealById;
             payment.walletBySource = PaymentEntity.this.walletBySource;
             payment.walletByDestination = PaymentEntity.this.walletByDestination;

             return payment;
        }
    }

}
