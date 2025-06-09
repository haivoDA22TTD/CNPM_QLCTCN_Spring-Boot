package spring.boot.quan_ly_chi_tieu_ca_nhan.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.Operation;
import spring.boot.quan_ly_chi_tieu_ca_nhan.model.User;
import spring.boot.quan_ly_chi_tieu_ca_nhan.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserApiController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Lấy tất cả user")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Lấy user theo username")
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy user"));
    }

   @PostMapping("/register")
public ResponseEntity<?> registerUser(@RequestBody User user) {
    
    userService.registerUser(user.getUsername(), user.getPassword());
    return ResponseEntity.ok("Đăng ký thành công");
}

}
