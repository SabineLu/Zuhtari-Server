package ai.fhe.mp.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by maria on 22/08/2016.
 */
@Entity
public class Avatar {
    private Integer id;
    private Integer userId;
    private String name;
    private Date birthday;
    private String gender;
    private Integer hairColor;
    private Integer eyeColor;
    private Integer skinColor;
    private Integer money;
    private String farmName;
    private String status;
    private Timestamp statusChangeDate;
    private Collection<Inventory> inventoriesById;
    private Collection<Monster> monstersById;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UserId", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Birthday", nullable = false)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "Gender", nullable = false, length = 1)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "HairColor", nullable = false)
    public Integer getHairColor() {
        return hairColor;
    }

    public void setHairColor(Integer hairColor) {
        this.hairColor = hairColor;
    }

    @Basic
    @Column(name = "EyeColor", nullable = false)
    public Integer getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Integer eyeColor) {
        this.eyeColor = eyeColor;
    }

    @Basic
    @Column(name = "SkinColor", nullable = false)
    public Integer getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(Integer skinColor) {
        this.skinColor = skinColor;
    }

    @Basic
    @Column(name = "Money", nullable = false)
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Basic
    @Column(name = "FarmName", nullable = false, length = 50)
    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    @Basic
    @Column(name = "Status", nullable = false, length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "StatusChangeDate", nullable = true)
    public Timestamp getStatusChangeDate() {
        return statusChangeDate;
    }

    public void setStatusChangeDate(Timestamp statusChangeDate) {
        this.statusChangeDate = statusChangeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Avatar avatar = (Avatar) o;

        if (id != null ? !id.equals(avatar.id) : avatar.id != null) return false;
        if (userId != null ? !userId.equals(avatar.userId) : avatar.userId != null) return false;
        if (name != null ? !name.equals(avatar.name) : avatar.name != null) return false;
        if (birthday != null ? !birthday.equals(avatar.birthday) : avatar.birthday != null) return false;
        if (gender != null ? !gender.equals(avatar.gender) : avatar.gender != null) return false;
        if (hairColor != null ? !hairColor.equals(avatar.hairColor) : avatar.hairColor != null) return false;
        if (eyeColor != null ? !eyeColor.equals(avatar.eyeColor) : avatar.eyeColor != null) return false;
        if (skinColor != null ? !skinColor.equals(avatar.skinColor) : avatar.skinColor != null) return false;
        if (money != null ? !money.equals(avatar.money) : avatar.money != null) return false;
        if (farmName != null ? !farmName.equals(avatar.farmName) : avatar.farmName != null) return false;
        if (status != null ? !status.equals(avatar.status) : avatar.status != null) return false;
        if (statusChangeDate != null ? !statusChangeDate.equals(avatar.statusChangeDate) : avatar.statusChangeDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (hairColor != null ? hairColor.hashCode() : 0);
        result = 31 * result + (eyeColor != null ? eyeColor.hashCode() : 0);
        result = 31 * result + (skinColor != null ? skinColor.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (farmName != null ? farmName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (statusChangeDate != null ? statusChangeDate.hashCode() : 0);
        return result;
    }

    /*@OneToMany(mappedBy = "avatarByAvatarId")
    public Collection<Inventory> getInventoriesById() {
        return inventoriesById;
    }

    public void setInventoriesById(Collection<Inventory> inventoriesById) {
        this.inventoriesById = inventoriesById;
    }

    @OneToMany(mappedBy = "avatarByOwnerId")
    public Collection<Monster> getMonstersById() {
        return monstersById;
    }

    public void setMonstersById(Collection<Monster> monstersById) {
        this.monstersById = monstersById;
    }
*/
}
