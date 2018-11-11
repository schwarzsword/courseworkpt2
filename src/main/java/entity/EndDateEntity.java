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
    @Column(name = "expecting_date")
    public Timestamp getExpectingDate() {
        return expectingDate;
    }

    public void setExpectingDate(Timestamp expectingDate) {
        this.expectingDate = expectingDate;
    }

    @Basic
    @Column(name = "state")
    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
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

    public void setDealById(DealEntity dealById) {
        this.dealById = dealById;
    }

    @OneToOne
    @JoinColumn(name = "lot", referencedColumnName = "id", nullable = false)
    public LotEntity getLotByLot() {
        return lotByLot;
    }

    public void setLotByLot(LotEntity lotByLot) {
        this.lotByLot = lotByLot;
    }
}
