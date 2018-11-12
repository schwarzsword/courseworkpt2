package entity;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
@Entity
@Table(name = "test", schema = "public", catalog = "s243884")
public class TestEntity {
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "role")
    @Type( type = "pgsql_enum" )
    private Role ro;

    public TestEntity() {
        //private constructor
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
    @Column(name = "ro")
    public Role getRo() {
        return ro;
    }

    public void setRo(Role role) {
        this.ro = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        entity.TestEntity that = (entity.TestEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id * 31;
        return result;
    }

}

