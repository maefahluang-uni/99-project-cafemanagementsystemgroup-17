package com.newagain.project.domain;

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
    private Integer dish_amount;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Invoice invoice;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Dishes dishes;

    public InvoiceItem() {

    }

    public InvoiceItem(Long id, Integer dish_amount, Invoice invoice, Dishes dishes) {
        this.id = id;
        this.dish_amount = dish_amount;
        this.invoice = invoice;
        this.dishes = dishes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDish_amount() {
        return dish_amount;
    }

    public void setDish_amount(Integer dish_amout) {
        this.dish_amount = dish_amout;
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

}
