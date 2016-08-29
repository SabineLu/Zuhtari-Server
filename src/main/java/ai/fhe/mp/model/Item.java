package ai.fhe.mp.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by maria on 22/08/2016.
 */
@Entity
public class Item {
    private Integer id;
    private String name;
    private String description;
    private Integer value;
    private Collection<Inventory> inventoriesById;
    private Collection<Market> marketsById;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Value", nullable = false)
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        if (value != null ? !value.equals(item.value) : item.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
/*
    @OneToMany(mappedBy = "itemByItemId")
    public Collection<Inventory> getInventoriesById() {
        return inventoriesById;
    }

    public void setInventoriesById(Collection<Inventory> inventoriesById) {
        this.inventoriesById = inventoriesById;
    }

    @OneToMany(mappedBy = "itemByItemId")
    public Collection<Market> getMarketsById() {
        return marketsById;
    }

    public void setMarketsById(Collection<Market> marketsById) {
        this.marketsById = marketsById;
    }
*/
}
