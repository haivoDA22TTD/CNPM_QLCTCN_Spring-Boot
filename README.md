# Thông tin dự án
| Sinh viên thực hiện    | MSSV     | Lớp       | 
|------------------------|----------|-----------|
| Võ Chí Hải             |110122068 | DA22TTD   | 
| Nguyễn Đỗ Thành Lộc    |110122105 | DA22TTD   |   
| Hoàng Tuấn Kiệt        |110122099 | DA22TTD   |

**Giáo viên hướng dẫn:** TS. Nguyễn Bảo Ân

# Hệ Thống Quản Lý Chi Tiêu Cá Nhân

Một ứng dụng Spring Boot toàn diện giúp quản lý thu nhập, chi tiêu, danh mục và người dùng. Hệ thống hỗ trợ người dùng theo dõi và kiểm soát hoạt động tài chính cá nhân một cách hiệu quả.
## 🚀 Tính Năng

- Đăng ký tài khoản người dùng
- Đăng nhập 
- Mã hóa mật khẩu an toàn bằng BCrypt
- Thêm, xoá, xem các khoản **thu nhập**
- Thêm, xoá, xem các khoản **chi tiêu**
- Cảnh báo khi **chi tiêu vượt quá mức thu nhập**
- Thống kê mức chi tiêu theo **từng tháng**

## 🛠 Công Nghệ Sử Dụng (Tech Stack)

- **Ngôn ngữ:** Java 21  
- **Framework:** Spring Boot 3.4.4  
- **ORM:** Spring Data JPA
- **Spring Security** để bảo vệ các API và quản lý xác thực người dùng  
- **Cơ sở dữ liệu:** MySQL  
- **Công cụ build:** Maven  
- **Kiểu API:** RESTful APIs  
- **Tài liệu API:** Swagger UI (tự động sinh tài liệu API)
- **kiểm thử API:** Postman
- **Đóng gói ứng dụng:** Docker
- **CI/CD**: GitHub Actions
- **Quản lý dự án**: Jira
- **Thiết kế UI/UX**: Figma

## 📄 Tài Liệu API

### Giới thiệu

Dự án này là một ứng dụng RESTful API được xây dựng bằng Spring Boot.  
Tài liệu API được tự động sinh ra bằng **Swagger UI**, sử dụng thư viện **Springdoc OpenAPI**.

Bạn có thể truy cập giao diện Swagger để kiểm thử và xem chi tiết các endpoint của hệ thống.

## 💻 Yêu Cầu Hệ Thống

Để chạy được ứng dụng này, bạn cần cài đặt trước các công cụ sau:

| Thành phần | Phiên bản yêu cầu            |
|------------|------------------------------|
| Java       | Phiên bản 17 trở lên         |
| Maven      | Phiên bản 3.x trở lên         |
| IDE        | IntelliJ IDEA / Eclipse / VS Code |

## 📁 Cấu trúc Dự Án

Dưới đây là cấu trúc thư mục của dự án `quan_ly_chi_tieu_ca_nhan`, được tổ chức rõ ràng theo các lớp chức năng:

```plaintext
quan_ly_chi_tieu_ca_nhan/
├── .gitattributes
├── .gitignore
...
├── .mvn/                            # Cấu hình Maven Wrapper
│   └── wrapper/
│       └── maven-wrapper.properties
├── .vscode/                         # Cấu hình cho VS Code
│   └── launch.json
├── mvnw                             # Maven wrapper cho Unix
├── mvnw.cmd                         # Maven wrapper cho Windows
├── pom.xml                          # File khai báo dự án Maven
├── src/
│   └── main/
│       ├── java/
│       │   └── spring/boot/quan_ly_chi_tieu_ca_nhan/
│       │       ├── QuanLyChiTieuCaNhanApplication.java   # Điểm khởi chạy chính
│       │       ├── config/                               # Cấu hình hệ thống
│       │       │   ├── SecurityConfig.java               # Cấu hình bảo mật Spring Security
│       │       │   ├── SwaggerConfig.java                # Cấu hình tài liệu API bằng Swagger
│       │       │   ├── UserDetailsImpl.java              # Cấu hình chi tiết người dùng
│       │       │   └── WebConfig.java                    # Cấu hình chung cho Web
│       │       ├── controller/                           # Các controller xử lý yêu cầu
│       │       │   ├── ExpenseController.java            # Controller quản lý chi tiêu
│       │       │   ├── IncomeController.java             # Controller quản lý thu nhập
│       │       │   ├── UserController.java               # Controller quản lý người dùng
│       │       │   └── api/                              # Các API controller
│       │       │       ├── ExpenseApiController.java
│       │       │       ├── IncomeApiController.java
│       │       │       └── UserApiController.java
│       │       ├── model/                                # Các lớp entity (dữ liệu)
│       │       │   ├── Expense.java
│       │       │   ├── Income.java
│       │       │   └── User.java
│       │       ├── repository/                           # Lớp truy cập dữ liệu (DAO)
│       │       │   ├── ExpenseRepository.java
│       │       │   ├── IncomeRepository.java
│       │       │   └── UserRepository.java
│       │       └── service/                              # Lớp xử lý nghiệp vụ
│       │           ├── ExpenseService.java
│       │           ├── IncomeService.java
│       │           ├── UserDetailsServiceImpl.java
│       │           └── UserService.java
│       └── resources/
│           ├── application.properties                    # File cấu hình Spring Boot
│           └── templates/
│               ├── manage/                               # Giao diện quản lý chi tiêu/thu nhập
│               │   ├── expense.html
│               │   ├── income.html
│               │   └── show.html
│               └── user/                                 # Giao diện đăng nhập, đăng ký
│                   ├── home.html
│                   ├── login.html
│                   └── register.html


## 🧬 Clone Ứng Dụng & Truy Cập

### 📥 Bước 1: Clone dự án từ GitHub

```bash
git clone https://github.com/haivoDA22TTD/CNPM_QLCTCN_Spring-Boot
cd CNPM_QLCTCN_Spring-Boot
```
##  Cài Đặt Thư Viện Phụ Thuộc

Chạy lệnh sau để cài đặt toàn bộ các thư viện cần thiết của dự án:

```bash
mvn clean install
```
## Khởi Động Ứng Dụng

Sử dụng Maven để chạy ứng dụng Spring Boot:

```bash
mvn spring-boot:run
```
##  Ứng dụng sẽ chạy tại địa chỉ:
  http://localhost:8082
##  Sử Dụng API

Bạn có thể sử dụng **Swagger UI** để xem và kiểm thử các API trực tiếp trên trình duyệt.

🔗 Truy cập tại địa chỉ:
  http://localhost:8082/swagger-ui/index.html
  
## 📊 Mã Trạng Thái HTTP (Status Codes)

| Mã trạng thái | Ý nghĩa                     |
|---------------|-----------------------------|
| 200           | Thành công (Success)        |
| 201           | Tạo mới thành công          |
| 204           | Không có nội dung trả về    |
| 400           | Yêu cầu không hợp lệ        |
| 401           | Chưa xác thực               |
| 404           | Không tìm thấy              |
| 500           | Lỗi máy chủ nội bộ          |

##  Định Dạng Phản Hồi (Response Formats)

-  **Phản hồi thành công:** `HTTP 200 OK` kèm dữ liệu hoặc body rỗng  
-  **Tạo mới / Cập nhật:** `HTTP 200 OK` hoặc `HTTP 201 Created`  
-  **Xoá dữ liệu:** `HTTP 200 OK` hoặc `HTTP 204 No Content`  
-  **Lỗi:** `HTTP 404 Not Found` hoặc `HTTP 500 Internal Server Error` kèm chi tiết lỗi
