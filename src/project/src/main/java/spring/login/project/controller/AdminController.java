package spring.login.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import spring.login.project.model.User;
import spring.login.project.service.AdminService;
@Controller
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    // Hiển thị thông tin người dùng
    @GetMapping("/user/view/{id}")
    public String viewUser(@PathVariable Long id, Model model) {
        User user = adminService.findUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("user", user);
        return "userView"; // Trả về tên file HTML (userView.html) trong thư mục templates
    }

    // Hiển thị trang tạo người dùng
    @GetMapping("/user/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "userCreate"; // Trả về tên file HTML (userCreate.html) trong thư mục templates
    }

    // Phương thức hiện tại
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return adminService.findUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        adminService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
