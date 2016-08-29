package ai.fhe.mp.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by maria on 22/08/2016.
 */
@Entity
public class MonsterCategory {
    private Integer id;
    private Integer gen1Id;
    private Integer gen2Id;
    private Integer gen3Id;
    private Integer gen1ColorId;
    private Integer gen2ColorId;
    private Integer gen3ColorId;
    private Collection<Monster> monstersById;
    private Gen1Pattern gen1PatternByGen1Id;
    private Gen2Pattern gen2PatternByGen2Id;
    private Gen3Pattern gen3PatternByGen3Id;
    private Color colorByGen1ColorId;
    private Color colorByGen2ColorId;
    private Color colorByGen3ColorId;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Gen1ID", nullable = false)
    public Integer getGen1Id() {
        return gen1Id;
    }

    public void setGen1Id(Integer gen1Id) {
        this.gen1Id = gen1Id;
    }

    @Basic
    @Column(name = "Gen2ID", nullable = false)
    public Integer getGen2Id() {
        return gen2Id;
    }

    public void setGen2Id(Integer gen2Id) {
        this.gen2Id = gen2Id;
    }

    @Basic
    @Column(name = "Gen3ID", nullable = false)
    public Integer getGen3Id() {
        return gen3Id;
    }

    public void setGen3Id(Integer gen3Id) {
        this.gen3Id = gen3Id;
    }

    @Basic
    @Column(name = "Gen1ColorID", nullable = false)
    public Integer getGen1ColorId() {
        return gen1ColorId;
    }

    public void setGen1ColorId(Integer gen1ColorId) {
        this.gen1ColorId = gen1ColorId;
    }

    @Basic
    @Column(name = "Gen2ColorID", nullable = false)
    public Integer getGen2ColorId() {
        return gen2ColorId;
    }

    public void setGen2ColorId(Integer gen2ColorId) {
        this.gen2ColorId = gen2ColorId;
    }

    @Basic
    @Column(name = "Gen3ColorID", nullable = false)
    public Integer getGen3ColorId() {
        return gen3ColorId;
    }

    public void setGen3ColorId(Integer gen3ColorId) {
        this.gen3ColorId = gen3ColorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonsterCategory that = (MonsterCategory) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (gen1Id != null ? !gen1Id.equals(that.gen1Id) : that.gen1Id != null) return false;
        if (gen2Id != null ? !gen2Id.equals(that.gen2Id) : that.gen2Id != null) return false;
        if (gen3Id != null ? !gen3Id.equals(that.gen3Id) : that.gen3Id != null) return false;
        if (gen1ColorId != null ? !gen1ColorId.equals(that.gen1ColorId) : that.gen1ColorId != null) return false;
        if (gen2ColorId != null ? !gen2ColorId.equals(that.gen2ColorId) : that.gen2ColorId != null) return false;
        if (gen3ColorId != null ? !gen3ColorId.equals(that.gen3ColorId) : that.gen3ColorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (gen1Id != null ? gen1Id.hashCode() : 0);
        result = 31 * result + (gen2Id != null ? gen2Id.hashCode() : 0);
        result = 31 * result + (gen3Id != null ? gen3Id.hashCode() : 0);
        result = 31 * result + (gen1ColorId != null ? gen1ColorId.hashCode() : 0);
        result = 31 * result + (gen2ColorId != null ? gen2ColorId.hashCode() : 0);
        result = 31 * result + (gen3ColorId != null ? gen3ColorId.hashCode() : 0);
        return result;
    }

    /*
    @OneToMany(mappedBy = "monsterCategoryByMonsterTypeId")
    public Collection<Monster> getMonstersById() {
        return monstersById;
    }

    public void setMonstersById(Collection<Monster> monstersById) {
        this.monstersById = monstersById;
    }

    @ManyToOne
    @JoinColumn(name = "Gen1ID", referencedColumnName = "ID", nullable = false)
    public Gen1Pattern getGen1PatternByGen1Id() {
        return gen1PatternByGen1Id;
    }

    public void setGen1PatternByGen1Id(Gen1Pattern gen1PatternByGen1Id) {
        this.gen1PatternByGen1Id = gen1PatternByGen1Id;
    }

    @ManyToOne
    @JoinColumn(name = "Gen2ID", referencedColumnName = "ID", nullable = false)
    public Gen2Pattern getGen2PatternByGen2Id() {
        return gen2PatternByGen2Id;
    }

    public void setGen2PatternByGen2Id(Gen2Pattern gen2PatternByGen2Id) {
        this.gen2PatternByGen2Id = gen2PatternByGen2Id;
    }

    @ManyToOne
    @JoinColumn(name = "Gen3ID", referencedColumnName = "ID", nullable = false)
    public Gen3Pattern getGen3PatternByGen3Id() {
        return gen3PatternByGen3Id;
    }

    public void setGen3PatternByGen3Id(Gen3Pattern gen3PatternByGen3Id) {
        this.gen3PatternByGen3Id = gen3PatternByGen3Id;
    }

    @ManyToOne
    @JoinColumn(name = "Gen1ColorID", referencedColumnName = "ID", nullable = false)
    public Color getColorByGen1ColorId() {
        return colorByGen1ColorId;
    }

    public void setColorByGen1ColorId(Color colorByGen1ColorId) {
        this.colorByGen1ColorId = colorByGen1ColorId;
    }

    @ManyToOne
    @JoinColumn(name = "Gen2ColorID", referencedColumnName = "ID", nullable = false)
    public Color getColorByGen2ColorId() {
        return colorByGen2ColorId;
    }

    public void setColorByGen2ColorId(Color colorByGen2ColorId) {
        this.colorByGen2ColorId = colorByGen2ColorId;
    }

    @ManyToOne
    @JoinColumn(name = "Gen3ColorID", referencedColumnName = "ID", nullable = false)
    public Color getColorByGen3ColorId() {
        return colorByGen3ColorId;
    }

    public void setColorByGen3ColorId(Color colorByGen3ColorId) {
        this.colorByGen3ColorId = colorByGen3ColorId;
    }
*/
}
