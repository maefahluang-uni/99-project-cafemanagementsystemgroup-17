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

    public CafeController(DishesRepository dishesRepo, InvoiceRepository invoiceRepo,
            InvoiceItemRepository invoiceItemRepo, PaymentRepository paymentRepo, UserRepository userRepo,
            DishesService dishesService, MaterialRepository matRepo) {
        this.dishesRepo = dishesRepo;
        this.invoiceRepo = invoiceRepo;
        this.invoiceItemRepo = invoiceItemRepo;
        this.paymentRepo = paymentRepo;
        this.userRepo = userRepo;
        this.dishesService = dishesService;
        this.matRepo = matRepo;

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

    @PostMapping("/admin")
    public String saveDish(@ModelAttribute Dishes newdishes) {
        dishesRepo.save(newdishes);
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
        model.addAttribute("invoiceitem", invoiceItemRepo.findAll());
        return "user";
    }

    /// cart user go to new form ///
    @GetMapping("/add-to-cart/{id}")
    public String addtocart(Model model, @PathVariable Long id) {

        Dishes dishyy = dishesRepo.findById(id).get();
        InvoiceItem invoiceitem = new InvoiceItem();
        invoiceitem.setDishes(dishyy);
        invoiceItemRepo.save(invoiceitem);
        /// gpt gen ///
        Dishes dish = dishesRepo.findById(id).orElseThrow(() -> new DishNotEnoughException(id));

        if (dish.getDish_stock() > 0) {
            // There is sufficient stock, so add the item to the cart
            invoiceitem.setDishes(dish);
            invoiceItemRepo.save(invoiceitem);

            // Reduce the dish_stock by 1
            dish.setDish_stock(dish.getDish_stock() - 1);
            dishesRepo.save(dish);
        } else if (dish.getDish_stock() == 0) {
            invoiceitem.setDishes(dish);
            invoiceItemRepo.delete(invoiceitem);
            // Reduce the dish_stock by 1
            model.addAttribute("errorMessage", "Sorry, this item is out of stock.");
            dishesRepo.save(dish);
            return "error";
        } else {
            // Handle the scenario where there is insufficient stock
            // You can redirect the user to an error page or display a message
            model.addAttribute("errorMessage", "Sorry, this item is out of stock.");
            return "error";
        }

        return "redirect:/user";
    }

    // deleted in cart ///
    @GetMapping("/delete-cart/{id}")
    public String deletedIncart(@PathVariable Long id) {
        // invoiceItemRepo.deleteById(id);
        InvoiceItem invoiceItem = invoiceItemRepo.findById(id).orElseThrow(() -> new DishNotEnoughException(id));

        // Retrieve the dish associated with the invoice item
        Dishes dish = invoiceItem.getDishes();

        // Retrieve the quantity of the item being deleted
        int quantityRemoved = 1; // Assuming you are deleting one item at a time
        // You can modify this logic if you need to delete more than one item at a time

        // Increase the dish_stock by the quantity removed from the cart
        dish.setDish_stock(dish.getDish_stock() + quantityRemoved);
        dishesRepo.save(dish);

        // Delete the item from the cart
        invoiceItemRepo.delete(invoiceItem);

        return "redirect:/user";
    }

    // select number of dishes_stock and reduce dishes in dishes_stock ////
    /// material controller ///
    
}
