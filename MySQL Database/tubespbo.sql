-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 25 Jan 2022 pada 09.17
-- Versi server: 10.4.22-MariaDB
-- Versi PHP: 8.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubespbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `email` varchar(50) NOT NULL,
  `id_karyawan` int(10) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`email`, `id_karyawan`, `password`) VALUES
('bijakap@admin.com', 101, 'admin101'),
('fadhilw@admin.com', 102, 'admin102');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kamar`
--

CREATE TABLE `kamar` (
  `nomor` int(11) NOT NULL,
  `lantai` varchar(10) NOT NULL,
  `tipe` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kamar`
--

INSERT INTO `kamar` (`nomor`, `lantai`, `tipe`, `status`) VALUES
(1, 'Lantai-1', 'Standar', 'Booked'),
(2, 'Lantai-1', 'Standar', 'Kosong'),
(3, 'Lantai-1', 'Standar', 'Kosong'),
(4, 'Lantai-1', 'Standar', 'Booked'),
(5, 'Lantai-1', 'Standar', 'Kosong'),
(6, 'Lantai-2', 'Superior', 'Kosong'),
(7, 'Lantai-2', 'Superior', 'Kosong'),
(8, 'Lantai-2', 'Superior', 'Kosong'),
(9, 'Lantai-2', 'Superior', 'Kosong'),
(10, 'Lantai-2', 'Superior', 'Booked'),
(11, 'Lantai-3', 'Deluxe', 'Kosong'),
(12, 'Lantai-3', 'Deluxe', 'Booked'),
(13, 'Lantai-3', 'Deluxe', 'Booked'),
(14, 'Lantai-3', 'Deluxe', 'Kosong'),
(15, 'Lantai-3', 'Deluxe', 'Booked');

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` int(10) NOT NULL,
  `nama_karyawan` varchar(50) NOT NULL,
  `gender_karyawan` varchar(10) NOT NULL,
  `No_hp` varchar(15) NOT NULL,
  `posisi` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nama_karyawan`, `gender_karyawan`, `No_hp`, `posisi`) VALUES
(101, 'BijakAP', 'Laki-Laki', '087737771211', 'Resepsionis'),
(102, 'FadhilW', 'Laki-Laki', '087737771212', 'Resepsionis'),
(201, 'M.Dony', 'Laki-Laki', '087737771213', 'HouseKeeping');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tamu`
--

CREATE TABLE `tamu` (
  `id_tamu` int(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `nomor_hp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tamu`
--

INSERT INTO `tamu` (`id_tamu`, `nama`, `nomor_hp`) VALUES
(3001, 'Eren Jeger', '0801'),
(3002, 'jembatan', '333444'),
(1002, 'kyutie', '33445566'),
(2001, 'Mikasa Jeger', '0802'),
(1001, 'queen', '12345'),
(3003, 'something', '2222');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_tamu` int(10) NOT NULL,
  `nomor` int(11) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_tamu`, `nomor`, `password`) VALUES
(1001, 1, 'qwerty123'),
(1002, 4, 'qwerty123'),
(2001, 10, 'qwerty123'),
(3001, 15, 'qwerty123'),
(3002, 12, 'qwerty123'),
(3003, 13, 'qwerty123');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`email`),
  ADD KEY `id_admin` (`id_karyawan`);

--
-- Indeks untuk tabel `kamar`
--
ALTER TABLE `kamar`
  ADD PRIMARY KEY (`nomor`);

--
-- Indeks untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indeks untuk tabel `tamu`
--
ALTER TABLE `tamu`
  ADD PRIMARY KEY (`nama`),
  ADD KEY `id_tamu` (`id_tamu`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_tamu`),
  ADD KEY `nomor` (`nomor`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `id_admin` FOREIGN KEY (`id_karyawan`) REFERENCES `karyawan` (`id_karyawan`);

--
-- Ketidakleluasaan untuk tabel `tamu`
--
ALTER TABLE `tamu`
  ADD CONSTRAINT `id_tamu` FOREIGN KEY (`id_tamu`) REFERENCES `user` (`id_tamu`);

--
-- Ketidakleluasaan untuk tabel `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `nomor` FOREIGN KEY (`nomor`) REFERENCES `kamar` (`nomor`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
