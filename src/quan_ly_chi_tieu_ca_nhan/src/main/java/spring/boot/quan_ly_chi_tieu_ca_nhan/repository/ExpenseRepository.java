package spring.boot.quan_ly_chi_tieu_ca_nhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.quan_ly_chi_tieu_ca_nhan.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
