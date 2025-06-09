-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 30, 2025 lúc 11:48 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quan_ly_chi_tieu_ca_nhan`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `expenses`
--

CREATE TABLE `expenses` (
  `id` bigint(20) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `expenses`
--

INSERT INTO `expenses` (`id`, `amount`, `date`, `name`, `user_id`) VALUES
(48, 250000, '2025-05-15', 'tiền wifi', NULL),
(49, 400000, '2025-05-18', 'tiền xăng', NULL),
(50, 3000000, '2025-05-28', 'tiền trọ ', NULL),
(51, 10850000, '2025-05-30', 'tiền học phí ', NULL),
(52, 500000, '2025-05-31', 'tiền điện ', NULL),
(53, 350000, '2025-06-01', 'tiền nước ', NULL),
(54, 850000, '2025-06-03', 'tiền bảo hiểm y tế', NULL),
(55, 450000, '2025-07-12', 'tiền thuê hosting', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `incomes`
--

CREATE TABLE `incomes` (
  `id` bigint(20) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `incomes`
--

INSERT INTO `incomes` (`id`, `amount`, `date`, `source`, `user_id`) VALUES
(31, 8000000, '2025-05-03', 'tiền lương', NULL),
(32, 2000000, '2025-05-06', 'tiền tăng ca', NULL),
(33, 10000000, '2025-05-31', 'tiền Freelance', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`user_id`, `password`, `username`) VALUES
(1, '$2a$10$XhXD1VI51l4ZVclN29p2secbtlWqRVfW8RMkwTmJjEsRVrAkg7tpS', 'khang'),
(2, '$2a$10$aeqkKUSWJyoAdXeFiZI27u2KO.cHqxqVGlFsxynPY/ZXKqUYBBSye', 'minh thu'),
(7, '$2a$10$gGruA4uXcSrIDyMYyH6Owu6Zq7C.47kYb6q3u6kTChDna5mdpXVi2', 'vương lâm'),
(8, '$2a$10$2jUclbQkzAynnnDhxz5ht.bPuDTt6KrNMWuujARgTO1LGQjLhapiK', 'lý mộ uyển '),
(9, '$2a$10$5UUIpo2N1oQ6qXdPm9G4K.bxJXP/MyIO/Tp2bBcjvmJSMkvO6z8ru', 'Bình An'),
(10, '$2a$10$CPjEe3Sg8.Nk0cvpabJHcOvEVOzz0NtuZw0oXTCGdLOSct6BB2ZU2', 'kietVN'),
(12, '$2a$10$OsMwprsjKMk4UIt1QhMQvuVtGvJ8lWP3WLYvA/JDEiGjZKFMhIjGS', 'bùi minh thơ'),
(13, '$2a$10$QtbQCf0pE5RGWWX.QFur1eXaQqsggQh7VuGNUC3dyJT1Yj3McZwMS', 'Mạnh xuyên'),
(15, '$2a$10$M1FchiKOVgI751wLLakuceZ.oYl7rRhfgcBGWT6t9oIIQTpQUzMzy', 'vương nhất bác'),
(16, '$2a$10$W2kRUdgYFFx13FF4y0iy1.B8WUg2kMr3T6900iqtqZp1ZsOXq2xD6', 'yang yang');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `expenses`
--
ALTER TABLE `expenses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2qife4sxyeoi1kwgvg769ks8y` (`user_id`);

--
-- Chỉ mục cho bảng `incomes`
--
ALTER TABLE `incomes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5ec9r8fa3a60qlye00uq03qbs` (`user_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `expenses`
--
ALTER TABLE `expenses`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT cho bảng `incomes`
--
ALTER TABLE `incomes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `expenses`
--
ALTER TABLE `expenses`
  ADD CONSTRAINT `FK2qife4sxyeoi1kwgvg769ks8y` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Các ràng buộc cho bảng `incomes`
--
ALTER TABLE `incomes`
  ADD CONSTRAINT `FK5ec9r8fa3a60qlye00uq03qbs` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
