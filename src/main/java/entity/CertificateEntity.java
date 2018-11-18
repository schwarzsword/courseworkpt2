package entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "certificate", schema = "public", catalog = "s243884")
@EqualsAndHashCode
public class CertificateEntity {
    private int id;
    private Timestamp date;
    //private PaintingEntity paintingById;
    private UsersEntity usersByExpert;

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
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

//    @OneToOne(mappedBy = "certificateByCertificate")
//    public PaintingEntity getPaintingById() {
//        return paintingById;
//    }
//
//    public void setPaintingById(PaintingEntity paintingById) {
//        this.paintingById = paintingById;
//    }

    @ManyToOne
    @JoinColumn(name = "expert", referencedColumnName = "id")
    public UsersEntity getUsersByExpert() {
        return usersByExpert;
    }

    public void setUsersByExpert(UsersEntity usersByExpert) {
        this.usersByExpert = usersByExpert;
    }
    public static Builder newBuilder(){
        return new CertificateEntity().new Builder();
    }

    public class Builder{
        private Builder(){}

        public Builder setID(int id){
            CertificateEntity.this.id = id;
            return this;
        }

        public Builder setDate(Timestamp date){
            CertificateEntity.this.date = date;
            return this;
        }

        public Builder setExpert(UsersEntity expert){
            CertificateEntity.this.usersByExpert = expert;
            return this;
        }

        public CertificateEntity build(){
            CertificateEntity certificateEntity = new CertificateEntity();
            certificateEntity.id = CertificateEntity.this.id;
            certificateEntity.usersByExpert = CertificateEntity.this.usersByExpert;
            certificateEntity.date = CertificateEntity.this.date;

            return certificateEntity;
        }
    }
}
