-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2020 at 12:17 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
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
-- Table structure for table `abc`
--

CREATE TABLE `abc` (
  `pk` int(10) NOT NULL,
  `id` varchar(10) DEFAULT NULL,
  `timestamp` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `app_id` int(5) NOT NULL,
  `app_doc_id` int(11) NOT NULL,
  `app_patient_id` int(11) NOT NULL,
  `app_session_id` int(11) NOT NULL,
  `app_patient_name` varchar(20) NOT NULL,
  `app_hospital_name` varchar(100) NOT NULL,
  `app_book_date` varchar(20) NOT NULL,
  `app_patient_contact_no` int(10) NOT NULL,
  `app_price` double NOT NULL,
  `app_payment_status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`app_id`, `app_doc_id`, `app_patient_id`, `app_session_id`, `app_patient_name`, `app_hospital_name`, `app_book_date`, `app_patient_contact_no`, `app_price`, `app_payment_status`) VALUES
(16, 10003, 252, 500028, 'nimal a.b.c', 'Kandy hospital,kandy', '2020-04-22', 770741235, 5000, 'Paid'),
(18, 10005, 252, 500030, 'nimal a.b.c', 'Colombo hospital,Colombo', '2020-04-22', 770741235, 5000, 'Paid'),
(19, 10003, 253, 500028, 'nimal a.b.c', 'Kandy hospital,kandy', '2020-04-22', 770741235, 5000, 'Paid'),
(20, 10003, 254, 500028, 'nimal a.b.c', 'Kandy hospital,kandy', '2020-04-22', 770741235, 5000, 'Paid'),
(21, 10000, 253, 500001, 'nimal a.b.c', 'Colombo hospital,Colombo', '2020-04-22', 770741235, 1500, 'Paid');

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `doc_id` int(5) NOT NULL,
  `doc_reg_no` varchar(5) NOT NULL,
  `doc_first_name` varchar(150) NOT NULL,
  `doc_last_name` varchar(150) NOT NULL,
  `doc_address_no` varchar(10) NOT NULL,
  `doc_address_lane1` varchar(100) NOT NULL,
  `doc_address_lane2` varchar(100) NOT NULL,
  `doc_address_lane3` varchar(100) DEFAULT NULL,
  `doc_city` varchar(80) DEFAULT NULL,
  `doc_tp1` varchar(15) NOT NULL,
  `doc_tp2` varchar(15) DEFAULT NULL,
  `doc_tp3` varchar(15) DEFAULT NULL,
  `doc_email` varchar(50) NOT NULL,
  `doc_status_id` int(5) NOT NULL,
  `doc_specification_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`doc_id`, `doc_reg_no`, `doc_first_name`, `doc_last_name`, `doc_address_no`, `doc_address_lane1`, `doc_address_lane2`, `doc_address_lane3`, `doc_city`, `doc_tp1`, `doc_tp2`, `doc_tp3`, `doc_email`, `doc_status_id`, `doc_specification_id`) VALUES
(10000, 'D1000', 'nimal', 'Kumara', '214/33', 'Kandy', 'Madapatha', 'Piliyanadala', 'Piliyanadala', '755784266', '112707676', NULL, 'google@gmail.com', 123, 1),
(10001, 'D2000', 'Akalanka', 'Nayanajith', '214/33', 'Manakndana', 'Madapatha', 'Piliyanadala', 'Piliyanadala', '755784266', '112707676', NULL, 'google@gmail.com', 123, 3),
(10002, 'D3000', 'Nipun', 'Akarshana', '214/33', 'Manakndana', 'Madapatha', 'Piliyanadala', 'Piliyanadala', '755784266', '112707676', NULL, 'google@gmail.com', 123, 4),
(10003, 'D4000', 'kamal', 'amal', '214/33', 'Manakndana', 'Madapatha', 'Piliyanadala', 'Piliyanadala', '755784266', '112707676', NULL, 'google@gmail.com', 123, 1),
(10004, 'D5000', 'Supun', 'dilshan', '214/33', 'Manakndana', 'Madapatha', 'Piliyanadala', 'Piliyanadala', '755784266', '112707676', NULL, 'google@gmail.com', 123, 1),
(10005, 'D6000', 'Supun', 'dilshan', '214/33', 'Manakndana', 'Madapatha', 'Piliyanadala', 'Piliyanadala', '755784266', '112707676', NULL, 'google@gmail.com', 123, 5),
(10007, 'D8000', 'Supun', 'dilshan', '214/33', 'Manakndana', 'Madapatha', 'Piliyanadala', 'Piliyanadala', '755784266', '112707676', NULL, 'google@gmail.com', 123, 5);

-- --------------------------------------------------------

--
-- Table structure for table `doc_hospital`
--

CREATE TABLE `doc_hospital` (
  `doc_id` int(8) NOT NULL,
  `hostpital_id` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doc_hospital`
--

INSERT INTO `doc_hospital` (`doc_id`, `hostpital_id`) VALUES
(10000, 100),
(10000, 101),
(10002, 100),
(10002, 101),
(10003, 100),
(10003, 101),
(10004, 100),
(10005, 100),
(10007, 100);

-- --------------------------------------------------------

--
-- Table structure for table `doc_session`
--

CREATE TABLE `doc_session` (
  `session_id` int(6) NOT NULL,
  `hostpital_id` int(5) NOT NULL,
  `doc_id` int(5) NOT NULL,
  `available_date` date NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `isEveryday` int(1) NOT NULL,
  `isActive` int(1) NOT NULL,
  `patient_limit` int(3) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doc_session`
--

INSERT INTO `doc_session` (`session_id`, `hostpital_id`, `doc_id`, `available_date`, `start_time`, `end_time`, `isEveryday`, `isActive`, `patient_limit`, `price`) VALUES
(500001, 100, 10000, '2020-04-24', '08:00:00', '10:00:00', 0, 1, 30, 1500),
(500003, 101, 10003, '2020-04-18', '08:30:00', '11:30:00', 0, 1, 30, 12500),
(500028, 101, 10003, '2020-04-15', '17:00:00', '21:00:00', 1, 1, 20, 5000),
(500029, 100, 10004, '2020-04-15', '17:00:00', '21:00:00', 1, 1, 20, 5000),
(500030, 100, 10005, '2020-04-15', '17:00:00', '21:00:00', 1, 1, 20, 5000),
(500031, 101, 10002, '2020-04-15', '17:00:00', '21:00:00', 1, 1, 20, 5000),
(500034, 101, 10003, '2020-04-15', '17:00:00', '21:00:00', 0, 1, 20, 5000);

-- --------------------------------------------------------

--
-- Table structure for table `doc_specification`
--

CREATE TABLE `doc_specification` (
  `specification_id` int(5) NOT NULL,
  `specification_name` varchar(255) NOT NULL,
  `specification_dis` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doc_specification`
--

INSERT INTO `doc_specification` (`specification_id`, `specification_name`, `specification_dis`) VALUES
(1, 'Podiatrist', 'Podiatrists are specialists in the feet and the lower limbs. They treat and manage pain and diseases, as well as injuries, to help keep people active and pain free. A lot of common issues are treatable by podiatrists, such as bunions. They can also help with ongoing issues or injuries.'),
(2, 'General Practitioner', 'A general practitioner is trained to provide healthcare to patients of any sex or age. General practitioners often work as primary care physicians (PCPs), see their patients regularly, and are familiar with their medical backgrounds. Most people do (or should) see a PCP at least once a year. When you suspect something else is going on, your first stop is a PCP since they\'re responsible for your overall care and well-being. They can then refer you to the right specialist.'),
(3, 'Pediatrician', 'A pediatrician is a doctor that specializes in childhood medicine, or those under 18. Some pediatricians will see their patients until they are 21. Pediatricians oversee the health and development of babies and children. They administer vaccines. keep track of a child\'s growth, and are the first contact when a child a sick.'),
(4, 'Endocrinologist', 'Endocrinologists specialize in glands and all the hormones they produce. Endocrinologists commonly treat diabetes, thyroid dysfunction, and reproductive health. You may see an endocrinologist for any of the above, and will usually be referred by your PCP if you report symptoms or have related discrepancies in your blood work. Some endocrinologists do focus specifically on one area of the body. For example, a reproductive endocrinologists focuses on the reproductive system, and people often work with these doctors when seeking fertility'),
(5, 'Neurologist', 'A neurologist focuses on the anatomy, functions, and disorders of the nerves and nervous systems. Neurologists work with people who have had strokes and those with degenerative diseases of the nervous system, like multiple sclerosis. If you exhibit loss of motor of cognitive function, you could be referred to a neurologist.'),
(6, 'Rheumatologist', 'A rheumatologist is a specialist in internal medicine of joints, muscles, and bones. Another specialist on our list, an orthopedist, also works with the joints, muscles, and bones, but a rheumatologist is unique because they focus on the origin of the problem, and the body\'s overall movement and health. Orthopedists tend to focus on more acute areas of pain and injury. We\'ll get into more about orthopedists later. One of the main reasons to see a rheumatologist is because of arthritis, but they also work with patients who have tendinitis, lupus, gout, and more, to manage chronic pain.'),
(7, 'Psychiatrist', 'Psychiatrists focus exclusively on mental health. You may see a psychiatrist if you believe you have symptoms of mental illness. People usually seek out psychiatrists themselves, but some PCP\'s now are adding mental health screenings to yearly checkups, and may provide a referral. Psychiatrists can specialize in more than one mental illness, and can also specialize in treating substance abuse. Psychiatrists can informally specialize in specific age groups, though some informally prefer to work with different ages and on different illnesses as they gain experience with patients.'),
(8, 'Nephrologist', 'Nephrology is a specialty that focuses on diseases of the kidneys. Nephrologists deal with failure and serious chronic conditions of the kidneys. If your PCP suspects you have a kidney specific disease, they will refer you to a nephrologist.'),
(9, 'OB/GYN', 'An obstetrician/gynecologist, this title is commonly shortened to OB/GYN. Gynecologists specialize in diseases of the female reproductive organs, and obstetricians specialize in pregnancy and childbirth. Doctors often specialize in both so that they can help patients with a full range of reproductive medicine. Common reasons for visiting an OB/GYN are: you\'re seeking a contraceptive method, are experience irregular period symptoms or pelvic pain, or are seeking prenatal care. It\'s also recommended that patients with female reproductive organs have an exam by the OB/GYN once per year.'),
(10, 'Pulmonologist', 'Pulmonologists focus on the the respiratory organs — the lungs, airway and respiratory muscles. the A PCP will refer you to a pulmonologist if you have a respiratory infection or a chronic issue, like COPD or sleep apnea.'),
(11, 'Surgeon', 'A surgeon\'s primary function is to perform surgery. They analyze a patient\'s health and history, and create a surgical plan that prioritize the patient\'s safety and recovery. They also coordinate other staff that participates in surgery, and work with other physicians post-op.\r\n\r\nYou might see a surgeon for a variety of reasons. Surgeries are typically scheduled in advance, except emergency surgery. Surgeries can be major or minor, and have varying recovering times. Surgeons can specialize in many areas of medicine. Common specializations are cardiac surgeons, orthopedic surgeons, and emergency surgeons.'),
(12, 'Emergency Physician', 'Emergency physicians are trained as physicians, and then go through additional training to master their skills in acute diagnosis in illness and injury. You will see an emergency physician if experiencing a medical emergency and in the emergency room in a hospital. Medical professionals assess a condition in order to determine the immediacy of a medical emergency, and then doctors diagnose, prescribe treatment, and decide whether or not a patient needs to be admitted to the hospital.'),
(13, 'Ophthalmologist', 'An ophthalmologist is a type of eye doctor who is trained and certified to provide eye care and perform oral surgery. You would see an ophthalmologist if your PCP or optometrist suspects you have a more serious eye disease, or might need surgery. Some people choose to see ophthalmologists for annual eye exams as well.'),
(14, 'Oncologist', 'Oncologists are doctors that deal with the prevention, diagnosis, and treatment of cancer. You will see an oncologist if your usual doctor suspects you have cancer. Your oncologist will order tests, confirm, diagnose, and stage your cancer. They will also develop and oversee your treatment plan. Many other people will be involved in a cancer care team, but an oncologist is the leader of that team.'),
(15, 'Urologist', 'A urologist specializes in function and treatment of the urinary system. If your PCP thinks thinks you have symptoms a urinary disease, such as excessive urinating, they will refer you to a urologist. Urologists often work with other doctors to treat illnesses; for example, a urologist may be involved in treating prostate of bladder cancer alongside an oncologist.'),
(16, 'Otolaryngologist', 'Otolaryngologists are often referred to as ENTs, for Ear, Nose, and Throat. ENTs work with diseases of the ear, nose, and throat, hence the nickname. You may see an ENT for infections or for chronic issues like a deviated septum.');

-- --------------------------------------------------------

--
-- Table structure for table `hospitals`
--

CREATE TABLE `hospitals` (
  `hospital_id` int(100) NOT NULL,
  `hospital_name` varchar(225) NOT NULL,
  `hospital_city` varchar(255) NOT NULL,
  `hospital_address_no` varchar(10) NOT NULL,
  `hospital_address_lane1` varchar(100) NOT NULL,
  `hospital_address_lane2` varchar(200) NOT NULL,
  `hospital_address_lane3` varchar(200) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hospitals`
--

INSERT INTO `hospitals` (`hospital_id`, `hospital_name`, `hospital_city`, `hospital_address_no`, `hospital_address_lane1`, `hospital_address_lane2`, `hospital_address_lane3`, `tel`, `email`) VALUES
(100, 'Colombo hospital', 'Colombo', '10', 'Gall Road,', 'wellawatta.', 'colombo3', '0342456987', 'colombohospitals@gmail.com'),
(101, 'Kandy hospital', 'kandy', '20', 'Kandy Road,', 'templeroad.', 'kandy', '0342456445', 'Kandyhospital@gmail.com'),
(103, 'Chilaw hospital', 'chilaw', '27', 'puttalam Road,', 'katubadda', 'chilaw', '0342257445', 'Chilawhospital@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `login_id` int(5) NOT NULL,
  `user_id` int(5) NOT NULL,
  `Token` text NOT NULL,
  `generate_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `log_count` int(225) NOT NULL,
  `ipAddress` varchar(100) NOT NULL,
  `hostname` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`login_id`, `user_id`, `Token`, `generate_date`, `log_count`, `ipAddress`, `hostname`) VALUES
(31, 253, 'umIlzw7UEiuY61JVNJ/fnzDjngbnX7u/fcCkGzVN8zvH5ByoGYcupj37OWOOWifN3pcWN5F0nsrhAaQpLKPVrjDeHUvK60gQNcWepEPcqK+hAGz78XDm92qBST2FSkf0', '2020-04-22 05:27:33', 1, '169.254.143.19', 'DESKTOP-087450S/169.254.143.19');

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `patient_id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `NIC` varchar(20) DEFAULT NULL,
  `DOB` varchar(20) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`patient_id`, `first_name`, `last_name`, `NIC`, `DOB`, `Password`, `time`) VALUES
(227, 'Akalanka', 'Nayanajith', NULL, NULL, NULL, '2020-04-21 17:14:51'),
(228, 'Akalanka', 'Nayanajith', NULL, NULL, NULL, '2020-04-21 17:16:45'),
(229, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:26:52'),
(230, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:28:10'),
(231, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:31:37'),
(232, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:34:08'),
(233, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:34:34'),
(234, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:41:40'),
(235, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:46:27'),
(236, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:47:47'),
(237, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:47:49'),
(238, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:47:50'),
(239, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:47:50'),
(240, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:47:51'),
(241, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:47:51'),
(242, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:47:56'),
(243, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:52:43'),
(244, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:54:34'),
(245, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:55:40'),
(246, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:57:35'),
(247, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 17:59:28'),
(248, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 18:00:29'),
(249, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 18:06:43'),
(250, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 18:31:48'),
(251, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 18:32:19'),
(252, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-21 19:27:26'),
(253, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-22 04:49:31'),
(254, 'Akalanka', 'Nayanajth', NULL, NULL, NULL, '2020-04-22 05:10:44');

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `payment_id` int(11) NOT NULL,
  `doc_id` int(11) NOT NULL,
  `hos_id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `doc_fee` double NOT NULL,
  `hos_fee` double NOT NULL,
  `reference_No` int(11) NOT NULL,
  `date_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `app_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`payment_id`, `doc_id`, `hos_id`, `amount`, `doc_fee`, `hos_fee`, `reference_No`, `date_time`, `app_id`) VALUES
(27, 10003, 500028, 5000, 1000, 4000, -227176780, '2020-04-22 03:07:09', 16),
(28, 10003, 500028, 5000, 1000, 4000, 1408359960, '2020-04-22 04:52:51', 19),
(29, 10003, 500028, 5000, 1000, 4000, -1531077935, '2020-04-22 05:11:44', 20),
(30, 10000, 500001, 1500, 300, 1200, -251404694, '2020-04-22 05:27:33', 21);

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `test_id` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `userprofile`
--

CREATE TABLE `userprofile` (
  `user_id` int(5) NOT NULL,
  `username` varchar(225) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_role` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userprofile`
--

INSERT INTO `userprofile` (`user_id`, `username`, `user_email`, `user_password`, `user_role`) VALUES
(30, 'chamal', 'chamal@gmil.com', 'chamal', 'hospital'),
(100, 'nayanajith', 'nayanajith@gmail.com', 'admin', 'patient'),
(101, 'nayana5ith', 'nayana5ith@gmail.com', 'admin', 'patient'),
(248, 'nayjih', 'nayanh@gmail.com', 'admin', 'patient'),
(249, 'nayah', 'nayah@gmail.com', 'admin', 'patient'),
(251, 'nayh', 'nayh@gmail.com', 'admin', 'patient'),
(252, 'abcd', 'abcd@gmail.com', '123', 'patient'),
(253, 'abc', 'abc@gmail.com', '123', 'patient'),
(254, 'ab', 'ab@gmail.com', '123', 'patient'),
(8080, 'admin', 'admin', 'admin ', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `abc`
--
ALTER TABLE `abc`
  ADD PRIMARY KEY (`pk`);

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`app_id`),
  ADD UNIQUE KEY `app_patient_id` (`app_patient_id`,`app_session_id`);

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`doc_id`),
  ADD UNIQUE KEY `reg_no` (`doc_reg_no`),
  ADD KEY `doc_spec_FK` (`doc_specification_id`);

--
-- Indexes for table `doc_hospital`
--
ALTER TABLE `doc_hospital`
  ADD PRIMARY KEY (`doc_id`,`hostpital_id`);

--
-- Indexes for table `doc_session`
--
ALTER TABLE `doc_session`
  ADD PRIMARY KEY (`session_id`),
  ADD UNIQUE KEY `doc_id` (`doc_id`,`available_date`,`start_time`,`end_time`,`isEveryday`),
  ADD KEY `doc_ses_FK` (`doc_id`);

--
-- Indexes for table `doc_specification`
--
ALTER TABLE `doc_specification`
  ADD PRIMARY KEY (`specification_id`);

--
-- Indexes for table `hospitals`
--
ALTER TABLE `hospitals`
  ADD PRIMARY KEY (`hospital_id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`login_id`),
  ADD UNIQUE KEY `Token` (`Token`) USING HASH;

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`patient_id`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`payment_id`),
  ADD UNIQUE KEY `app_id` (`app_id`);

--
-- Indexes for table `userprofile`
--
ALTER TABLE `userprofile`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`,`user_email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `abc`
--
ALTER TABLE `abc`
  MODIFY `pk` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `app_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `doctors`
--
ALTER TABLE `doctors`
  MODIFY `doc_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10011;

--
-- AUTO_INCREMENT for table `doc_session`
--
ALTER TABLE `doc_session`
  MODIFY `session_id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=500041;

--
-- AUTO_INCREMENT for table `doc_specification`
--
ALTER TABLE `doc_specification`
  MODIFY `specification_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `hospitals`
--
ALTER TABLE `hospitals`
  MODIFY `hospital_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `login_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `patient_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=255;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `doctors`
--
ALTER TABLE `doctors`
  ADD CONSTRAINT `doc_spec_FK` FOREIGN KEY (`doc_specification_id`) REFERENCES `doc_specification` (`specification_id`);

--
-- Constraints for table `doc_hospital`
--
ALTER TABLE `doc_hospital`
  ADD CONSTRAINT `doc_host_FK` FOREIGN KEY (`doc_id`) REFERENCES `doctors` (`doc_id`);

--
-- Constraints for table `doc_session`
--
ALTER TABLE `doc_session`
  ADD CONSTRAINT `doc_ses_FK` FOREIGN KEY (`doc_id`) REFERENCES `doctors` (`doc_id`);

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`root`@`localhost` EVENT `delete_log_data` ON SCHEDULE EVERY 1 MINUTE STARTS '2020-03-31 00:05:59' ON COMPLETION NOT PRESERVE ENABLE DO DELETE FROM login where generate_date < TIMESTAMP(timestampadd(hour, -1, now())) ORDER BY generate_date DESC$$

CREATE DEFINER=`root`@`localhost` EVENT `delectAbc` ON SCHEDULE EVERY 1 MINUTE STARTS '2020-03-31 00:36:57' ON COMPLETION NOT PRESERVE DISABLE DO INSERT INTO test VALUES (TIMESTAMP(TIMESTAMPADD(day,-3,now())))$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
