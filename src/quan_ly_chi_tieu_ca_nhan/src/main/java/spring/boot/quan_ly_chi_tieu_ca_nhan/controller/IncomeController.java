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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.Operation;
import spring.boot.quan_ly_chi_tieu_ca_nhan.model.Income;
import spring.boot.quan_ly_chi_tieu_ca_nhan.repository.IncomeRepository;
import spring.boot.quan_ly_chi_tieu_ca_nhan.service.IncomeService;

@Controller
public class IncomeController {
    @Autowired
    private IncomeRepository incomeRepository; // Sử dụng IncomeRepository

    @Autowired
    private IncomeService incomeService; // Sử dụng IncomeService

    // Hiển thị trang quản lý thu nhập
     @GetMapping("/income")
    public String showIncomePage(Model model) {
        List<Income> incomes = incomeRepository.findAll();
        model.addAttribute("incomes", incomes);

        int totalIncome = incomeService.getTotalIncome();
        model.addAttribute("totalIncome", totalIncome);

        return "manage/income"; // Tên file HTML giao diện (income.html)
    }
    @Operation(summary="Thêm khoản thu nhập")
    @PostMapping("/income")
    public String addIncome(@ModelAttribute Income income) {
        incomeRepository.save(income);
        return "redirect:/income";
    }
    

    @Operation(summary="Xóa khoản thu nhập")
    @DeleteMapping("/income/{id}")
    public String deleteIncome(@PathVariable Long id) {
        incomeRepository.deleteById(id); // Xóa thu nhập theo ID
        return "redirect:/income"; // Chuyển hướng về trang quản lý thu nhập
    }

    @Operation(summary="Cập nhật khoản thu nhập")
    @PutMapping("/income/{id}")
    public String editIncome(@PathVariable Long id, @ModelAttribute Income income) {
        income.setId(id); // Cập nhật ID cho đối tượng Income
        incomeRepository.save(income); // Lưu thông tin thu nhập đã sửa
        return "redirect:/income"; // Chuyển hướng về trang quản lý thu nhập
    }
    
    @Operation(summary="Hiển thị API thu nhập")
    // API trả về danh sách tất cả thu nhập (JSON)
    @GetMapping("/api/incomes") 
    @ResponseBody // Trả về JSON
    public List<Income> getAllIncomes() {
        return incomeService.getAllIncomes(); // Lấy danh sách thu nhập từ service
    }
}
