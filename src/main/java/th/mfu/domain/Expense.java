package th.mfu.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Integer expTotal;
    private Integer matAmount;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Material material;

    public Expense() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getExpTotal() {
        return expTotal;
    }

    public void setExpTotal(Integer expTotal) {
        this.expTotal = expTotal;
    }

    public Integer getMatAmount() {
        return matAmount;
    }

    public void setMatAmount(Integer matAmount) {
        this.matAmount = matAmount;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

}
