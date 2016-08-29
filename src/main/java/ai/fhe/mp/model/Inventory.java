package ai.fhe.mp.model;

import javax.persistence.*;

/**
 * Created by maria on 22/08/2016.
 */
@Entity
public class Inventory {
    private Integer id;
    private Integer avatarId;
    private Integer itemId;
    private Integer itemCount;
    //private Avatar avatarByAvatarId;
    //private Item itemByItemId;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AvatarID", nullable = false)
    public Integer getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Integer avatarId) {
        this.avatarId = avatarId;
    }

    @Basic
    @Column(name = "ItemID", nullable = false)
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "ItemCount", nullable = false)
    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inventory inventory = (Inventory) o;

        if (id != null ? !id.equals(inventory.id) : inventory.id != null) return false;
        if (avatarId != null ? !avatarId.equals(inventory.avatarId) : inventory.avatarId != null) return false;
        if (itemId != null ? !itemId.equals(inventory.itemId) : inventory.itemId != null) return false;
        if (itemCount != null ? !itemCount.equals(inventory.itemCount) : inventory.itemCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (avatarId != null ? avatarId.hashCode() : 0);
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + (itemCount != null ? itemCount.hashCode() : 0);
        return result;
    }

    /*
    @ManyToOne
    @JoinColumn(name = "AvatarID", referencedColumnName = "ID", nullable = false)
    public Avatar getAvatarByAvatarId() {
        return avatarByAvatarId;
    }

    public void setAvatarByAvatarId(Avatar avatarByAvatarId) {
        this.avatarByAvatarId = avatarByAvatarId;
    }

    @ManyToOne
    @JoinColumn(name = "ItemID", referencedColumnName = "ID", nullable = false)
    public Item getItemByItemId() {
        return itemByItemId;
    }

    public void setItemByItemId(Item itemByItemId) {
        this.itemByItemId = itemByItemId;
    }
*/
}
