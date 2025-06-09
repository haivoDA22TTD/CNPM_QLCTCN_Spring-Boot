package spring.boot.quan_ly_chi_tieu_ca_nhan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import spring.boot.quan_ly_chi_tieu_ca_nhan.model.Expense;
import spring.boot.quan_ly_chi_tieu_ca_nhan.repository.ExpenseRepository;
import spring.boot.quan_ly_chi_tieu_ca_nhan.service.ExpenseService;
@Controller
public class ExpenseController {

     @Autowired private ExpenseService expenseService;
    @Autowired private ExpenseRepository expenseRepository;

    @GetMapping("/expense")
    public String showManageExpensePage(Model model) {
        List<Expense> expenses = expenseRepository.findAll();
        model.addAttribute("expenses", expenses);
        model.addAttribute("totalExpense", expenseService.getTotalExpense());
        return "manage/expense";
    }

    @PostMapping("/expense")
    public String addExpense(@ModelAttribute Expense expense, Model model) {
        try {
            String message = expenseService.addExpense(expense);
            if (message.startsWith("Cảnh báo")) {
                model.addAttribute("message", message);
                return "manage/expense";
            }
            return "redirect:/expense";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi hệ thống: " + e.getMessage());
            return "manage/expense";
        }
    }

    @DeleteMapping("/expense/{id}")
    public String deleteExpense(@PathVariable Long id) {
    expenseRepository.deleteById(id);
    return "redirect:/expense";
}

    @GetMapping("/show")
    public String showStatisticsPage(Model model) {
        return "manage/show"; 
    }
}
