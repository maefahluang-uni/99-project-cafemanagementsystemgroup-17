package th.mfu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import th.mfu.domain.Dishes;
import th.mfu.repository.DishesRepository;
import th.mfu.repository.InvoiceItemRepository;
import th.mfu.repository.InvoiceRepository;
import th.mfu.repository.MaterialRepository;
import th.mfu.repository.PaymentRepository;
import th.mfu.repository.UserRepository;

@Controller
public class UserViewController {
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


    public UserViewController(DishesRepository dishesRepo, InvoiceRepository invoiceRepo,
            InvoiceItemRepository invoiceItemRepo, PaymentRepository paymentRepo, UserRepository userRepo,
            MaterialRepository matRepo) {
        this.dishesRepo = dishesRepo;
        this.invoiceRepo = invoiceRepo;
        this.invoiceItemRepo = invoiceItemRepo;
        this.paymentRepo = paymentRepo;
        this.userRepo = userRepo;
        this.matRepo = matRepo;

    }
 
    @GetMapping("/user")
    public String listforUser(Model model, String keyword) {
        // model.addAttribute("dishes", dishesRepo.findAll());
        // only show InvoiceItem that invoice = null
        model.addAttribute("invoiceitem", invoiceItemRepo.findByInvoiceIsNull());
        // only show InvoiceItem that itemStatus not null
        model.addAttribute("invoiceitemByStatus", invoiceItemRepo.findByItemStatusIsNotNull());
        // show active dishes
        if (keyword != null) {
            model.addAttribute("dishes", dishesRepo.findByKeywordAndDishStatus(keyword, "active"));
        } else {
            model.addAttribute("dishes", dishesRepo.findByDishStatus("active"));
        }
        // show top 3 sale
        List<Object[]> top3PopularDishes = invoiceItemRepo.findTop3Sale();
        if (!top3PopularDishes.isEmpty() && top3PopularDishes.size() >= 3) {
            List<Dishes> top3dishes = new ArrayList<>();
            int count = 0;
            for (Object[] result : top3PopularDishes) {
                Dishes dishes = (Dishes) result[1];
                // Long totalAmount = (Long) result[0];
                // System.out.println("Dishes " + dishes.getDish_name() + ", Total Amount: " +
                // totalAmount);
                count++;
                top3dishes.add(dishes);
                if (count >= 3) {
                    model.addAttribute("top3dishes", top3dishes);
                    break;
                }
            }
        }
        return "user";
    }

}
