package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import th.mfu.domain.Material;
import th.mfu.repository.DishesRepository;
import th.mfu.repository.InvoiceItemRepository;
import th.mfu.repository.InvoiceRepository;
import th.mfu.repository.MaterialRepository;
import th.mfu.repository.PaymentRepository;
import th.mfu.repository.UserRepository;
import th.mfu.service.DishesService;
import th.mfu.service.MaterialService;

@Controller
public class MaterialController {
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

    public MaterialController(DishesRepository dishesRepo, InvoiceRepository invoiceRepo,
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

    /// material controller ///
    @GetMapping("/delete-mat/{id}")
    public String deleteMat(@PathVariable Long id) {
        matRepo.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/delete-mat")
    public String removeAllMat() {
        matRepo.deleteAll();
        return "redirect:/admin";
    }

    @GetMapping("/add-mat")
    public String addMatForm(Model model) {
        model.addAttribute("materials", new Material());
        return "add-mat-form";
    }

    @GetMapping("/update-mat/{id}")
    public String updateMatForm(Model model, @PathVariable Long id) {
        model.addAttribute("materials", matRepo.findById(id));
        return "add-mat-form-id";
    }

    @PostMapping("/admin_update_mat")
    public String updateMat(@ModelAttribute("materials") Material materials, @RequestParam("id") Long id) {
        materialService.updateMat(id,
                materials.getMat_name(),
                materials.getMat_amount());
        return "redirect:/admin";
    }

    @PostMapping("/admin_saveMat")
    public String saveMat(@ModelAttribute Material newmaterials) {
        matRepo.save(newmaterials);
        return "redirect:/admin";
    }
}
