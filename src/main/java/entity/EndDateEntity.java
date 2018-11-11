package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "end_date", schema = "public", catalog = "s243884")
public class EndDateEntity {
    private int id;
    private Timestamp expectingDate;
    private Boolean state;
    private DealEntity dealById;
    private LotEntity lotByLot;

    private EndDateEntity(){} //private constructor

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "expecting_date")
    public Timestamp getExpectingDate() {
        return expectingDate;
    }

    @Basic
    @Column(name = "state")
    public Boolean getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EndDateEntity that = (EndDateEntity) o;

        if (id != that.id) return false;
        if (expectingDate != null ? !expectingDate.equals(that.expectingDate) : that.expectingDate != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (expectingDate != null ? expectingDate.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "endDateBySoldDate")
    public DealEntity getDealById() {
        return dealById;
    }

    @OneToOne
    @JoinColumn(name = "lot", referencedColumnName = "id", nullable = false)
    public LotEntity getLotByLot() {
        return lotByLot;
    }

    public static Builder newBuilder(){
        return new EndDateEntity().new Builder();
    }


    public class Builder{
        private Builder(){} //private constructor

        public Builder setID(int id){
            EndDateEntity.this.id = id;

            return this;
        }

        public Builder setExpectingDate(Timestamp expectingDate){
            EndDateEntity.this.expectingDate = expectingDate;

            return this;
        }

        public Builder setState(Boolean state){
            EndDateEntity.this.state = state;

            return this;
        }

        public Builder setDeal(DealEntity deal){
            EndDateEntity.this.dealById = deal;

            return this;
        }

        public Builder setLot(LotEntity lot){
            EndDateEntity.this.lotByLot = lot;

            return this;
        }

        public EndDateEntity build(){
            EndDateEntity endDate = new EndDateEntity();
            endDate.id = EndDateEntity.this.id;
            endDate.lotByLot = EndDateEntity.this.lotByLot;
            endDate.dealById = EndDateEntity.this.dealById;
            endDate.state = EndDateEntity.this.state;
            endDate.expectingDate = EndDateEntity.this.expectingDate;

            return endDate;
        }
    }

}
