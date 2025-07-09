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
                        .title("Ứng dụng Web Quản lý chi tiêu cá nhân")
                        .description("API cho hệ thống quản lý chi tiêu cá nhân với Spring Boot.\n\n"
                                + "Thành viên nhóm thực hiện:\n"
                                + "- Võ Chí Hải\n"
                                + "- Hoàng Tuấn Kiệt\n"
                                + "- Nguyễn Đỗ Thành Lộc")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("CNPM_QLCTCN_Spring-Boot - Quản lý dự án")
                                .email("vochihai7@gmail.com")
                                .url("https://github.com/haivoDA22TTD/CNPM_QLCTCN_Spring-Boot"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                );
    }
}
