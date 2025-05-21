-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2025 at 05:59 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mbatelier`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `cleanup_expired_otps` ()   BEGIN
    DELETE FROM forget_pass 
    WHERE expires_at < NOW() 
    OR (is_used = 1 AND created_at < DATE_SUB(NOW(), INTERVAL 1 DAY));
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `clothes`
--
-- Creation: May 19, 2025 at 01:01 PM
-- Last update: May 21, 2025 at 03:42 PM
--

CREATE TABLE `clothes` (
  `clothesid` int(11) NOT NULL,
  `clothname` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `sizes` enum('Small','Medium','Large') DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `category` varchar(50) DEFAULT NULL,
  `photo_path` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `availability` enum('Available','Unavailable') NOT NULL,
  `color` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `clothes`:
--

--
-- Dumping data for table `clothes`
--

INSERT INTO `clothes` (`clothesid`, `clothname`, `description`, `sizes`, `price`, `category`, `photo_path`, `created_at`, `availability`, `color`) VALUES
(1, 'Glittery Gown', 'glitter gown, detachable off shoulder strap and corset bodice', 'Small', 1200.00, 'Gown', 'src/images/clothes/clothes_1747660902472.png', '2025-05-19 13:23:12', 'Available', 'Pink'),
(52, 'Suit', 'White suit, usually worn by groom in a wedding', 'Small', 1000.00, 'Male Suit', 'src/images/clothes/clothes_1747703326495.png', '2025-05-20 01:09:38', 'Available', 'White'),
(53, 'Wedding Dress', 'intricate lace patterns, often incorporating delicate floral or vine designs, and are embellished with sparkling stones like crystals or pearls for added shimmer', 'Medium', 2000.00, 'Wedding Gown', 'src/images/clothes/clothes_1747703629582.png', '2025-05-20 01:15:26', 'Unavailable', 'White'),
(54, 'Batman Costume', 'a dark gray bodysuit with a black bat emblem, includes accessories like a black or blue cape, cowl, gloves, and boots, all serving various purposes such as protection, stealth, and intimidation.', 'Small', 900.00, 'Kids Custome', 'src/images/clothes/clothes_1747704213748.png', '2025-05-20 01:25:17', 'Available', 'Black'),
(59, 'Barong', 'a formal shirt that is a vibrant and unique choice for celebrating Filipino culture with style. It combines traditional Filipino craftsmanship with modern elegance, making it suitable for formal occasions, weddings, and cultural events.', 'Small', 600.00, 'Barong', 'src/images/clothes/clothes_1747795186404.jpg', '2025-05-21 02:40:25', 'Available', 'NavyBlue');

-- --------------------------------------------------------

--
-- Table structure for table `forget_pass`
--
-- Creation: May 19, 2025 at 03:19 PM
-- Last update: May 21, 2025 at 02:40 PM
--

CREATE TABLE `forget_pass` (
  `id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `otp` varchar(6) NOT NULL,
  `expires_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `is_used` tinyint(1) DEFAULT 0,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `forget_pass`:
--   `u_id`
--       `user` -> `u_id`
--

--
-- Dumping data for table `forget_pass`
--

INSERT INTO `forget_pass` (`id`, `u_id`, `email`, `otp`, `expires_at`, `is_used`, `created_at`) VALUES
(1, 1, 'myca.lariosa12@gmail.com', '487682', '2025-05-19 15:33:48', 0, '2025-05-19 15:28:48'),
(2, 1, 'myca.lariosa12@gmail.com', '246073', '2025-05-19 15:33:08', 1, '2025-05-19 15:32:47'),
(3, 1, 'myca.lariosa12@gmail.com', '950001', '2025-05-19 15:58:16', 1, '2025-05-19 15:57:47'),
(4, 1, 'myca.lariosa12@gmail.com', '229599', '2025-05-19 16:02:00', 1, '2025-05-19 16:01:39'),
(5, 1, 'myca.lariosa12@gmail.com', '628949', '2025-05-19 16:04:49', 1, '2025-05-19 16:04:14'),
(6, 1, 'Myca.lariosa12@gmail.com', '110458', '2025-05-19 16:07:30', 1, '2025-05-19 16:06:46'),
(7, 1, 'myca.lariosa12@gmail.com', '275952', '2025-05-19 16:13:35', 0, '2025-05-19 16:08:35'),
(8, 1, 'myca.lariosa12@gmail.com', '132332', '2025-05-19 16:09:08', 1, '2025-05-19 16:08:54'),
(9, 1, 'myca.lariosa12@gmail.com', '600189', '2025-05-19 16:11:33', 1, '2025-05-19 16:11:20'),
(10, 1, 'myca.lariosa12@gmail.com', '282593', '2025-05-19 16:31:02', 0, '2025-05-19 16:26:02'),
(11, 1, 'myca.lariosa12@gmail.com', '702753', '2025-05-19 16:32:40', 0, '2025-05-19 16:27:40'),
(12, 1, 'myca.lariosa12@gmail.com', '391948', '2025-05-19 16:39:19', 0, '2025-05-19 16:34:19'),
(13, 1, 'myca.lariosa12@gmail.com', '514530', '2025-05-19 16:41:08', 0, '2025-05-19 16:36:08'),
(14, 1, 'myca.lariosa12@gmail.com', '940782', '2025-05-19 16:44:44', 0, '2025-05-19 16:39:44'),
(15, 1, 'myca.lariosa12@gmail.com', '895873', '2025-05-19 16:45:53', 0, '2025-05-19 16:40:53'),
(16, 1, 'Myca.lariosa12@gmail.com', '951914', '2025-05-19 16:53:35', 0, '2025-05-19 16:48:35'),
(17, 1, 'myca.lariosa12@gmail.com', '843637', '2025-05-19 16:58:51', 0, '2025-05-19 16:53:51'),
(18, 1, 'Myca.lariosa12@gmail.com', '246123', '2025-05-19 16:56:12', 1, '2025-05-19 16:55:51'),
(19, 1, 'Myca.lariosa12@gmail.com', '321071', '2025-05-19 16:59:51', 1, '2025-05-19 16:59:38'),
(20, 1, 'myca.lariosa12@gmail.com', '887967', '2025-05-19 17:05:16', 1, '2025-05-19 17:05:04'),
(21, 1, 'myca.lariosa12@gmail.com', '913970', '2025-05-19 17:06:39', 1, '2025-05-19 17:06:25'),
(22, 1, 'Myca.lariosa12@gmail.com', '317253', '2025-05-19 23:20:43', 0, '2025-05-19 23:15:43'),
(23, 1, 'Myca.lariosa12@gmail.com', '785457', '2025-05-19 23:16:30', 1, '2025-05-19 23:16:14'),
(24, 1, 'myca.lariosa12@gmail.com', '379334', '2025-05-19 23:18:28', 1, '2025-05-19 23:18:12'),
(25, 1, 'Myca.lariosa12@gmail.com', '289927', '2025-05-19 23:19:59', 1, '2025-05-19 23:19:43'),
(26, 1, 'myca.lariosa12@gmail.com', '705527', '2025-05-19 23:21:58', 1, '2025-05-19 23:21:45'),
(27, 1, 'myca.lariosa12@gmail.com', '979891', '2025-05-19 23:24:46', 1, '2025-05-19 23:24:29'),
(28, 2, 'Bushsellote15@gmail.com', '793586', '2025-05-20 10:21:15', 1, '2025-05-20 10:20:09'),
(29, 9, 'albertolarrobis05@gmail.com', '474741', '2025-05-20 12:26:11', 0, '2025-05-20 12:21:11'),
(30, 1, 'Myca.lariosa12@gmail.com', '237065', '2025-05-21 12:13:50', 0, '2025-05-21 12:08:50'),
(31, 1, 'Myca.lariosa12@gmail.com', '796826', '2025-05-21 12:16:11', 0, '2025-05-21 12:11:11'),
(32, 1, 'myca.lariosa12@gmail.com', '580397', '2025-05-21 14:23:13', 1, '2025-05-21 14:22:24'),
(33, 1, 'myca.lariosa12@gmail.com', '151475', '2025-05-21 14:44:38', 0, '2025-05-21 14:39:38'),
(34, 1, 'myca.lariosa12@gmail.com', '357905', '2025-05-21 14:40:40', 1, '2025-05-21 14:40:24');

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--
-- Creation: Apr 20, 2025 at 03:19 PM
-- Last update: May 21, 2025 at 03:52 PM
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `log_event` varchar(500) NOT NULL,
  `log_description` varchar(500) NOT NULL,
  `log_timestamp` datetime NOT NULL,
  `u_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `logs`:
--   `u_id`
--       `user` -> `u_id`
--

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `log_event`, `log_description`, `log_timestamp`, `u_id`) VALUES
(1, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-04-25 13:10:12', 1),
(2, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-04-25 13:10:18', 1),
(3, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-04-25 13:20:18', 1),
(4, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-04-25 14:51:29', 1),
(5, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-04-25 14:51:35', 1),
(6, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-04-25 19:45:11', 1),
(7, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-04-25 19:56:55', 1),
(8, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-04-25 20:06:09', 1),
(9, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-04-25 20:49:29', 1),
(10, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-04-25 20:49:35', 1),
(11, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-04-26 18:57:02', 1),
(12, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-04-26 18:57:08', 1),
(13, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-04-26 18:57:29', 1),
(14, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-04-26 18:57:35', 1),
(15, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-04-26 19:10:38', 1),
(16, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-04-26 19:10:46', 1),
(17, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 13:14:51', 1),
(18, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 13:22:45', 1),
(19, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 13:24:08', 1),
(20, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 13:25:07', 1),
(21, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 13:31:31', 1),
(22, 'Failed Login', 'Login attempt with pending account: Art', '2025-05-04 13:35:34', 7),
(23, 'Successful Login', 'User Lanny logged in successfully as User', '2025-05-04 13:35:52', 6),
(24, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 13:36:20', 1),
(25, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 14:13:50', 1),
(26, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 14:16:16', 1),
(27, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 14:16:48', 1),
(28, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-05-04 14:33:10', 1),
(29, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 14:33:17', 1),
(30, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 14:36:04', 1),
(31, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 14:36:45', 1),
(32, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-05-04 14:59:49', 1),
(33, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 14:59:57', 1),
(34, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 15:48:00', 1),
(35, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 15:51:04', 1),
(36, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-05-04 16:18:09', 1),
(37, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 16:18:20', 1),
(38, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 17:21:08', 1),
(39, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 17:24:07', 1),
(40, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 17:29:53', 1),
(41, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 17:35:52', 1),
(42, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 17:38:02', 1),
(43, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 17:39:00', 1),
(44, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 17:39:53', 1),
(45, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-05-04 18:04:22', 1),
(46, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 18:04:30', 1),
(47, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 18:23:37', 1),
(48, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 18:25:20', 1),
(49, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 21:21:16', 1),
(50, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-04 22:28:45', 1),
(51, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-09 11:19:00', 1),
(52, 'Successful Login', 'User Bush logged in successfully as Admin', '2025-05-09 11:20:42', 8),
(53, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-09 11:21:06', 1),
(54, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-09 11:33:23', 1),
(55, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-09 11:38:06', 1),
(56, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-09 13:34:18', 1),
(57, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-09 13:49:21', 1),
(58, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-09 13:53:18', 1),
(59, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-09 13:56:37', 1),
(60, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-09 14:01:40', 1),
(61, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-09 14:07:33', 1),
(62, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-19 20:49:56', 1),
(63, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-19 21:11:56', 1),
(64, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-19 21:12:23', 1),
(65, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-19 21:21:26', 1),
(66, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-19 21:36:33', 1),
(67, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-19 22:23:40', 1),
(68, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-19 23:39:52', 1),
(69, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-19 23:42:28', 1),
(70, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-19 23:43:44', 1),
(71, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-19 23:46:32', 1),
(72, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 07:25:12', 1),
(73, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 07:31:17', 1),
(74, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 07:33:30', 1),
(75, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 07:36:24', 1),
(76, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-05-20 07:36:52', 1),
(77, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 07:36:57', 1),
(78, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 08:02:51', 1),
(79, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 08:03:55', 1),
(80, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 09:05:32', 1),
(81, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 09:12:45', 1),
(82, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 09:20:00', 1),
(83, 'Successful Login', 'User Bushyy logged in successfully as User', '2025-05-20 18:22:05', 2),
(84, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 18:40:49', 1),
(85, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 18:46:04', 1),
(86, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 18:58:30', 1),
(87, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 19:13:14', 1),
(88, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 19:19:04', 1),
(89, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 20:19:26', 1),
(90, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-20 20:22:26', 1),
(91, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 10:07:17', 1),
(92, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 10:12:30', 1),
(93, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 10:19:33', 1),
(94, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 10:28:02', 1),
(95, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 10:39:14', 1),
(96, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 10:45:20', 1),
(97, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-05-21 10:46:56', 1),
(98, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 10:47:00', 1),
(99, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 10:52:48', 1),
(100, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 10:54:46', 1),
(101, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-05-21 12:29:28', 1),
(102, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 12:29:35', 1),
(103, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-05-21 12:30:43', 1),
(104, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 12:30:48', 1),
(105, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 13:39:22', 1),
(106, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-05-21 13:45:55', 1),
(107, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 13:46:00', 1),
(108, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 13:48:04', 1),
(109, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 13:53:32', 1),
(110, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-05-21 20:12:29', 1),
(111, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 20:12:34', 1),
(112, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 20:16:18', 1),
(113, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 20:17:15', 1),
(114, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 20:31:34', 1),
(115, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-05-21 21:00:42', 1),
(116, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 21:00:47', 1),
(117, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-05-21 21:03:08', 1),
(118, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 21:03:15', 1),
(119, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 21:10:35', 1),
(120, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 21:12:48', 1),
(121, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 21:14:11', 1),
(122, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 21:17:43', 1),
(123, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 21:39:54', 1),
(124, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 21:42:47', 1),
(125, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 22:23:52', 1),
(126, 'Failed Login', 'Invalid password attempt for user: Admin', '2025-05-21 22:28:10', 1),
(127, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 22:28:15', 1),
(128, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 22:41:15', 1),
(129, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 23:08:37', 1),
(130, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 23:10:11', 1),
(131, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 23:12:50', 1),
(132, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 23:22:21', 1),
(133, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 23:27:05', 1),
(134, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 23:31:28', 1),
(135, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 23:36:17', 1),
(136, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 23:44:46', 1),
(137, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 23:48:01', 1),
(138, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 23:50:39', 1),
(139, 'Successful Login', 'User Admin logged in successfully as Admin', '2025-05-21 23:52:19', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rentals`
--
-- Creation: May 21, 2025 at 12:53 PM
-- Last update: May 21, 2025 at 03:33 PM
--

CREATE TABLE `rentals` (
  `rental_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `customer_name` varchar(100) NOT NULL,
  `customer_phone` varchar(20) NOT NULL,
  `clothesid` int(11) NOT NULL,
  `rental_date` date NOT NULL,
  `return_date` date NOT NULL,
  `total_amount` decimal(10,2) NOT NULL,
  `status` enum('active','returned') DEFAULT 'active'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `rentals`:
--   `user_id`
--       `user` -> `u_id`
--   `clothesid`
--       `clothes` -> `clothesid`
--

--
-- Dumping data for table `rentals`
--

INSERT INTO `rentals` (`rental_id`, `user_id`, `customer_name`, `customer_phone`, `clothesid`, `rental_date`, `return_date`, `total_amount`, `status`) VALUES
(3, 3, 'Mica Larrobis', '09678654567', 53, '2025-05-24', '2025-05-25', 2000.00, 'active');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--
-- Creation: Mar 30, 2025 at 09:55 AM
-- Last update: May 21, 2025 at 02:41 PM
--

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` enum('Pending','Active') NOT NULL,
  `role` enum('Admin','User') NOT NULL,
  `profile_image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `user`:
--

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`u_id`, `fname`, `lname`, `email`, `contact`, `username`, `password`, `status`, `role`, `profile_image`) VALUES
(1, 'Mica', 'Lariosa', 'myca.lariosa12@gmail.com', '09999221439', 'Admin', 'f1e96f1b320b3b8c120243fb511c5ba4e81cf319f079633f827188b5ae68a6ce', 'Active', 'Admin', 'src\\images\\prof\\ppp.png'),
(2, 'Bush', 'Sellote', 'Bushsellote15@gmail.com', '09912086690', 'Bushyy', '7c9aa883641b1ef4b76f8b141bd1d0308bc83eeebe38a60f70fdcff0aec5b90c', 'Active', 'User', 'src\\images\\prof\\back.png'),
(3, 'Mica', 'Larrobis', 'lariosa.myca21@gmail.com', '09999332321', 'Mica', '3cff66f2b2e4503a93de76e337dd84b7db16ed2dae7657dcfeb1ac50644505c7', 'Active', 'User', NULL),
(4, 'Glenda', 'Lariosa', 'Glenda@gmail.com', '09992221234', 'Glenda', '1b73621b32887f122108b2496300a9dbef772e1324909f1cc7e8d4e73fc5614c', 'Active', 'User', NULL),
(5, 'Albert', 'Larrobis', 'Albert@gmail.com', '09999332327', 'Alber', 'ca05f32c646245b942371d35bb84fb73d6beece32988ea56d38b65577920a145', 'Active', 'User', 'src/images/prof/default.png'),
(6, 'lanie', 'lariosa', 'lanny@gmail.com', '09875483543', 'Lanny', '761499fdac5515a884213a36781306fcc7253dbfa8808514a5fa14b69720b15c', 'Active', 'User', 'src/images/prof/default.png'),
(7, 'arts', 'lariosa', 'art@gmail.com', '09674857643', 'Art', '78c158ab5ab10bb92ef762672c660eb832f0b199c3911419b139784af90eb83c', 'Active', 'User', 'src/images/prof/default.png'),
(8, 'Bush', 'Sellote', 'Bushidoo@gmail.com', '09999221232', 'Bush', '7c9aa883641b1ef4b76f8b141bd1d0308bc83eeebe38a60f70fdcff0aec5b90c', 'Active', 'Admin', 'src/images/prof/1746760827231_profile_2655785629195771464.jpg'),
(9, 'Albert', 'Larrobis', 'Albertolarrobis05@gmail.com', '09234345324', 'Albert', 'b9a1302ce79a47a645bf4ba8fae23ae149360dee9d7381ae6c8f3cf2ac88025a', 'Active', 'User', 'src/images/prof/default.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clothes`
--
ALTER TABLE `clothes`
  ADD PRIMARY KEY (`clothesid`);

--
-- Indexes for table `forget_pass`
--
ALTER TABLE `forget_pass`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idx_forget_pass_user_otp` (`u_id`,`otp`),
  ADD KEY `idx_forget_pass_expires` (`expires_at`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `rentals`
--
ALTER TABLE `rentals`
  ADD PRIMARY KEY (`rental_id`),
  ADD KEY `clothes_id` (`clothesid`),
  ADD KEY `fk_user_rental` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clothes`
--
ALTER TABLE `clothes`
  MODIFY `clothesid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `forget_pass`
--
ALTER TABLE `forget_pass`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=140;

--
-- AUTO_INCREMENT for table `rentals`
--
ALTER TABLE `rentals`
  MODIFY `rental_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `forget_pass`
--
ALTER TABLE `forget_pass`
  ADD CONSTRAINT `forget_pass_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE;

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `u_id` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`);

--
-- Constraints for table `rentals`
--
ALTER TABLE `rentals`
  ADD CONSTRAINT `fk_user_rental` FOREIGN KEY (`user_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rentals_ibfk_1` FOREIGN KEY (`clothesid`) REFERENCES `clothes` (`clothesid`);


--
-- Metadata
--
USE `phpmyadmin`;

--
-- Metadata for table clothes
--

--
-- Metadata for table forget_pass
--

--
-- Metadata for table logs
--

--
-- Metadata for table rentals
--

--
-- Metadata for table user
--

--
-- Dumping data for table `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'mbatelier', 'user', '{\"CREATE_TIME\":\"2025-03-23 01:08:47\",\"sorted_col\":\"`status` ASC\"}', '2025-05-20 10:25:47');

--
-- Metadata for database mbatelier
--

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`root`@`localhost` EVENT `cleanup_otps_event` ON SCHEDULE EVERY 1 DAY STARTS '2025-05-20 00:50:23' ON COMPLETION NOT PRESERVE ENABLE DO CALL cleanup_expired_otps()$$

DELIMITER ;
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
