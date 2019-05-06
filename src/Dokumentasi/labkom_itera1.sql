-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2019 at 12:11 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `labkom_itera1`
--

-- --------------------------------------------------------

--
-- Table structure for table `asprak_atau_dosen`
--

CREATE TABLE `asprak_atau_dosen` (
  `NIMorNIK` char(16) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `id_jadwal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asprak_atau_dosen`
--

INSERT INTO `asprak_atau_dosen` (`NIMorNIK`, `nama`, `id_jadwal`) VALUES
('10001', 'Hartanto Tantriawan', 15),
('10002', 'Wira Buana', 5),
('13117037', 'Anbia Senggagau', 7),
('13117122', 'M Rian Saputra', 8),
('14115023', 'Anggraeni Intan', 1),
('14116001', 'Jose Sitanggang', 10),
('14116010', 'Yoghaswara', 2),
('14116015', 'arwin', 2),
('14116023', 'Reza Aidil Adha', 9),
('14116027', 'Taufik Agung Santoso', 2),
('14116029', 'Dicky Hermawan', 11),
('14117030', 'Riwandy', 14),
('14117037', 'Nardiyansah', 5),
('14117038', 'Habib Abdurrasyid', 3),
('14117055', 'Dhiko Jangjaya', 6),
('15116044', 'Kirey Aulia', 4),
('23116001', 'Devi Nabilah', 12);

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `id_jadwal` int(11) NOT NULL,
  `prodi` varchar(25) NOT NULL,
  `mata_kuliah` varchar(50) NOT NULL,
  `kode_lab` varchar(5) NOT NULL,
  `hari` varchar(10) NOT NULL,
  `jam` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`id_jadwal`, `prodi`, `mata_kuliah`, `kode_lab`, `hari`, `jam`) VALUES
(1, 'IF', 'drpl', 'GK1', 'jumat', '14:00:00'),
(2, 'IF', 'BASIS DATA', 'C2', 'senin', '17:00:00'),
(3, 'TPB 1', 'PKS', 'C2', 'senin', '15:00:00'),
(4, 'TI', 'Basis Data Industri', 'GK1', 'Senin', '09:00:00'),
(5, 'TPB 2', 'PKS', 'C1', 'Senin', '07:00:00'),
(6, 'TPB 3', 'PKS', 'C1', 'Senin', '09:00:00'),
(7, 'TPB 4', 'PKS', 'C2', 'Selasa', '07:00:00'),
(8, 'TPB 5', 'PKS', 'C2', 'Selasa', '09:00:00'),
(9, 'IF', 'Basis Data', 'C1', 'Rabu', '17:00:00'),
(10, 'IF', 'DRPL', 'C2', 'Kamis', '17:00:00'),
(11, 'IF', 'Algoritma dan Struktur Data', 'C2', 'Rabu', '11:00:00'),
(12, 'Teknik Geomatika', 'Basis Data Spasial', 'GK1', 'Kamis', '13:00:00'),
(13, 'TPB 13', 'PKS', 'C1', 'Rabu', '13:00:00'),
(14, 'IF', 'Algoritma Pemrograman', 'C1', 'Jumat', '09:00:00'),
(15, 'TPB 15', 'PKS', 'C1', 'Selasa', '11:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `lab`
--

CREATE TABLE `lab` (
  `kode_lab` varchar(5) NOT NULL,
  `nama_lab` varchar(25) NOT NULL,
  `nama_ruang` varchar(5) NOT NULL,
  `kapasitas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lab`
--

INSERT INTO `lab` (`kode_lab`, `nama_lab`, `nama_ruang`, `kapasitas`) VALUES
('C1', 'Lab MM 2', 'C301', 80),
('C2', 'LAB MM 2', 'C302', 80),
('GK1', 'LAB BKU PRODI', 'GK201', 60);

-- --------------------------------------------------------

--
-- Table structure for table `laboran`
--

CREATE TABLE `laboran` (
  `id_laboran` int(11) NOT NULL,
  `nama_laboran` varchar(25) DEFAULT NULL,
  `kode_lab` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `laboran`
--

INSERT INTO `laboran` (`id_laboran`, `nama_laboran`, `kode_lab`) VALUES
(1, 'ROBBY', 'GK1'),
(2, 'M Fitra Ramadhan', 'C1'),
(3, 'Deni Suparman', 'C2');

-- --------------------------------------------------------

--
-- Table structure for table `pinjam_lab`
--

CREATE TABLE `pinjam_lab` (
  `tanggal_pinjam` date NOT NULL,
  `jam` time NOT NULL,
  `kode_lab` varchar(5) NOT NULL,
  `id_peminjam` int(11) NOT NULL,
  `nama_peminjam` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pinjam_lab`
--

INSERT INTO `pinjam_lab` (`tanggal_pinjam`, `jam`, `kode_lab`, `id_peminjam`, `nama_peminjam`) VALUES
('2019-04-14', '07:00:00', 'C2', 1, 'Nardiyansah'),
('2019-04-18', '07:00:00', 'C2', 2, 'Habib Abdurrasyid'),
('2019-02-11', '07:00:00', 'C2', 3, 'Anbia Senggagau'),
('2019-02-25', '11:00:00', 'GK1', 4, 'Kirey Aulia'),
('2019-04-11', '13:00:00', 'GK1', 5, 'Reza Aidil Adha'),
('2019-04-18', '09:00:00', 'GK1', 6, 'Devi Nabilah'),
('2019-04-01', '17:00:00', 'C1', 7, 'Yoghaswara'),
('2019-03-11', '13:00:00', 'C2', 8, 'Dicky Hermawan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `asprak_atau_dosen`
--
ALTER TABLE `asprak_atau_dosen`
  ADD PRIMARY KEY (`NIMorNIK`),
  ADD KEY `id_jadwal` (`id_jadwal`);

--
-- Indexes for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`id_jadwal`),
  ADD KEY `kode_lab` (`kode_lab`);

--
-- Indexes for table `lab`
--
ALTER TABLE `lab`
  ADD PRIMARY KEY (`kode_lab`);

--
-- Indexes for table `laboran`
--
ALTER TABLE `laboran`
  ADD PRIMARY KEY (`id_laboran`),
  ADD KEY `kode_lab` (`kode_lab`);

--
-- Indexes for table `pinjam_lab`
--
ALTER TABLE `pinjam_lab`
  ADD PRIMARY KEY (`id_peminjam`),
  ADD KEY `kode_lab` (`kode_lab`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `asprak_atau_dosen`
--
ALTER TABLE `asprak_atau_dosen`
  ADD CONSTRAINT `asprak_atau_dosen_ibfk_1` FOREIGN KEY (`id_jadwal`) REFERENCES `jadwal` (`id_jadwal`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD CONSTRAINT `jadwal_ibfk_1` FOREIGN KEY (`kode_lab`) REFERENCES `lab` (`kode_lab`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `laboran`
--
ALTER TABLE `laboran`
  ADD CONSTRAINT `laboran_ibfk_1` FOREIGN KEY (`kode_lab`) REFERENCES `lab` (`kode_lab`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pinjam_lab`
--
ALTER TABLE `pinjam_lab`
  ADD CONSTRAINT `pinjam_lab_ibfk_1` FOREIGN KEY (`kode_lab`) REFERENCES `lab` (`kode_lab`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
