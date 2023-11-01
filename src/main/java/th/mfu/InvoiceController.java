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
        temp_invoice.setInvoice_note("note in invoice kub");
        // finally save it
        invoiceRepo.save(temp_invoice);
        // --------------------------------------------------------------------------

        // add all invoiceitem to invoice
        // also calculate total price
        Integer totalprice = 0;
        for (InvoiceItem InvoiceItem : invoiceItemlist) {

            if (InvoiceItem.getInvoice() == null) {
                InvoiceItem.setInvoice(invoiceRepo.findTopByOrderByIdDesc());
                // total price = dish_amount * dish_price
                totalprice += (InvoiceItem.getDish_amount()) *
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
}
