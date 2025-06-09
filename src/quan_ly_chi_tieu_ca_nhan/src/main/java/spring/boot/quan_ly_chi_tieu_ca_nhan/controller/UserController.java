package spring.boot.quan_ly_chi_tieu_ca_nhan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.boot.quan_ly_chi_tieu_ca_nhan.model.User;
import spring.boot.quan_ly_chi_tieu_ca_nhan.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Hiển thị form đăng ký
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    // Xử lý đăng ký user từ form
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
        try {
            userService.registerUser(username, password);
            redirectAttributes.addAttribute("registered", true);
            return "redirect:/login";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Tên người dùng đã tồn tại!");
            return "redirect:/register";
        }
    }

    // Hiển thị form đăng nhập
    @GetMapping("/login")
    public String showLoginForm(@RequestParam(value = "error", required = false) String error,
                                 @RequestParam(value = "logout", required = false) String logout,
                                 @RequestParam(value = "registered", required = false) String registered,
                                 Model model) {

        if (error != null) {
            model.addAttribute("errorMessage", "Sai tên đăng nhập hoặc mật khẩu.");
        }
        if (logout != null) {
            model.addAttribute("message", "Bạn đã đăng xuất thành công.");
        }
        if (registered != null) {
            model.addAttribute("message", "Đăng ký thành công! Mời đăng nhập.");
        }
        return "user/login";
    }

    // Trang sau khi đăng nhập thành công
    @GetMapping("/home")
    public String home(@RequestParam(value = "loginSuccess", required = false) String loginSuccess, Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);

        if (loginSuccess != null) {
            model.addAttribute("loginSuccess", true);
        }

        return "user/home";
    }

    // Xử lý lỗi toàn cục 
    @ExceptionHandler(Exception.class)
    public String handleError(Exception e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
}
