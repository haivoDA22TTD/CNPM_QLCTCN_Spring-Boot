package spring.boot.quan_ly_chi_tieu_ca_nhan.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.Operation;
import spring.boot.quan_ly_chi_tieu_ca_nhan.model.Expense;
import spring.boot.quan_ly_chi_tieu_ca_nhan.repository.ExpenseRepository;
import spring.boot.quan_ly_chi_tieu_ca_nhan.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseApiController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseService expenseService;

    @Operation(summary = "Lấy tất cả khoản chi tiêu")
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @Operation(summary = "Lấy chi tiêu theo từng tháng")
    @GetMapping("/monthly")
    public Map<String, Integer> getMonthlyExpenses() {
        return expenseService.getMonthlyExpenses();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lấy khoản chi tiêu theo ID")
    public Expense getExpenseById(@PathVariable Long id) {
    return expenseRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy khoản chi tiêu với id: " + id));
}

    @Operation(summary = "Thêm khoản chi tiêu")
    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    @Operation(summary = "Cập nhật khoản chi tiêu")
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        expense.setId(id);
        return expenseRepository.save(expense);
    }

    @Operation(summary = "Xoá khoản chi tiêu")
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseRepository.deleteById(id);
    }
}
