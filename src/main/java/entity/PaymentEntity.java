package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "payment", schema = "public", catalog = "s243884")
public class PaymentEntity {
    private int id;
    private Long sum;
    private DealEntity dealById;
    private WalletEntity walletBySource;
    private WalletEntity walletByDestination;

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
    @Column(name = "sum")
    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentEntity that = (PaymentEntity) o;

        if (id != that.id) return false;
        if (sum != null ? !sum.equals(that.sum) : that.sum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        return result;
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
}
