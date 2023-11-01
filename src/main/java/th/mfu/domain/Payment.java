package th.mfu.domain;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date pay_Date;
    private Integer pay_total;

    public Payment(Long id, Date pay_Date, Integer pay_total) {
        this.id = id;
        this.pay_Date = pay_Date;
        this.pay_total = pay_total;
    }

        public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPay_Date() {
        return pay_Date;
    }

    public void setPay_Date(Date pay_Date) {
        this.pay_Date = pay_Date;
    }

    public Integer getPay_total() {
        return pay_total;
    }

    public void setPay_total(Integer pay_total) {
        this.pay_total = pay_total;
    }

}
