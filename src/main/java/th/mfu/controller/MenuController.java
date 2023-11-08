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

import th.mfu.repository.DishesRepository;
import th.mfu.repository.InvoiceItemRepository;
import th.mfu.repository.InvoiceRepository;
import th.mfu.repository.MaterialRepository;
import th.mfu.repository.UserRepository;



@Controller
public class MenuController {

    @Autowired
    DishesRepository dishesRepo;
    @Autowired
    InvoiceRepository invoiceRepo;
    @Autowired
    InvoiceItemRepository invoiceItemRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    MaterialRepository matRepo;

    public MenuController(DishesRepository dishesRepo, InvoiceRepository invoiceRepo,
            InvoiceItemRepository invoiceItemRepo, UserRepository userRepo) {
        this.dishesRepo = dishesRepo;
        this.invoiceRepo = invoiceRepo;
        this.invoiceItemRepo = invoiceItemRepo;
        this.userRepo = userRepo;

    }

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/user-search-tea")
    public String searchTea(Model model) {
        model.addAttribute("dishes", dishesRepo.findByDishtype("tea"));

        // only show InvoiceItem that invoice = null
        model.addAttribute("invoiceitem", invoiceItemRepo.findByInvoiceIsNull());
        return "user";
    }

    @GetMapping("/user-search-coffee")
    public String searchCoffee(Model model) {
        model.addAttribute("dishes", dishesRepo.findByDishtype("coffee"));

        // only show InvoiceItem that invoice = null
        model.addAttribute("invoiceitem", invoiceItemRepo.findByInvoiceIsNull());
        return "user";
    }

    @GetMapping("/user-search-smoothie")
    public String searchSmoothie(Model model) {
        model.addAttribute("dishes", dishesRepo.findByDishtype("smoothie"));

        // only show InvoiceItem that invoice = null
        model.addAttribute("invoiceitem", invoiceItemRepo.findByInvoiceIsNull());
        return "user";
    }

    @GetMapping("/user-search-dessert")
    public String searchDessert(Model model) {
        model.addAttribute("dishes", dishesRepo.findByDishtype("dessert"));

        // only show InvoiceItem that invoice = null
        model.addAttribute("invoiceitem", invoiceItemRepo.findByInvoiceIsNull());
        return "user";
    }
}
