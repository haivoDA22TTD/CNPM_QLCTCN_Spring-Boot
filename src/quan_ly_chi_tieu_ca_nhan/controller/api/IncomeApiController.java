package spring.boot.quan_ly_chi_tieu_ca_nhan.controller.api;

import java.util.List;

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
import spring.boot.quan_ly_chi_tieu_ca_nhan.model.Income;
import spring.boot.quan_ly_chi_tieu_ca_nhan.repository.IncomeRepository;
import spring.boot.quan_ly_chi_tieu_ca_nhan.service.IncomeService;

@RestController
@RequestMapping("/api/incomes")
public class IncomeApiController {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private IncomeService incomeService;

    @Operation(summary = "Lấy tất cả khoản thu nhập")
    @GetMapping
    public List<Income> getAllIncomes() {
        return incomeService.getAllIncomes();
    }

    @Operation(summary = "Lấy khoản thu nhập theo ID")
    @GetMapping("/{id}")
    public Income getIncomeById(@PathVariable Long id) {
        return incomeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy thu nhập với id: " + id));
    }

    @Operation(summary = "Thêm khoản thu nhập")
    @PostMapping
    public Income createIncome(@RequestBody Income income) {
        return incomeRepository.save(income);
    }

    @Operation(summary = "Cập nhật khoản thu nhập")
    @PutMapping("/{id}")
    public Income updateIncome(@PathVariable Long id, @RequestBody Income income) {
        if (!incomeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy thu nhập để cập nhật với id: " + id);
        }
        income.setId(id);
        return incomeRepository.save(income);
    }

    @Operation(summary = "Xóa khoản thu nhập")
    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id) {
        if (!incomeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy thu nhập để xóa với id: " + id);
        }
        incomeRepository.deleteById(id);
    }
}
