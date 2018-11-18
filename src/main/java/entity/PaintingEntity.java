package entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "painting", schema = "public", catalog = "s243884")
@EqualsAndHashCode
public class PaintingEntity {
    private int id;
    private String name = "Unknown";
    private String author = "Unknown";
    private String description = "Description unknown";
    private String img = "Image unknown";
    private Collection<LotEntity> lotsById;
    private SertificateEntity sertificateBySertificate;

    public static Builder newBuilder(){
        return new PaintingEntity().new Builder();
    }

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String autor) {
        this.author = autor;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "img")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @OneToMany(mappedBy = "paintingByPainting")
    public Collection<LotEntity> getLotsById() {
        return lotsById;
    }

    public void setLotsById(Collection<LotEntity> lotsById) {
        this.lotsById = lotsById;
    }

    @OneToOne
    @JoinColumn(name = "sertificate", referencedColumnName = "id", nullable = false)
    public SertificateEntity getSertificateBySertificate() {
        return sertificateBySertificate;
    }

    public void setSertificateBySertificate(SertificateEntity sertificateBySertificate) {
        this.sertificateBySertificate = sertificateBySertificate;
    }

    public class Builder{
        private Builder(){}//private constructor

        public Builder setID(int id){
            PaintingEntity.this.id = id;

            return this;
        }

        public Builder setAuthor(String autor){
            PaintingEntity.this.author = autor;

            return this;
        }

        public Builder setName(String name){
            PaintingEntity.this.name = name;

            return this;
        }

        public Builder setDescription(String description){
            PaintingEntity.this.description = description;

            return this;
        }

        public Builder setImg(String img){
            PaintingEntity.this.img = img;

            return this;
        }

        public Builder setLots(Collection<LotEntity> lots){
            PaintingEntity.this.lotsById = lots;

            return this;
        }

        public PaintingEntity build(){
            PaintingEntity pict = new PaintingEntity();
            pict.id = PaintingEntity.this.id;
            pict.name = PaintingEntity.this.name;
            pict.author = PaintingEntity.this.author;
            pict.img=PaintingEntity.this.img;
            pict.description = PaintingEntity.this.description;
            pict.lotsById = PaintingEntity.this.lotsById;

            return pict;

        }
    }
}
