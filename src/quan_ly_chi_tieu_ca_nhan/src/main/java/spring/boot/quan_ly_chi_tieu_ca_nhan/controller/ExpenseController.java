package spring.boot.quan_ly_chi_tieu_ca_nhan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import spring.boot.quan_ly_chi_tieu_ca_nhan.model.Expense;
import spring.boot.quan_ly_chi_tieu_ca_nhan.service.ExpenseService;

@Controller
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    // Hiển thị danh sách chi tiêu
    @GetMapping("/expense/expense_list")
    public String listExpenses(Model model) {
        List<Expense> expenses = expenseService.findAll();
        model.addAttribute("expenses", expenses);
        return "expense/expense_list"; 
    }

    // Mở form để thêm chi tiêu mới
    @GetMapping("/manageExpense")
    public String addExpenseForm() {
        return "expense/manageExpense"; 
    }

    // Thêm chi tiêu mới
    @PostMapping("/expense/manage_expense")
    public String addExpense(@ModelAttribute Expense expense) {
        expenseService.save(expense);
        return "redirect:/expense/expense_list";
    }

    // Mở form để chỉnh sửa chi tiêu
    @GetMapping("/expense/edit/{id}")
    public String editExpenseForm(@PathVariable Long id, Model model) {
        Expense expense = expenseService.findById(id);
        model.addAttribute("expense", expense);
        return "expense/manage_expense";
    }

    // Cập nhật chi tiêu đã chỉnh sửa
    @PostMapping("/expense/edit/{id}")
    public String editExpense(@PathVariable Long id, @ModelAttribute Expense expense) {
        expense.setId(id);
        expenseService.save(expense);
        return "redirect:/expense/expense_list"; 
    }

    // Xóa chi tiêu
    @GetMapping("/expense/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteById(id);
        return "redirect:/expense/expense_list"; 
    }
}
