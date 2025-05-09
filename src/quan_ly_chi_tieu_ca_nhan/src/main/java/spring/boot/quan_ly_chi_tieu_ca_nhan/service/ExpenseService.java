package spring.boot.quan_ly_chi_tieu_ca_nhan.service;

import java.util.List;

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
    // Lấy mức thu nhập hiện tại
    Double currentIncome = incomeRepository.findCurrentIncome(); // Giả sử bạn có phương thức này trong IncomeRepository
    
    // Lấy tổng chi tiêu hiện tại
    Double totalExpenses = expenseRepository.calculateTotalExpenses(); // Giả sử bạn có phương thức này trong ExpenseRepository

    // Kiểm tra nếu chi tiêu vượt quá thu nhập
    if (totalExpenses + expense.getAmount() > currentIncome) {
        return "Cảnh báo: Chi tiêu vượt quá thu nhập!";
    }

    // Lưu chi tiêu vào cơ sở dữ liệu nếu hợp lệ
    expenseRepository.save(expense);
    return "Chi tiêu đã được thêm thành công.";
}
}