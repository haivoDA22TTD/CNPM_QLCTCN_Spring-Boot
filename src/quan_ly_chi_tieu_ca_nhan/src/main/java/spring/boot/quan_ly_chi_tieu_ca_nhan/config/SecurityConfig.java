package spring.boot.quan_ly_chi_tieu_ca_nhan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import spring.boot.quan_ly_chi_tieu_ca_nhan.service.UserDetailsServiceImpl;
@EnableWebSecurity
@Configuration
public class SecurityConfig {
 @SuppressWarnings({ "removal" })
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/", "/register", "/login").permitAll() // Cho phép truy cập vào trang đăng ký và đăng nhập
            .anyRequest().authenticated() // Bảo vệ tất cả các yêu cầu khác
            .and()
            .formLogin()
                .loginPage("/login") // Đường dẫn trang đăng nhập
                .permitAll()
                .defaultSuccessUrl("/home?loginSuccess=true", true)
                .failureUrl("/login?error=true") // Đường dẫn nếu đăng nhập thất bại
                .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")  // URL chuyển hướng khi đăng xuất thành công
            .invalidateHttpSession(true)  // Hủy session
                .deleteCookies("JSESSIONID")  // Xóa cookie JSESSIONID
                .clearAuthentication(true)  // Xóa thông tin xác thực
                .permitAll(); // Cho phép tất cả người dùng thực hiện thoát

        return http.build();
    }

    @Bean
public AuthenticationManager authManager(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder authenticationManagerBuilder = 
        http.getSharedObject(AuthenticationManagerBuilder.class);
    authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    return authenticationManagerBuilder.build();
}

@Bean
public UserDetailsService userDetailsService() {
    return new UserDetailsServiceImpl(); // Trả về instance của UserDetailsServiceImpl
}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Sử dụng BCrypt để mã hóa mật khẩu
    }
    
}
