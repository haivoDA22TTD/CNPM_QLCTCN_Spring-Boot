package spring.boot.quan_ly_chi_tieu_ca_nhan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.quan_ly_chi_tieu_ca_nhan.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
   
    Optional<User> findByUsername(String username);
    
}
