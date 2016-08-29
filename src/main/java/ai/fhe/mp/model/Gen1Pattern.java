package ai.fhe.mp.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by maria on 22/08/2016.
 */
@Entity
@Table(name = "Gen1 Pattern", schema = "zuhtariserver", catalog = "")
public class Gen1Pattern {
    private Integer id;
    private String name;
    private String description;
    private Collection<MonsterCategory> monsterCategoriesById;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gen1Pattern that = (Gen1Pattern) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
/*
    @OneToMany(mappedBy = "gen1PatternByGen1Id")
    public Collection<MonsterCategory> getMonsterCategoriesById() {
        return monsterCategoriesById;
    }

    public void setMonsterCategoriesById(Collection<MonsterCategory> monsterCategoriesById) {
        this.monsterCategoriesById = monsterCategoriesById;
    }
    */
}
