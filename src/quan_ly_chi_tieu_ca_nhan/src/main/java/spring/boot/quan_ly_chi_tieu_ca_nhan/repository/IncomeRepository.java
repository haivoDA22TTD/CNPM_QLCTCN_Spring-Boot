package spring.boot.quan_ly_chi_tieu_ca_nhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import spring.boot.quan_ly_chi_tieu_ca_nhan.model.Income;

public interface IncomeRepository extends JpaRepository<Income, Long>{
@Query("SELECT i.amount FROM Income i ORDER BY i.id DESC LIMIT 1")
    Double findCurrentIncome();
    @Query("SELECT SUM(i.amount) FROM Income i")
    Double getTotalIncome();
}
