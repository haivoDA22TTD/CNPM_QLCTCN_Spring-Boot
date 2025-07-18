package spring.boot.quan_ly_chi_tieu_ca_nhan.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="incomes")
public class Income {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Long id;

    private String source;   // Nguồn thu nhập
    private Integer amount;   // Số tiền
    private LocalDate date;  // Ngày thu nhập

    @ManyToOne
    @JoinColumn(name="user_id")
    @SuppressWarnings("unused")
    private User user;

    public Income() {
    }

    public Income(Long id, String source, Integer amount, LocalDate date) {
        this.id = id;
        this.source = source;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    
}
