package spring.boot.quan_ly_chi_tieu_ca_nhan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import spring.boot.quan_ly_chi_tieu_ca_nhan.model.Income;
import spring.boot.quan_ly_chi_tieu_ca_nhan.repository.IncomeRepository;
import spring.boot.quan_ly_chi_tieu_ca_nhan.service.IncomeService;

@Controller
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private IncomeService incomeService;

    // Trang quản lý thu nhập
    @GetMapping("/income")
    public String showIncomePage(Model model) {
        List<Income> incomes = incomeRepository.findAll();
        model.addAttribute("incomes", incomes);
        model.addAttribute("totalIncome", incomeService.getTotalIncome());
        model.addAttribute("income", new Income()); // dùng cho form thêm
        return "manage/income";
    }

    // Thêm thu nhập (từ form)
    @PostMapping("/income")
    public String addIncome(@ModelAttribute("income") Income income) {
        incomeRepository.save(income);
        return "redirect:/income";
    }

    // Xoá thu nhập (form POST)
    @PostMapping("/income/delete/{id}")
    public String deleteIncome(@PathVariable Long id) {
        incomeRepository.deleteById(id);
        return "redirect:/income";
    }

    // Hiển thị form cập nhật (nếu bạn cần form riêng)
    @GetMapping("/income/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Income income = incomeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy thu nhập"));
        model.addAttribute("income", income);
        return "manage/income-edit"; // form cập nhật riêng nếu có
    }

    // Cập nhật thu nhập
    @PostMapping("/income/update/{id}")
    public String updateIncome(@PathVariable Long id, @ModelAttribute Income income) {
        income.setId(id);
        incomeRepository.save(income);
        return "redirect:/income";
    }
}
