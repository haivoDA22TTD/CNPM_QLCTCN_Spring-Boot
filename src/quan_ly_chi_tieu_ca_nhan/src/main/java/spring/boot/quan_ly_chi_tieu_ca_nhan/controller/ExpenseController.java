package spring.boot.quan_ly_chi_tieu_ca_nhan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import spring.boot.quan_ly_chi_tieu_ca_nhan.model.Expense;
import spring.boot.quan_ly_chi_tieu_ca_nhan.repository.ExpenseRepository;
@Controller
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/expense")

    public String showManageExpensePage(Model model) {
        List<Expense> expenses = expenseRepository.findAll(); // Lấy tất cả chi tiêu
        model.addAttribute("expenses", expenses); // Thêm vào model
        return "manage/expense"; // Trả về view
    }
     @PostMapping("/expense")
    public String addExpense(@ModelAttribute Expense expense) {
        expenseRepository.save(expense);
        return "redirect:/expense";
    }

   @PostMapping("/expense/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseRepository.deleteById(id);
        return "redirect:/expense"; // Chuyển hướng về trang quản lý chi tiêu
    }

    @PutMapping("/expense/{id}")
    public String editExpense(@PathVariable Long id, @ModelAttribute Expense expense) {
        expense.setId(id);
        expenseRepository.save(expense);
        return "redirect:/expense";
    }
}
