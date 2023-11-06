package th.mfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import th.mfu.domain.Dishes;
import th.mfu.domain.Material;

@Controller
public class AdminController {
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

    public AdminController(DishesRepository dishesRepo, InvoiceRepository invoiceRepo,
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

    @GetMapping("/admin")
    public String dishesListAdmin(Model model) {
        model.addAttribute("dishes", dishesRepo.findAll());
        model.addAttribute("materials", matRepo.findAll());
        model.addAttribute("invoice", invoiceRepo.findAll());
        model.addAttribute("payment", paymentRepo.findAll());
        return "list-for-admin";
    }

    @PostMapping("/admin")
    public String saveDish(@ModelAttribute Dishes newdishes) {
        dishesRepo.save(newdishes);
        return "redirect:/admin";
    }
    @PostMapping("/admin_saveMat")
    public String saveMat(@ModelAttribute Material newmaterials) {
        matRepo.save(newmaterials);
        return "redirect:/admin";
    }
}
