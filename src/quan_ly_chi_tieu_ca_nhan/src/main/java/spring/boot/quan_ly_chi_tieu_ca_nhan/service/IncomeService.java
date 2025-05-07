package spring.boot.quan_ly_chi_tieu_ca_nhan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import spring.boot.quan_ly_chi_tieu_ca_nhan.model.Income;
import spring.boot.quan_ly_chi_tieu_ca_nhan.repository.IncomeRepository;
@Service
public class IncomeService {
    
    private final IncomeRepository incomeRepository;

    
    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    // Thêm mới thu nhập
    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }

    // Lấy tất cả thu nhập
    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    // Lấy thu nhập theo ID
    public Optional<Income> getIncomeById(Long id) {
        return incomeRepository.findById(id);
    }

    // Cập nhật thu nhập
    public Income updateIncome(Long id, Income incomeDetails) {
        Income income = incomeRepository.findById(id).orElseThrow(() -> new RuntimeException("Income not found"));
        income.setSource(incomeDetails.getSource());
        income.setAmount(incomeDetails.getAmount());
        income.setDate(incomeDetails.getDate());
        return incomeRepository.save(income);
    }

    // Xóa thu nhập
    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}
