package th.mfu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import th.mfu.domain.Dishes;
import th.mfu.domain.Invoice;
import th.mfu.domain.InvoiceItem;
import th.mfu.domain.Payment;
import th.mfu.exception.DishNotEnoughException;
import th.mfu.repository.DishesRepository;
import th.mfu.repository.InvoiceItemRepository;
import th.mfu.repository.InvoiceRepository;
import th.mfu.repository.MaterialRepository;
import th.mfu.repository.PaymentRepository;
import th.mfu.repository.UserRepository;

@Controller
public class InvoiceController {
    @Autowired
    DishesRepository dishesRepo;
    @Autowired
    InvoiceRepository invoiceRepo;
    @Autowired
    InvoiceItemRepository invoiceItemRepo;
    @Autowired
    PaymentRepository paymentRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    MaterialRepository matRepo;

    public InvoiceController(DishesRepository dishesRepo, InvoiceRepository invoiceRepo,
            InvoiceItemRepository invoiceItemRepo, PaymentRepository paymentRepo, UserRepository userRepo,
            MaterialRepository matRepo) {
        this.dishesRepo = dishesRepo;
        this.invoiceRepo = invoiceRepo;
        this.invoiceItemRepo = invoiceItemRepo;
        this.paymentRepo = paymentRepo;
        this.userRepo = userRepo;
        this.matRepo = matRepo;

    }

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @PostMapping("/confirm_cart")
    public String confirmCart(@RequestParam("invoiceNote") String invoiceNote, Model model) {

        //find all invoiceitem
        var invoiceItemlist = invoiceItemRepo.findAll();
        //create date
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        //invoice-------------------------------------------------------------------
        var temp_invoice = new Invoice();
        // set invoice user
        temp_invoice.setUser(userRepo.findById((long) 1).get());
        // set invoice date
        temp_invoice.setInvoice_date(date);
        // set invoice note
        temp_invoice.setInvoice_note(invoiceNote);
        // finally save it
        invoiceRepo.save(temp_invoice);
        // --------------------------------------------------------------------------

        // add all invoiceitem to invoice
        // also calculate total price
        Integer totalprice = 0;
        for (InvoiceItem InvoiceItem : invoiceItemlist) {

            if (InvoiceItem.getInvoice() == null) {
                InvoiceItem.setInvoice(invoiceRepo.findTopByOrderByIdDesc());
                // total price = dishAmount * dish_price
                totalprice += (InvoiceItem.getDishAmount()) *
                        (InvoiceItem.getDishes().getDish_price());

                invoiceItemRepo.save(InvoiceItem);
            }
        }

        //payment-------------------------------------------------------------------
        var temp_payment = new Payment();
        temp_payment.setPay_Date(date);
        temp_payment.setPay_total(totalprice);
        paymentRepo.save(temp_payment);

        // ---------------------------------------------------------------------------------

        // set last payment to last invoice
        Invoice tempinvoice = invoiceRepo.findTopByOrderByIdDesc();
        Payment temppay = paymentRepo.findTopByOrderByIdDesc();
        tempinvoice.setPayment(temppay);
        invoiceRepo.save(tempinvoice);
        paymentRepo.save(temppay);

        return "redirect:/user";
    }
    
    // deleted in cart ///
    @GetMapping("/delete-cart/{id}")
    public String deletedIncart(@PathVariable Long id) {
        InvoiceItem invoiceItem = invoiceItemRepo.findById(id).orElseThrow(() -> new DishNotEnoughException(id));

        // Retrieve the dish associated with the invoice item
        Dishes dish = invoiceItem.getDishes();

        // Retrieve the quantity of the item being deleted
        int quantityRemoved = invoiceItem.getDishAmount(); // Get the original quantity added to the cart

        // Increase the dish_stock by the quantity removed from the cart
        dish.setDish_stock(dish.getDish_stock() + quantityRemoved);
        dishesRepo.save(dish);

        // Delete the item from the cart
        invoiceItemRepo.delete(invoiceItem);

        return "redirect:/user";
    }
}
