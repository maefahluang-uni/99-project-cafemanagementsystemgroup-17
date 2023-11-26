package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import th.mfu.domain.Expense;
import th.mfu.domain.Payment;
import th.mfu.repository.DishesRepository;
import th.mfu.repository.ExpenseRepository;
import th.mfu.repository.InvoiceItemRepository;
import th.mfu.repository.InvoiceRepository;
import th.mfu.repository.MaterialRepository;
import th.mfu.repository.PaymentRepository;
import th.mfu.repository.UserRepository;

@Controller
public class AdminViewController {
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
    @Autowired
    ExpenseRepository expRepo;

    public AdminViewController(DishesRepository dishesRepo, InvoiceRepository invoiceRepo,
            InvoiceItemRepository invoiceItemRepo, PaymentRepository paymentRepo, UserRepository userRepo,
            MaterialRepository matRepo,
            ExpenseRepository expRepo) {
        this.dishesRepo = dishesRepo;
        this.invoiceRepo = invoiceRepo;
        this.invoiceItemRepo = invoiceItemRepo;
        this.paymentRepo = paymentRepo;
        this.userRepo = userRepo;
        this.matRepo = matRepo;
        this.expRepo = expRepo;

    }

    @GetMapping("/admin")
    public String dishesListAdmin(Model model, String keyword) {
        if (keyword != null) {
            model.addAttribute("dishes", dishesRepo.findByKeyword(keyword));
        } else {
            model.addAttribute("dishes", dishesRepo.findAll());
        }
        if (keyword != null) {
            model.addAttribute("materials", matRepo.findByKeyword(keyword));
        } else {
            model.addAttribute("materials", matRepo.findAll());
        }
        model.addAttribute("invoice", invoiceRepo.findAll());
        model.addAttribute("payment", paymentRepo.findAll());
        model.addAttribute("invoiceitem", invoiceItemRepo.findAll());
        model.addAttribute("expense", expRepo.findAll());

        // total = sale-expense
        Integer totalsale = 0;
        Iterable<Payment> paymentlist = paymentRepo.findAll();
        for (Payment payment : paymentlist) {
            totalsale += payment.getPay_total();
        }
        Iterable<Expense> expenseList = expRepo.findAll();
        for (Expense expense : expenseList) {
            totalsale -= expense.getExpTotal();
        }
        model.addAttribute("totalsale", totalsale);

        // Count the number of dishes
        long numberOfDishes = dishesRepo.count();
        model.addAttribute("numberOfDishes", numberOfDishes);
        // Count the number of materrial
        long numberOfMat = matRepo.count();
        model.addAttribute("numberOfMat", numberOfMat);
        // Count the number of invoiceitemlist
        long numberOfInvoiceitem = invoiceItemRepo.count();
        model.addAttribute("numberOfInvoiceitem", numberOfInvoiceitem);
        return "list-for-admin";
    }

}
