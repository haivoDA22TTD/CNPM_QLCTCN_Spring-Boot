package spring.boot.quan_ly_chi_tieu_ca_nhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import spring.boot.quan_ly_chi_tieu_ca_nhan.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
    @Query("SELECT SUM(e.amount) FROM Expense e")
    Double calculateTotalExpenses();
}
