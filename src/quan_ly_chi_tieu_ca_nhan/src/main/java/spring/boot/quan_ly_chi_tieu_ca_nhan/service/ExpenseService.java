package spring.boot.quan_ly_chi_tieu_ca_nhan.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.quan_ly_chi_tieu_ca_nhan.model.Expense;
import spring.boot.quan_ly_chi_tieu_ca_nhan.repository.ExpenseRepository;
import spring.boot.quan_ly_chi_tieu_ca_nhan.repository.IncomeRepository;
@Service
public class ExpenseService {
     @Autowired
     private IncomeRepository incomeRepository;
     @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense add(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }

    public Expense findById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }
   public List<Expense> getAllExpenses(){
    return expenseRepository.findAll();
   }
   public String addExpense(Expense expense) {
    Double totalIncome = incomeRepository.getTotalIncome();
    if (totalIncome == null) totalIncome = 0.0;

    if (expense.getAmount() != null && expense.getAmount() > totalIncome) {
        return "Cảnh báo: Chi tiêu vượt quá thu nhập!";
    }

    expenseRepository.save(expense);
    return "Chi tiêu đã được lưu.";
}

public int getTotalExpense() {
    return expenseRepository.findAll()
            .stream()
            .mapToInt(Expense::getAmount)
            .sum();
}
      // Phương thức để lấy chi tiêu hàng tháng
    public Map<String, Integer> getMonthlyExpenses() {
        List<Expense> expenses = expenseRepository.findAll();

        // Nhóm chi tiêu theo tháng và tính tổng
        return expenses.stream()
            .collect(Collectors.groupingBy(
                expense -> expense.getDate().substring(0, 7), // Giả định date là dạng YYYY-MM-DD
                Collectors.summingInt(Expense::getAmount)
            ));
    }
}