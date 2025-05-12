package spring.boot.quan_ly_chi_tieu_ca_nhan.model;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
    
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="user_id")
    private Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy= "user", cascade= CascadeType.ALL)
    @SuppressWarnings("unused")
    private List<Income> incomes;
    
    @OneToMany(mappedBy="user", cascade= CascadeType.ALL)
    @SuppressWarnings("unused")
    private List<Expense> expenses;
    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
