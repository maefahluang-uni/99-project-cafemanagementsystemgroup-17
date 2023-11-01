package th.mfu.domain;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date invoice_date;
    private String invoice_note;
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;
    @OneToOne(cascade = CascadeType.MERGE)
    private Payment payment;

    public Invoice() {
        
    }

    public Invoice(Long id, Date invoice_date, String invoice_note, User user, Payment payment) {
        this.id = id;
        this.invoice_date = invoice_date;
        this.invoice_note = invoice_note;
        this.user = user;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(Date invoice_date) {
        this.invoice_date = invoice_date;
    }

    public String getInvoice_note() {
        return invoice_note;
    }

    public void setInvoice_note(String invoice_note) {
        this.invoice_note = invoice_note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
