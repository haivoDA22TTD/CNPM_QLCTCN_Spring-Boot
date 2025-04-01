package spring.boot.quan_ly_chi_tieu_ca_nhan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Expense {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String note;
    private double amount;
   

    public Expense() {
    }

    public Expense(Long id, String category, String note, double amount) {
        this.id = id;
        this.category = category;
        this.note = note;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
