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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.swagger.v3.oas.annotations.Operation;
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
public String registerUser(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
    // Đăng ký người dùng
    userService.registerUser(username, password);
    
    // Sau khi đăng ký thành công, chuyển hướng về trang đăng nhập và thêm tham số `registered=true`
    redirectAttributes.addAttribute("registered", true);
    return "redirect:/login";  // Chuyển hướng đến trang đăng nhập
}


    @GetMapping("/login")
    public String showLoginForm() {
        return "user/login"; // Trả về trang đăng nhập
    }

   @GetMapping("/home")
public String home(@RequestParam(value = "loginSuccess", required = false) String loginSuccess,
                   Model model) {
    // Lấy tên người dùng từ SecurityContextHolder
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    
    model.addAttribute("username", username);

    // Nếu có tham số loginSuccess, truyền thông báo sang view
    if (loginSuccess != null) {
        model.addAttribute("loginSuccess", true);
    }

    return "user/home";
}

    
    @ExceptionHandler(Exception.class)
public String handleError(Exception e, Model model) {
    model.addAttribute("errorMessage", e.getMessage());
    return "error"; // Trả về trang lỗi
}
@Operation(summary="Hiển thị API của user")
@GetMapping("/api/users") // Đường dẫn API

@ResponseBody // Đảm bảo trả về JSON
    public List<User> getAllUsers() {
        return userService.getAllUsers(); 
}

}
