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
import th.mfu.domain.InvoiceItem;
import th.mfu.domain.Material;

@Controller
public class CafeController {
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

    public CafeController(DishesRepository dishesRepo, InvoiceRepository invoiceRepo,
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
    @GetMapping("/admin")
    public String dishesListAdmin(Model model) {
        model.addAttribute("dishes", dishesRepo.findAll());
        model.addAttribute("materials", matRepo.findAll());
        model.addAttribute("invoice", invoiceRepo.findAll());
        model.addAttribute("payment", paymentRepo.findAll());
        return "list-for-admin";
    }

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
    @PostMapping("/admin")
    public String saveDish(@ModelAttribute Dishes newdishes, @ModelAttribute Material newmaterials) {
        dishesRepo.save(newdishes);
        matRepo.save(newmaterials);
        return "redirect:/admin";
    }

    @PostMapping("/admin_update_dish")
    public String updateDish(@ModelAttribute("dishes") Dishes dishes, @RequestParam("id") Long id) {
        dishesService.updateDish(id,
                dishes.getDish_name(),
                dishes.getDish_type(),
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

    /// user controller////

    @GetMapping("/user")
    public String listforUser(Model model) {
        model.addAttribute("dishes", dishesRepo.findAll());

        // only show InvoiceItem that invoice = null
        model.addAttribute("invoiceitem", invoiceItemRepo.findByInvoiceIsNull());
        return "user";
    }

    /// cart user go to new form ///
    @PostMapping("/add-to-cart/{id}")
public String addtocart(Model model, @PathVariable Long id, @RequestParam("quantity") Integer quantity) {

    Dishes dish = dishesRepo.findById(id).orElseThrow(() -> new DishNotEnoughException(id));

    if (dish.getDish_stock() >= quantity) {
        // There is sufficient stock, so add the item to the cart
        InvoiceItem invoiceitem = new InvoiceItem();
        invoiceitem.setDishes(dish);
        invoiceitem.setDish_amount(quantity);
        invoiceItemRepo.save(invoiceitem);

        // Reduce the dish_stock by quantity
        dish.setDish_stock(dish.getDish_stock() - quantity);
        dishesRepo.save(dish);

        return "redirect:/user";
    } else {
        // Handle the scenario where there is insufficient stock
        model.addAttribute("errorMessage", "Sorry, there is not enough stock for this item.");
        return "error";
    }
}


    // deleted in cart ///
    @GetMapping("/delete-cart/{id}")
public String deletedIncart(@PathVariable Long id) {
    InvoiceItem invoiceItem = invoiceItemRepo.findById(id).orElseThrow(() -> new DishNotEnoughException(id));

    // Retrieve the dish associated with the invoice item
    Dishes dish = invoiceItem.getDishes();

    // Retrieve the quantity of the item being deleted
    int quantityRemoved = invoiceItem.getDish_amount(); // Get the original quantity added to the cart

    // Increase the dish_stock by the quantity removed from the cart
    dish.setDish_stock(dish.getDish_stock() + quantityRemoved);
    dishesRepo.save(dish);

    // Delete the item from the cart
    invoiceItemRepo.delete(invoiceItem);

    return "redirect:/user";
}


    // select number of dishes_stock and reduce dishes in dishes_stock ////
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
}
