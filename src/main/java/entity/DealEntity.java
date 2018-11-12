package entity;

import javax.persistence.*;



@Entity
@Table(name = "deal", schema = "public", catalog = "s243884")
public class DealEntity {
    private int id;
    private EndDateEntity endDateBySoldDate;
    private UsersEntity usersByCustomer;
    private PaymentEntity paymentByPayment;

    public DealEntity(){
        //private constructor
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deal_id_seq")
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

    //method creating new builder
    public static Builder newBuilder(){
        return new DealEntity().new Builder();
    }


    // Builder for Deal Entity
    public class Builder{

        private Builder(){
         //private constructor
        }

        public Builder setId(int dealID){
            DealEntity.this.id = dealID;

            return this;
        }

        public Builder setEndDate(EndDateEntity endDate){
            DealEntity.this.endDateBySoldDate = endDate;

            return this;
        }

        public Builder setCustomer(UsersEntity customer){
            DealEntity.this.usersByCustomer = customer;

            return this;
        }

        public Builder setPayment(PaymentEntity payment){
            DealEntity.this.paymentByPayment = payment;

            return this;
        }

        public DealEntity build(){
            DealEntity deal = new DealEntity();
            deal.id = DealEntity.this.id;
            deal.endDateBySoldDate = DealEntity.this.endDateBySoldDate;
            deal.usersByCustomer = DealEntity.this.usersByCustomer;
            deal.paymentByPayment = DealEntity.this.paymentByPayment;

            return deal;
        }



    }



}
