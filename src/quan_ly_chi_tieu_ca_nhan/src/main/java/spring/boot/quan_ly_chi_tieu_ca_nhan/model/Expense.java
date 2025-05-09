package spring.boot.quan_ly_chi_tieu_ca_nhan.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "expenses")

public class Expense {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer amount;
    private String date;

    
    
    public Expense() {
    }
    


    public Expense(Long id, String name, Integer amount, String date) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.date = date;
    }



    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Integer getAmount() {
        return amount;
    }


    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    
}