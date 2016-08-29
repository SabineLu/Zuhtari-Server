package ai.fhe.mp.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

//@Entity
//@Table(name = "User")
@Entity
public class User
{
    private Integer id;
    private String email;
    private String name;
    private String password;
    private Date joinDate;

    @Id
    @GeneratedValue//(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "Password", nullable = false, length = 40)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "JoinDate", nullable = false)
    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public User(String _email, String _name, String _password, Date _joinDate)
    {
        //id          = _id;
        email       = _email;
        name        = _name;
        password    = _password;
        joinDate    = _joinDate;
    }

    public User(Integer _userId)
    {
        id          = _userId;
        name        = null;
        password    = null;
        email       = null;
        joinDate    = null;
    }



    public User()
    {
        id          = null;
        email       = null;
        name        = null;
        password    = null;
        joinDate    = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (joinDate != null ? !joinDate.equals(user.joinDate) : user.joinDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (joinDate != null ? joinDate.hashCode() : 0);
        return result;
    }
/*
    @OneToMany(mappedBy = "userBySellerUserId")
    public Collection<Market> getMarketsById() {
        return marketsById;
    }

    public void setMarketsById(Collection<Market> marketsById) {
        this.marketsById = marketsById;
    }

    @OneToMany(mappedBy = "userByBuyerUserId")
    public Collection<Market> getMarketsById_0() {
        return marketsById_0;
    }

    public void setMarketsById_0(Collection<Market> marketsById_0) {
        this.marketsById_0 = marketsById_0;
    }
*/
}
