package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "painting", schema = "public", catalog = "s243884")
public class PaintingEntity {
    private int id;
    private String name;
    private String autor;
    private String description;
    private String img;
    private Collection<LotEntity> lotsById;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "autor")
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaintingEntity that = (PaintingEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (autor != null ? !autor.equals(that.autor) : that.autor != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (img != null ? !img.equals(that.img) : that.img != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "paintingByPainting")
    public Collection<LotEntity> getLotsById() {
        return lotsById;
    }

    public void setLotsById(Collection<LotEntity> lotsById) {
        this.lotsById = lotsById;
    }

}
