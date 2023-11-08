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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import th.mfu.domain.Dishes;
import th.mfu.domain.InvoiceItem;
import th.mfu.exception.DishNotEnoughException;
import th.mfu.repository.DishesRepository;
import th.mfu.repository.InvoiceItemRepository;
import th.mfu.repository.InvoiceRepository;
import th.mfu.repository.MaterialRepository;
import th.mfu.repository.PaymentRepository;
import th.mfu.repository.UserRepository;
import th.mfu.service.DishesService;
import th.mfu.service.MaterialService;

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

    @PostMapping("/admin_saveDishes")
    public String saveDish(@ModelAttribute Dishes newdishes) {
        dishesRepo.save(newdishes);
        return "redirect:/admin";
    }

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

    /// add dishes to cart ///
    @PostMapping("/add-to-cart/{id}")
    public String addtocart(Model model, @PathVariable Long id,
            @RequestParam("quantity") Integer quantity,
            @RequestParam("sweetness") String sweetness,
            @RequestParam("type") String type,
            @RequestParam("roast") String roast,
            @RequestParam("add") String add) {

        Dishes dish = dishesRepo.findById(id).orElseThrow(() -> new DishNotEnoughException(id));

        if (dish.getDish_stock() >= quantity) {
            // There is sufficient stock, so add the item to the cart
            InvoiceItem invoiceitem = new InvoiceItem();


            // set itemNote
            String note = "none";
            String typetemp = dish.getDishtype();

            switch (typetemp) {
                case "coffee":
                    note = "Sweetness: "+sweetness+" Type: "+type+" Roast: "+roast+" Add: "+add;
                    break;
                case "tea":
                    note = "Sweetness: "+sweetness+" Type: "+type;
                    break;
                case "smoothie": 
                    note = "Sweetness: "+sweetness;
                    break;
                default:
                    System.out.println("error naja");
                    break;
            }

            System.out.println(note);
            invoiceitem.setItemNote(note);
            invoiceitem.setDishes(dish);
            invoiceitem.setDishAmount(quantity);
            invoiceItemRepo.save(invoiceitem);

            // Reduce the dish_stock by quantity
            dish.setDish_stock(dish.getDish_stock() - quantity);
            dishesRepo.save(dish);

            return "redirect:/user";
        } else {
            // Handle the scenario where there is insufficient stock
            model.addAttribute("errorMessage", "Sorry, there is not enough stock for this item.");
            return "showerror";
        }
    }

}
