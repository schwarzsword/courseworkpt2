package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "certificate", schema = "public", catalog = "s243884")
public class CertificateEntity {
    private int id;
    private Timestamp date;
    private Integer expert;
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

    @Basic
    @Column(name = "expert")
    public Integer getExpert() {
        return expert;
    }

    public void setExpert(Integer expert) {
        this.expert = expert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertificateEntity that = (CertificateEntity) o;
        return id == that.id &&
                Objects.equals(date, that.date) &&
                Objects.equals(expert, that.expert);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, expert);
    }

    @OneToOne(mappedBy = "sertificateBySertificate")
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
