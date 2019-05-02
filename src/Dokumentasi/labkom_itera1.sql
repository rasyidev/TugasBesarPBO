-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2019 at 07:18 PM
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
  `id_jadwal` int(11) NOT NULL,
  `keterangan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asprak_atau_dosen`
--

INSERT INTO `asprak_atau_dosen` (`NIMorNIK`, `nama`, `id_jadwal`, `keterangan`) VALUES
('14116100', 'fadillah', 1, ''),
('16117015', 'arwin', 2, '');

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `NIK` int(16) NOT NULL,
  `nama` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`NIK`, `nama`) VALUES
(2147483647, 'Hartanto Tantriawan');

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
(1, 'IF', 'DRPL', 'C1', 'senin', '13:00:00'),
(2, 'IF', 'BASIS DATA', 'C2', 'senin', '17:00:00'),
(3, 'TPB', 'PKS', 'C2', 'senin', '15:00:00');

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
('C1', 'LAB PRODI', 'C301', 80),
('C2', 'LAB MM', 'C302', 80);

-- --------------------------------------------------------

--
-- Table structure for table `laboran`
--

CREATE TABLE `laboran` (
  `id_laboran` int(11) NOT NULL,
  `nama_laboran` varchar(25) DEFAULT NULL,
  `kode_lab` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
('2019-04-14', '07:00:00', 'C2', 1, 'aldi'),
('2019-04-18', '07:00:00', 'C2', 2, 'habib'),
('2019-04-18', '07:00:00', 'C1', 3, 'robby');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `nama` varchar(25) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`nama`, `username`, `password`) VALUES
('aldi', 'aldi15', '9807a219c0419752e0d7257dcfc88d4d'),
('habib', 'habib15', 'e31b4962073bca0227bb59ff54cef67c');

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
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`NIK`);

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
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

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
