package spring.boot.quan_ly_chi_tieu_ca_nhan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Ứng dụng Quản lý chi tiêu cá nhân")
                        .description("API cho hệ thống quản lý chi tiêu cá nhân bằng Spring Boot")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Tên bạn")
                                .email("email@example.com")
                                .url("https://github.com/your-github"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                );
    }
}
