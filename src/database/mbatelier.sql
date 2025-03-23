-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 23, 2025 at 12:59 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

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

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`u_id`, `fname`, `lname`, `email`, `contact`, `username`, `password`, `status`, `role`) VALUES
(2, 'Mica', 'Mica', 'Mica@gmail.com', '09992332323', 'Mica', 'Bushsellote', 'Pending', 'User'),
(3, 'Bush', 'Sellote', 'Bushyy@gmail.com', '09999883423', 'Bushyy', '3cff66f2b2e4503a93de76e337dd84b7db16ed2dae7657dcfeb1ac50644505c7', 'Pending', 'User'),
(4, 'Admin', 'Admin', 'Admin@gmail.com', '0999923323', 'Admin', 'f1e96f1b320b3b8c120243fb511c5ba4e81cf319f079633f827188b5ae68a6ce', 'Active', 'Admin'),
(5, 'dasadadad', 'dasdas', 'dsada@gmail.com', '09098975468', 'Bush', '3cff66f2b2e4503a93de76e337dd84b7db16ed2dae7657dcfeb1ac50644505c7', 'Pending', 'User'),
(6, 'Mica', 'Larrobis', 'Micame@gmail.com', '0923231314', 'Micamica', '3cff66f2b2e4503a93de76e337dd84b7db16ed2dae7657dcfeb1ac50644505c7', 'Pending', 'User');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
