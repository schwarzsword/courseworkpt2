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
    private PaintingEntity paintingById;
    private UsersEntity usersByExpert;

    @Id
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

    @OneToOne(mappedBy = "certificateByCertificate")
    public PaintingEntity getPaintingById() {
        return paintingById;
    }

    public void setPaintingById(PaintingEntity paintingById) {
        this.paintingById = paintingById;
    }

    @ManyToOne
    @JoinColumn(name = "expert", referencedColumnName = "id")
    public UsersEntity getUsersByExpert() {
        return usersByExpert;
    }

    public void setUsersByExpert(UsersEntity usersByExpert) {
        this.usersByExpert = usersByExpert;
    }
}
