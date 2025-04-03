package spring.boot.quan_ly_chi_tieu_ca_nhan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.quan_ly_chi_tieu_ca_nhan.model.Expense;
import spring.boot.quan_ly_chi_tieu_ca_nhan.repository.ExpenseRepository;
@Service
public class ExpenseService {
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
    public Expense update(Long id, Expense expense) {
        if (expenseRepository.existsById(id)) {
            expense.setId(id);
            return expenseRepository.save(expense);
        }
        return null; // Hoặc ném ngoại lệ
}
}