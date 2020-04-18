-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2020 at 09:53 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `healthcare`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `app_doc_id` int(11) NOT NULL,
  `app_patient_id` int(11) NOT NULL,
  `app_session_id` int(11) NOT NULL,
  `app_patient_name` varchar(20) NOT NULL,
  `app_hospital_name` varchar(15) NOT NULL,
  `app_book_date` varchar(20) NOT NULL,
  `app_patient_contact_no` int(10) NOT NULL,
  `app_price` double NOT NULL,
  `app_payment_status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`app_doc_id`, `app_patient_id`, `app_session_id`, `app_patient_name`, `app_hospital_name`, `app_book_date`, `app_patient_contact_no`, `app_price`, `app_payment_status`) VALUES
(1001, 2001, 3001, 'nimal a.b.c', 'kandy', '2020-04-09', 770741235, 5000, ''),
(1002, 2002, 3002, 'gihan a.m.g', 'malabe', '2020-04-07', 751852635, 6000, 'pay');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`app_patient_id`,`app_doc_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
