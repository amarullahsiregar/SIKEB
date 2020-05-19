-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2020 at 11:29 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sikeb`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `nomor` int(10) NOT NULL,
  `nama_barang` varchar(20) DEFAULT NULL,
  `id_pengguna` int(11) NOT NULL,
  `waktu` date DEFAULT NULL,
  `status_barang` tinyint(1) DEFAULT NULL COMMENT '1 = hilang, 0 = temuan',
  `keterangan` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`nomor`, `nama_barang`, `id_pengguna`, `waktu`, `status_barang`, `keterangan`) VALUES
(1, 'Hand phone', 14117136, '2020-04-28', 0, 'ditemukan di belakang wisma'),
(2, 'dompet', 123, '2020-04-29', 1, 'di gedung e'),
(3, 'tas', 14117166, '2020-05-01', 0, 'di rk'),
(4, 'STNK', 124, '2020-05-03', 0, 'ditemukan di sekitar Ged A'),
(5, 'kunci motor', 123, '2020-05-04', 1, 'hilang di parkiran ged c'),
(6, 'KTP', 0, '2020-05-04', 1, 'hilang disekitar RK'),
(7, 'Jam tangan', 124, '2020-05-04', 1, 'hilang di parkiran Ged e'),
(8, 'Kunci', 123, '2020-05-05', 0, 'ditemukan di ged e'),
(9, 'kotak pensil', 123, '2020-04-07', 0, 'ditemukan di E114'),
(10, 'kotak pensil', 0, '2020-04-07', 1, 'hilang di e113'),
(11, 'ktp', 124, '2020-04-08', 0, 'di temukan ktp atas nama bayu di gedung E'),
(12, 'kunci motor', 123, '2020-05-09', 0, 'ditemukan kunci motor honda di parkiran gedung C'),
(13, 'jaket', 124, '2020-05-09', 1, 'dicari jaket warna hitam di ruang D310'),
(14, 'alamater', 124, '2020-05-09', 0, 'ditemukan di ruang E201'),
(15, 'cassan', 123, '2020-05-09', 0, 'ditemuakan cassan samsung di ruang E111'),
(16, 'sepatu', 124, '2020-05-10', 1, 'dicari sepatu warna putih di RK'),
(17, 'jam tanggan', 0, '2020-05-11', 0, 'ditemuakn jam tanggan di ruang GK201'),
(18, 'laptop', 123, '2020-05-11', 1, 'dicari laptop asus warna putih di sekitar BLK'),
(19, 'hp', 123, '2020-05-12', 0, 'ditemukan hp warna hitam di ruang E110'),
(20, 'tas', 124, '2020-05-14', 0, 'ditemukan tas selempang warna merah di gallery'),
(21, 'Charger Asus', 14117135, '2020-05-17', 1, 'Hilang DI Amerika');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id_pengguna` int(11) NOT NULL,
  `password` varchar(10) DEFAULT NULL,
  `nama_pengguna` varchar(30) DEFAULT NULL,
  `kontak` varchar(50) DEFAULT NULL,
  `status_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id_pengguna`, `password`, `nama_pengguna`, `kontak`, `status_user`) VALUES
(0, 'nol', 'Tomy', '0856780988', 0),
(123, 'user', 'bayu idris', 'bayu.idris@mail.com', 1),
(124, 'user', 'Ahmad Syafi\'i', 'syafii.ahmad@mail.com', 1),
(12345678, 'admin', 'admin cadangan', 'admin@mail.com', 2),
(14117135, 'katasandi', 'Rahman Amarullah Siregar', 'rahman.14117135@student.itera.ac.id', 2),
(14117136, 'adhelia', 'Vanesa Adhelia', '082146797553', 2),
(14117166, 'alqomar', 'Rozi Al-Qomar', '089696763084', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`nomor`),
  ADD KEY `id_pengguna` (`id_pengguna`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id_pengguna`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
