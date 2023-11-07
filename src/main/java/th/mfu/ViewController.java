package th.mfu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import th.mfu.domain.Dishes;
import th.mfu.domain.InvoiceItem;
import th.mfu.domain.Material;

@Controller
public class ViewController {
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

    public ViewController(DishesRepository dishesRepo, InvoiceRepository invoiceRepo,
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

    @PostMapping("/admin_saveDishes")
    public String saveDish(@ModelAttribute Dishes newdishes) {
        dishesRepo.save(newdishes);
        return "redirect:/admin";
    }
    @PostMapping("/admin_saveMat")
    public String saveMat(@ModelAttribute Material newmaterials) {
        matRepo.save(newmaterials);
        return "redirect:/admin";
    }
    /// user controller////
    @GetMapping("/user")
    public String listforUser(Model model) {
        model.addAttribute("dishes", dishesRepo.findAll());

        // only show InvoiceItem that invoice = null
        model.addAttribute("invoiceitem", invoiceItemRepo.findByInvoiceIsNull());

        // show top 3 sale
        List<Object[]> top3PopularDishes = invoiceItemRepo.findTop3Sale();
        if (!top3PopularDishes.isEmpty() && top3PopularDishes.size() >= 3) {
            List<Dishes> top3dishes = new ArrayList<>();
            int count = 0;
            for (Object[] result : top3PopularDishes) {
                Dishes dishes = (Dishes) result[1];
                // Long totalAmount = (Long) result[0];
                // System.out.println("Dishes " + dishes.getDish_name() + ", Total Amount: " +
                //         totalAmount);
                count++;
                top3dishes.add(dishes);
                if (count >= 3) {
                    model.addAttribute("top3dishes",top3dishes);
                    break;
                }
            }
        }

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
            invoiceitem.setDishAmount(quantity);
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
        int quantityRemoved = invoiceItem.getDishAmount(); // Get the original quantity added to the cart

        // Increase the dish_stock by the quantity removed from the cart
        dish.setDish_stock(dish.getDish_stock() + quantityRemoved);
        dishesRepo.save(dish);

        // Delete the item from the cart
        invoiceItemRepo.delete(invoiceItem);

        return "redirect:/user";
    }
}
