-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 21, 2020 at 08:22 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `poppyagustian_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_karyawan`
--

CREATE TABLE `tb_karyawan` (
  `id` bigint(20) NOT NULL,
  `nik` bigint(20) DEFAULT NULL,
  `nama_karyawan` varchar(255) DEFAULT NULL,
  `jenis_kelamin` varchar(255) DEFAULT NULL,
  `shift_kerja` varchar(255) DEFAULT NULL,
  `status_perkawinan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_karyawan`
--

INSERT INTO `tb_karyawan` (`id`, `nik`, `nama_karyawan`, `jenis_kelamin`, `shift_kerja`, `status_perkawinan`) VALUES
(12, 123213, 'asdasd', 'Laki-Laki', 'Shift Pagi', 'Menikah'),
(13, 123456789, 'jok susilo', 'Laki-Laki', 'Shift Malam', 'Belum Menikah'),
(14, 123214, 'sadsa', 'Laki-Laki', 'Shift Pagi', 'Belum Menikah'),
(15, 123214, 'sadsa', 'Laki-Laki', 'Shift Pagi', 'Menikah'),
(16, 123214, 'sadsa', 'Perempuan', 'Shift Pagi', 'Menikah'),
(17, 123214, 'sadsa', 'Perempuan', 'Shift Malam', 'Menikah');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_karyawan`
--
ALTER TABLE `tb_karyawan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_karyawan`
--
ALTER TABLE `tb_karyawan`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
