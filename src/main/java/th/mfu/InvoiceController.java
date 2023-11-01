package th.mfu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

import th.mfu.domain.Invoice;
import th.mfu.domain.InvoiceItem;
import th.mfu.domain.Payment;

import org.springframework.ui.Model;

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

    @GetMapping("/confirm_cart")
    public String confirmCart(Model model) {

        // create empty invoice
        var temp_invoice = new Invoice();
        var invoiceItemlist = invoiceItemRepo.findAll();

        // add user id to invoice
        temp_invoice.setUser(userRepo.findById((long) 1).get());

        // add current date to invoice
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        temp_invoice.setInvoice_date(date);

        // create payment
        var temp_payment = new Payment();
        //set pay date
        temp_payment.setPay_Date(date);

        // total price counter
        Integer totalprice = 0;

        // add all invoiceitem to invoice
        for (InvoiceItem InvoiceItem : invoiceItemlist) {

            if (InvoiceItem.getInvoice() == null) {
                InvoiceItem.setInvoice(temp_invoice);
                //total price = dish_amount * dish_price
                totalprice += (InvoiceItem.getDish_amount()) *
                        (InvoiceItem.getDishes().getDish_price());
            }
        }

        temp_payment.setPay_total(totalprice);
        temp_invoice.setPayment(temp_payment);
        
        invoiceRepo.save(temp_invoice);
        paymentRepo.save(temp_payment);

        return "redirect:/user";
    }
}
