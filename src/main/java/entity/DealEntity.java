package entity;

import javax.persistence.*;

@Entity
@Table(name = "deal", schema = "public", catalog = "s243884")
public class DealEntity {
    private int id;
    private EndDateEntity endDateBySoldDate;
    private UsersEntity usersByCustomer;
    private PaymentEntity paymentByPayment;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DealEntity that = (DealEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        return result;
    }

    @OneToOne
    @JoinColumn(name = "sold_date", referencedColumnName = "id")
    public EndDateEntity getEndDateBySoldDate() {
        return endDateBySoldDate;
    }

    public void setEndDateBySoldDate(EndDateEntity endDateBySoldDate) {
        this.endDateBySoldDate = endDateBySoldDate;
    }

    @ManyToOne
    @JoinColumn(name = "customer", referencedColumnName = "id")
    public UsersEntity getUsersByCustomer() {
        return usersByCustomer;
    }

    public void setUsersByCustomer(UsersEntity usersByCustomer) {
        this.usersByCustomer = usersByCustomer;
    }

    @OneToOne
    @JoinColumn(name = "payment", referencedColumnName = "id", nullable = false)
    public PaymentEntity getPaymentByPayment() {
        return paymentByPayment;
    }

    public void setPaymentByPayment(PaymentEntity paymentByPayment) {
        this.paymentByPayment = paymentByPayment;
    }
}
