package entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "lot", schema = "public", catalog = "s243884")
@EqualsAndHashCode
public class LotEntity {
    private int id;
    private Timestamp startDate;
    private Long startPrice;
    private EndDateEntity endDateById;
    private PaintingEntity paintingByPainting;
    private UsersEntity sellerByUsers;

    @Enumerated(EnumType.STRING)
    private String state;

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
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "start_price")
    public Long getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Long startPrice) {
        this.startPrice = startPrice;
    }

    @OneToOne(mappedBy = "lotByLot")
    public EndDateEntity getEndDateById() {
        return endDateById;
    }

    public void setEndDateById(EndDateEntity endDateById) {
        this.endDateById = endDateById;
    }

    @ManyToOne
    @JoinColumn(name = "painting", referencedColumnName = "id", nullable = false)
    public PaintingEntity getPaintingByPainting() {
        return paintingByPainting;
    }

    public void setPaintingByPainting(PaintingEntity paintingByPainting) {
        this.paintingByPainting = paintingByPainting;
    }

    @ManyToOne
    @JoinColumn(name = "seller", referencedColumnName = "id", nullable = false)
    public UsersEntity getSellerByUsers() {
        return sellerByUsers;
    }

    public void setSellerByUsers(UsersEntity sellerByUsers) {
        this.sellerByUsers = sellerByUsers;
    }

    public static Builder newBuilder(){
        return new LotEntity().new Builder();
    }

    //builder for lot entity
    public class Builder{

        private Builder(){
            //private constructor
        }

        public Builder setID(int lotID){
            LotEntity.this.id = lotID;

            return this;
        }

        public Builder setStartDate(Timestamp startDate){
            LotEntity.this.startDate = startDate;

            return this;
        }

        public Builder setStartPrice(Long startPrice){
            LotEntity.this.startPrice = startPrice;

            return this;
        }

        public Builder setEndDate(EndDateEntity endDate){
            LotEntity.this.endDateById = endDate;

            return this;
        }

        public Builder setPainting(PaintingEntity painting){
            LotEntity.this.paintingByPainting = painting;

            return this;
        }

        public Builder setSeller(UsersEntity seller){
            LotEntity.this.sellerByUsers = seller;

            return this;
        }

        public Builder setState(String state){
            LotEntity.this.state = state;

            return this;
        }


        public LotEntity build(){
            LotEntity lot = new LotEntity();
            lot.id = LotEntity.this.id;
            lot.startDate = LotEntity.this.startDate;
            lot.startPrice = LotEntity.this.startPrice;
            lot.state = LotEntity.this.state;
            lot.sellerByUsers = LotEntity.this.sellerByUsers;
            lot.paintingByPainting = LotEntity.this.paintingByPainting;
            lot.endDateById = LotEntity.this.endDateById;

            return lot;
        }
    }

}
