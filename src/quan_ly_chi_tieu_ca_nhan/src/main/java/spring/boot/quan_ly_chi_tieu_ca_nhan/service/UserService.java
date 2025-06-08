package spring.boot.quan_ly_chi_tieu_ca_nhan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import spring.boot.quan_ly_chi_tieu_ca_nhan.model.User;
import spring.boot.quan_ly_chi_tieu_ca_nhan.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
 @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll(); // Trả về danh sách người dùng
    }

    public Optional<User> getUserByUsername(String username) {
    return userRepository.findByUsername(username); //  trả về Optional
}

    
}
