# Sử dụng image JDK 21 từ eclipse-temurin
FROM eclipse-temurin:21-jdk-alpine

# Tạo thư mục trong container
WORKDIR /app

# Copy file .jar từ thư mục target vào container
COPY target/quan_ly_chi_tieu_ca_nhan-0.0.1-SNAPSHOT.jar app.jar

# Expose cổng 8082
EXPOSE 8082

# Lệnh để chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]