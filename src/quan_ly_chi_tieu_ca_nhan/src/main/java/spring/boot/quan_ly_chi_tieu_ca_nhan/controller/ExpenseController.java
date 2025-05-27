package spring.boot.quan_ly_chi_tieu_ca_nhan.controller;

import java.util.List;
import java.util.Map;

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
    List<Expense> expenses = expenseRepository.findAll();
    model.addAttribute("expenses", expenses);

    // Tổng chi tiêu (int)
    int totalExpense = expenseService.getTotalExpense();
    model.addAttribute("totalExpense", totalExpense);

    return "manage/expense";
}

    @Operation(summary="Thêm chi tiêu")
    @PostMapping("/expense")
    @SuppressWarnings("CallToPrintStackTrace")
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
        e.printStackTrace(); // Xem chi tiết lỗi trong console
        return "manage/expense";
    }
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

    @GetMapping("/api/expenses/monthly")
    @ResponseBody
        public Map<String, Integer> getMonthlyExpenses() {
    return expenseService.getMonthlyExpenses();
}
    @GetMapping("/show")
public String showStatisticsPage(Model model) {
    // hiển thị trang thống kê chi tiêu
    return "manage/show"; 
}
}
