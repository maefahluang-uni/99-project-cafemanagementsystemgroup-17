package th.mfu;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import th.mfu.domain.Dishes;

@Controller
public class DishesController {
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

    private final DishesService dishesService;
    private final MaterialService materialService;

    public DishesController(DishesRepository dishesRepo, InvoiceRepository invoiceRepo,
            InvoiceItemRepository invoiceItemRepo, PaymentRepository paymentRepo, UserRepository userRepo,
            DishesService dishesService, MaterialRepository matRepo, MaterialService materialService) {
        this.dishesRepo = dishesRepo;
        this.invoiceRepo = invoiceRepo;
        this.invoiceItemRepo = invoiceItemRepo;
        this.paymentRepo = paymentRepo;
        this.userRepo = userRepo;
        this.dishesService = dishesService;
        this.matRepo = matRepo;
        this.materialService = materialService;

    }

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    // admin controller dish///
    @GetMapping("/add-dish")
    public String addDishForm(Model model) {
        model.addAttribute("dishes", new Dishes());
        return "add-dish-form";
    }

    @GetMapping("/update-dish/{id}")
    public String updateDishForm(Model model, @PathVariable Long id) {
        model.addAttribute("dishes", dishesRepo.findById(id));
        model.addAttribute("dishID", id);
        return "add-dish-form-id";
    }

    // @model and use mat repo////
    // @PostMapping("/admin")
    // public String saveDish(@ModelAttribute Dishes newdishes) {
    //     dishesRepo.save(newdishes);
    //     return "redirect:/admin";
    // }

    @PostMapping("/admin_update_dish")
    public String updateDish(@ModelAttribute("dishes") Dishes dishes, @RequestParam("id") Long id) {
        dishesService.updateDish(id,
                dishes.getDish_name(),
                dishes.getDishtype(),
                dishes.getDish_picture(),
                dishes.getDish_stock(),
                dishes.getDish_price());
        return "redirect:/admin";
    }

    @GetMapping("/delete-dish/{id}")
    public String deleteCafe(@PathVariable Long id) {
        dishesRepo.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/delete-dish")
    public String removeAllCafe() {
        dishesRepo.deleteAll();
        return "redirect:/admin";
    }
}
