package ai.fhe.mp.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by maria on 22/08/2016.
 */
@Entity
public class Market {
    private Integer id;
    private Integer sellerUserId;
    private Integer monsterId;
    private Integer itemId;
    private Integer itemsForSale;
    private BigDecimal pricePerItem;
    private Date sellStart;
    private Date sellEnd;
    private Integer buyerUserId;
    private User userBySellerUserId;
    private Monster monsterByMonsterId;
    private Item itemByItemId;
    private User userByBuyerUserId;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SellerUserID", nullable = false)
    public Integer getSellerUserId() {
        return sellerUserId;
    }

    public void setSellerUserId(Integer sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

    @Basic
    @Column(name = "MonsterID", nullable = true)
    public Integer getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(Integer monsterId) {
        this.monsterId = monsterId;
    }

    @Basic
    @Column(name = "ItemID", nullable = true)
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "ItemsForSale", nullable = false)
    public Integer getItemsForSale() {
        return itemsForSale;
    }

    public void setItemsForSale(Integer itemsForSale) {
        this.itemsForSale = itemsForSale;
    }

    @Basic
    @Column(name = "PricePerItem", nullable = false, precision = 2)
    public BigDecimal getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(BigDecimal pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    @Basic
    @Column(name = "SellStart", nullable = false)
    public Date getSellStart() {
        return sellStart;
    }

    public void setSellStart(Date sellStart) {
        this.sellStart = sellStart;
    }

    @Basic
    @Column(name = "SellEnd", nullable = false)
    public Date getSellEnd() {
        return sellEnd;
    }

    public void setSellEnd(Date sellEnd) {
        this.sellEnd = sellEnd;
    }

    @Basic
    @Column(name = "BuyerUserId", nullable = true)
    public Integer getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(Integer buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Market market = (Market) o;

        if (id != null ? !id.equals(market.id) : market.id != null) return false;
        if (sellerUserId != null ? !sellerUserId.equals(market.sellerUserId) : market.sellerUserId != null)
            return false;
        if (monsterId != null ? !monsterId.equals(market.monsterId) : market.monsterId != null) return false;
        if (itemId != null ? !itemId.equals(market.itemId) : market.itemId != null) return false;
        if (itemsForSale != null ? !itemsForSale.equals(market.itemsForSale) : market.itemsForSale != null)
            return false;
        if (pricePerItem != null ? !pricePerItem.equals(market.pricePerItem) : market.pricePerItem != null)
            return false;
        if (sellStart != null ? !sellStart.equals(market.sellStart) : market.sellStart != null) return false;
        if (sellEnd != null ? !sellEnd.equals(market.sellEnd) : market.sellEnd != null) return false;
        if (buyerUserId != null ? !buyerUserId.equals(market.buyerUserId) : market.buyerUserId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sellerUserId != null ? sellerUserId.hashCode() : 0);
        result = 31 * result + (monsterId != null ? monsterId.hashCode() : 0);
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + (itemsForSale != null ? itemsForSale.hashCode() : 0);
        result = 31 * result + (pricePerItem != null ? pricePerItem.hashCode() : 0);
        result = 31 * result + (sellStart != null ? sellStart.hashCode() : 0);
        result = 31 * result + (sellEnd != null ? sellEnd.hashCode() : 0);
        result = 31 * result + (buyerUserId != null ? buyerUserId.hashCode() : 0);
        return result;
    }
    /*
        @ManyToOne
        @JoinColumn(name = "SellerUserID", referencedColumnName = "ID", nullable = false)
        public User getUserBySellerUserId() {
            return userBySellerUserId;
        }

        public void setUserBySellerUserId(User userBySellerUserId) {
            this.userBySellerUserId = userBySellerUserId;
        }

        @ManyToOne
        @JoinColumn(name = "MonsterID", referencedColumnName = "ID")
        public Monster getMonsterByMonsterId() {
            return monsterByMonsterId;
        }

        public void setMonsterByMonsterId(Monster monsterByMonsterId) {
            this.monsterByMonsterId = monsterByMonsterId;
        }

        @ManyToOne
        @JoinColumn(name = "ItemID", referencedColumnName = "ID")
        public Item getItemByItemId() {
            return itemByItemId;
        }

        public void setItemByItemId(Item itemByItemId) {
            this.itemByItemId = itemByItemId;
        }

    @ManyToOne
    @JoinColumn(name = "BuyerUserId", referencedColumnName = "ID")
    public User getUserByBuyerUserId() {
        return userByBuyerUserId;
    }

    public void setUserByBuyerUserId(User userByBuyerUserId) {
        this.userByBuyerUserId = userByBuyerUserId;
    }
 */
}
