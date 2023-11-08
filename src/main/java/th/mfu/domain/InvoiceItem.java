package th.mfu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer dishAmount;
    private String itemNote;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Invoice invoice;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Dishes dishes;

    public InvoiceItem() {

    }

    public InvoiceItem(Long id, Integer dishAmount, Invoice invoice, Dishes dishes) {
        this.id = id;
        this.dishAmount = dishAmount;
        this.invoice = invoice;
        this.dishes = dishes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDishAmount() {
        return dishAmount;
    }

    public void setDishAmount(Integer dish_amout) {
        this.dishAmount = dish_amout;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

    public String getItemNote() {
        return itemNote;
    }

    public void setItemNote(String itemNote) {
        this.itemNote = itemNote;
    }
}
