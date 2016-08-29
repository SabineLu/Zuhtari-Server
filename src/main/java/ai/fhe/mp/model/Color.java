package ai.fhe.mp.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by maria on 22/08/2016.
 */
@Entity
public class Color {
    private Integer id;
    private String name;
    private String rgbCode;
    private Collection<MonsterCategory> monsterCategoriesById;
    private Collection<MonsterCategory> monsterCategoriesById_0;
    private Collection<MonsterCategory> monsterCategoriesById_1;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 25)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "RGBCode", nullable = false, length = 6)
    public String getRgbCode() {
        return rgbCode;
    }

    public void setRgbCode(String rgbCode) {
        this.rgbCode = rgbCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color = (Color) o;

        if (id != null ? !id.equals(color.id) : color.id != null) return false;
        if (name != null ? !name.equals(color.name) : color.name != null) return false;
        if (rgbCode != null ? !rgbCode.equals(color.rgbCode) : color.rgbCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (rgbCode != null ? rgbCode.hashCode() : 0);
        return result;
    }
/*
    @OneToMany(mappedBy = "colorByGen1ColorId")
    public Collection<MonsterCategory> getMonsterCategoriesById() {
        return monsterCategoriesById;
    }

    public void setMonsterCategoriesById(Collection<MonsterCategory> monsterCategoriesById) {
        this.monsterCategoriesById = monsterCategoriesById;
    }

    @OneToMany(mappedBy = "colorByGen2ColorId")
    public Collection<MonsterCategory> getMonsterCategoriesById_0() {
        return monsterCategoriesById_0;
    }

    public void setMonsterCategoriesById_0(Collection<MonsterCategory> monsterCategoriesById_0) {
        this.monsterCategoriesById_0 = monsterCategoriesById_0;
    }

    @OneToMany(mappedBy = "colorByGen3ColorId")
    public Collection<MonsterCategory> getMonsterCategoriesById_1() {
        return monsterCategoriesById_1;
    }

    public void setMonsterCategoriesById_1(Collection<MonsterCategory> monsterCategoriesById_1) {
        this.monsterCategoriesById_1 = monsterCategoriesById_1;
    }
    */
}
