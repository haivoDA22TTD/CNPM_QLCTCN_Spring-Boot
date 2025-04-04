package spring.boot.quan_ly_chi_tieu_ca_nhan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.boot.quan_ly_chi_tieu_ca_nhan.model.User;
import spring.boot.quan_ly_chi_tieu_ca_nhan.service.UserService;
@Controller
public class UserController {
 @Autowired
    private UserService userService;

        @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
        userService.registerUser(username, password);
        model.addAttribute("message", "User registered successfully!");
        return "user/login";  // chuyển đến trang đăng nhập
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "user/login"; // Trả về trang đăng nhập
    }

    @GetMapping("/home")
    public String home(Model model) {
        // Lấy tên người dùng từ SecurityContextHolder
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        
        model.addAttribute("username", username);
        return "user/home"; 
    }
    
    @ExceptionHandler(Exception.class)
public String handleError(Exception e, Model model) {
    model.addAttribute("errorMessage", e.getMessage());
    return "error"; // Trả về trang lỗi
}

@GetMapping("/api/users") // Đường dẫn API

@ResponseBody // Đảm bảo trả về JSON
    public List<User> getAllUsers() {
        return userService.getAllUsers(); 
}

}
