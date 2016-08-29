package ai.fhe.mp.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by maria on 22/08/2016.
 */
@Entity
public class Monster {
    private Integer id;
    private String name;
    private Integer ownerId;
    private Byte hungerLevel;
    private Byte thirstLevel;
    private Byte loyalLevel;
    private String geneticInformation;
    private Byte generation;
    private Integer parent1Id;
    private Integer parent2Id;
    private Timestamp hatchday;
    private Byte isForSale;
    private Byte isAway;
    private Byte stage;
    private Integer monsterTypeId;
    private String comment;
    private Collection<Market> marketsById;
    private Avatar avatarByOwnerId;
    private Monster monsterByParent1Id;
    private Collection<Monster> monstersById;
    private Monster monsterByParent2Id;
    private Collection<Monster> monstersById_0;
    private MonsterCategory monsterCategoryByMonsterTypeId;

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
    @Column(name = "OwnerID", nullable = false)
    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "HungerLevel", nullable = false)
    public Byte getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(Byte hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    @Basic
    @Column(name = "ThirstLevel", nullable = false)
    public Byte getThirstLevel() {
        return thirstLevel;
    }

    public void setThirstLevel(Byte thirstLevel) {
        this.thirstLevel = thirstLevel;
    }

    @Basic
    @Column(name = "LoyalLevel", nullable = false)
    public Byte getLoyalLevel() {
        return loyalLevel;
    }

    public void setLoyalLevel(Byte loyalLevel) {
        this.loyalLevel = loyalLevel;
    }

    @Basic
    @Column(name = "GeneticInformation", nullable = false, length = 255)
    public String getGeneticInformation() {
        return geneticInformation;
    }

    public void setGeneticInformation(String geneticInformation) {
        this.geneticInformation = geneticInformation;
    }

    @Basic
    @Column(name = "Generation", nullable = false)
    public Byte getGeneration() {
        return generation;
    }

    public void setGeneration(Byte generation) {
        this.generation = generation;
    }

    @Basic
    @Column(name = "Parent1Id", nullable = true)
    public Integer getParent1Id() {
        return parent1Id;
    }

    public void setParent1Id(Integer parent1Id) {
        this.parent1Id = parent1Id;
    }

    @Basic
    @Column(name = "Parent2Id", nullable = true)
    public Integer getParent2Id() {
        return parent2Id;
    }

    public void setParent2Id(Integer parent2Id) {
        this.parent2Id = parent2Id;
    }

    @Basic
    @Column(name = "Hatchday", nullable = true)
    public Timestamp getHatchday() {
        return hatchday;
    }

    public void setHatchday(Timestamp hatchday) {
        this.hatchday = hatchday;
    }

    @Basic
    @Column(name = "IsForSale", nullable = false)
    public Byte getIsForSale() {
        return isForSale;
    }

    public void setIsForSale(Byte isForSale) {
        this.isForSale = isForSale;
    }

    @Basic
    @Column(name = "IsAway", nullable = false)
    public Byte getIsAway() {
        return isAway;
    }

    public void setIsAway(Byte isAway) {
        this.isAway = isAway;
    }

    @Basic
    @Column(name = "Stage", nullable = false)
    public Byte getStage() {
        return stage;
    }

    public void setStage(Byte stage) {
        this.stage = stage;
    }

    @Basic
    @Column(name = "MonsterTypeID", nullable = false)
    public Integer getMonsterTypeId() {
        return monsterTypeId;
    }

    public void setMonsterTypeId(Integer monsterTypeId) {
        this.monsterTypeId = monsterTypeId;
    }

    @Basic
    @Column(name = "Comment", nullable = true, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Monster monster = (Monster) o;

        if (id != null ? !id.equals(monster.id) : monster.id != null) return false;
        if (name != null ? !name.equals(monster.name) : monster.name != null) return false;
        if (ownerId != null ? !ownerId.equals(monster.ownerId) : monster.ownerId != null) return false;
        if (hungerLevel != null ? !hungerLevel.equals(monster.hungerLevel) : monster.hungerLevel != null) return false;
        if (thirstLevel != null ? !thirstLevel.equals(monster.thirstLevel) : monster.thirstLevel != null) return false;
        if (loyalLevel != null ? !loyalLevel.equals(monster.loyalLevel) : monster.loyalLevel != null) return false;
        if (geneticInformation != null ? !geneticInformation.equals(monster.geneticInformation) : monster.geneticInformation != null)
            return false;
        if (generation != null ? !generation.equals(monster.generation) : monster.generation != null) return false;
        if (parent1Id != null ? !parent1Id.equals(monster.parent1Id) : monster.parent1Id != null) return false;
        if (parent2Id != null ? !parent2Id.equals(monster.parent2Id) : monster.parent2Id != null) return false;
        if (hatchday != null ? !hatchday.equals(monster.hatchday) : monster.hatchday != null) return false;
        if (isForSale != null ? !isForSale.equals(monster.isForSale) : monster.isForSale != null) return false;
        if (isAway != null ? !isAway.equals(monster.isAway) : monster.isAway != null) return false;
        if (stage != null ? !stage.equals(monster.stage) : monster.stage != null) return false;
        if (monsterTypeId != null ? !monsterTypeId.equals(monster.monsterTypeId) : monster.monsterTypeId != null)
            return false;
        if (comment != null ? !comment.equals(monster.comment) : monster.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (hungerLevel != null ? hungerLevel.hashCode() : 0);
        result = 31 * result + (thirstLevel != null ? thirstLevel.hashCode() : 0);
        result = 31 * result + (loyalLevel != null ? loyalLevel.hashCode() : 0);
        result = 31 * result + (geneticInformation != null ? geneticInformation.hashCode() : 0);
        result = 31 * result + (generation != null ? generation.hashCode() : 0);
        result = 31 * result + (parent1Id != null ? parent1Id.hashCode() : 0);
        result = 31 * result + (parent2Id != null ? parent2Id.hashCode() : 0);
        result = 31 * result + (hatchday != null ? hatchday.hashCode() : 0);
        result = 31 * result + (isForSale != null ? isForSale.hashCode() : 0);
        result = 31 * result + (isAway != null ? isAway.hashCode() : 0);
        result = 31 * result + (stage != null ? stage.hashCode() : 0);
        result = 31 * result + (monsterTypeId != null ? monsterTypeId.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }
/*
    @OneToMany(mappedBy = "monsterByMonsterId")
    public Collection<Market> getMarketsById() {
        return marketsById;
    }

    public void setMarketsById(Collection<Market> marketsById) {
        this.marketsById = marketsById;
    }

    @ManyToOne
    @JoinColumn(name = "OwnerID", referencedColumnName = "ID", nullable = false)
    public Avatar getAvatarByOwnerId() {
        return avatarByOwnerId;
    }

    public void setAvatarByOwnerId(Avatar avatarByOwnerId) {
        this.avatarByOwnerId = avatarByOwnerId;
    }

    @ManyToOne
    @JoinColumn(name = "Parent1Id", referencedColumnName = "ID")
    public Monster getMonsterByParent1Id() {
        return monsterByParent1Id;
    }

    public void setMonsterByParent1Id(Monster monsterByParent1Id) {
        this.monsterByParent1Id = monsterByParent1Id;
    }

    @OneToMany(mappedBy = "monsterByParent1Id")
    public Collection<Monster> getMonstersById() {
        return monstersById;
    }

    public void setMonstersById(Collection<Monster> monstersById) {
        this.monstersById = monstersById;
    }

    @ManyToOne
    @JoinColumn(name = "Parent2Id", referencedColumnName = "ID")
    public Monster getMonsterByParent2Id() {
        return monsterByParent2Id;
    }

    public void setMonsterByParent2Id(Monster monsterByParent2Id) {
        this.monsterByParent2Id = monsterByParent2Id;
    }

    @OneToMany(mappedBy = "monsterByParent2Id")
    public Collection<Monster> getMonstersById_0() {
        return monstersById_0;
    }

    public void setMonstersById_0(Collection<Monster> monstersById_0) {
        this.monstersById_0 = monstersById_0;
    }

    @ManyToOne
    @JoinColumn(name = "MonsterTypeID", referencedColumnName = "ID", nullable = false)
    public MonsterCategory getMonsterCategoryByMonsterTypeId() {
        return monsterCategoryByMonsterTypeId;
    }

    public void setMonsterCategoryByMonsterTypeId(MonsterCategory monsterCategoryByMonsterTypeId) {
        this.monsterCategoryByMonsterTypeId = monsterCategoryByMonsterTypeId;
    }
    */
}
