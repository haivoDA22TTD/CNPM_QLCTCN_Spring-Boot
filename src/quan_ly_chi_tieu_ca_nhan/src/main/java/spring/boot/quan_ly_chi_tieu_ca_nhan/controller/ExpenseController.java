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
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.Operation;
import spring.boot.quan_ly_chi_tieu_ca_nhan.model.Expense;
import spring.boot.quan_ly_chi_tieu_ca_nhan.repository.ExpenseRepository;
import spring.boot.quan_ly_chi_tieu_ca_nhan.service.ExpenseService;
@Controller
public class ExpenseController {

    @Autowired
        private ExpenseRepository expenseRepository;
    @Autowired
        private ExpenseService expenseService;
    @GetMapping("/expense")

    public String showManageExpensePage(Model model) {
        List<Expense> expenses = expenseRepository.findAll(); // Lấy tất cả chi tiêu
        model.addAttribute("expenses", expenses); // Thêm vào model
        return "manage/expense"; // Trả về view
    }
    @Operation(summary="Thêm chi tiêu")
    @PostMapping("/expense")
    public String addExpense(@ModelAttribute Expense expense, Model model) {
        String message = expenseService.addExpense(expense); // Kiểm tra chi tiêu với thu nhập

        if (message.startsWith("Cảnh báo")) {
            // Nếu có cảnh báo, thêm thông báo vào model
            model.addAttribute("message", message);
            return "manage/expense"; // Trả về lại trang quản lý chi tiêu với cảnh báo
        }

        return "redirect:/expense"; // Nếu chi tiêu hợp lệ, chuyển hướng về trang danh sách
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

  
    
    @GetMapping("/api/expenses") // Đường dẫn API
    @ResponseBody // Trả về file Json
        public List<Expense> getAllExpenses(){
            return expenseService.getAllExpenses();
        }
}
