-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 24, 2021 at 11:50 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bimba`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrasi`
--

CREATE TABLE `administrasi` (
  `no_pembayaran` int(11) NOT NULL,
  `nis` int(11) NOT NULL,
  `nama_siswa` varchar(100) NOT NULL,
  `kelas` varchar(100) NOT NULL,
  `tahun_ajaran` varchar(4) NOT NULL,
  `tanggal_pembayaran` date NOT NULL,
  `jenis_pembayaran` varchar(100) NOT NULL,
  `biaya` int(11) NOT NULL,
  `id_petugas` int(11) NOT NULL,
  `nama_petugas` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrasi`
--

INSERT INTO `administrasi` (`no_pembayaran`, `nis`, `nama_siswa`, `kelas`, `tahun_ajaran`, `tanggal_pembayaran`, `jenis_pembayaran`, `biaya`, `id_petugas`, `nama_petugas`) VALUES
(1, 171, 'Arzachael Aditya Ramadhan', 'PDD', '2021', '2021-02-02', 'SPP PDD', 50000, 2, 'Riyan Shafar'),
(2, 290, 'Ayunda Asaili Jannatin', 'PDM', '2021', '2020-06-04', 'SPP PDM', 200000, 2, 'Riyan Shafar'),
(3, 257, 'Galang Anggara Satria', 'PDM', '2021', '2021-06-08', 'SPP PDM', 200000, 2, 'Riyan Shafar'),
(4, 364, 'Tara Shofwa Prihandoyo', 'PDS', '2021', '2021-06-02', 'SPP PDS', 100000, 2, 'Riyan Shafar'),
(5, 258, ' Gibran Damar Rachyanto  ', 'PDS', '2021', '2021-07-24', 'SPP PDS', 100000, 2, 'Riyan Shafar'),
(6, 312, 'Riyan', 'Regular', '2021', '2021-07-25', 'SPP Regular', 350000, 11, 'RiyanShafarSatriawan');

-- --------------------------------------------------------

--
-- Table structure for table `guru`
--

CREATE TABLE `guru` (
  `nip` int(50) NOT NULL,
  `nama_guru` varchar(100) NOT NULL,
  `tempat_lahir` varchar(100) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `jk` varchar(100) NOT NULL,
  `alamat` text NOT NULL,
  `no_hp` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `agama` varchar(100) NOT NULL,
  `tahun_ajaran` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guru`
--

INSERT INTO `guru` (`nip`, `nama_guru`, `tempat_lahir`, `tanggal_lahir`, `jk`, `alamat`, `no_hp`, `status`, `agama`, `tahun_ajaran`) VALUES
(1, 'Yuniar Widianingsih', 'Depok,', '1999-06-06', 'Perempuan', 'Kp Nyencle Rt 05/01. Cilangkap, Tapos, Depok', '0895395589855', 'Tutor Aktif', 'Islam', '2020/2021'),
(2, 'Heni Pebriani', 'Tanjung aman', '1995-02-07', 'Perempuan', 'Kp.Sidamukti Rt 08/02. Sukamaju, Cilodong, Depok.', '081546851596', 'Tutor Aktif', 'Islam', '2020/2021'),
(3, 'Kristia Wahyuni', 'Bogor', '1996-06-23', 'Perempuan', 'Jl.Bedahan Rt 07/01. kel.Pabuaran mekar kec.Cibinong Bogor', '0895619340896', 'Ketua Pelaksana', 'Islam', '2020/2021'),
(4, 'Rika Febrianti', 'Depok', '2002-02-11', 'Perempuan', 'Jl. H. Abdul Ghani 1 Kp. Bulak Rt. 03 Rw. 02 Kel. Kalibaru Kec. Cilodong Depok', '0895320025922', 'Tutor Aktif', 'Islam', '2020/2021'),
(5, 'Ayu Zulfa', 'Wonogiri', '1999-06-19', 'Perempuan', 'Kp. Jatijajar rt 05/rw 01, kel.  Jatijajar, kec. Tapos ,Depok', '085716185658', 'Guru', 'Islam', '2020/2021');

-- --------------------------------------------------------

--
-- Table structure for table `matapelajaran`
--

CREATE TABLE `matapelajaran` (
  `no` int(11) NOT NULL,
  `kd_matpel` varchar(5) NOT NULL,
  `nama_matpel` varchar(100) NOT NULL,
  `nip` int(11) NOT NULL,
  `nama_guru` varchar(100) NOT NULL,
  `hari` varchar(100) NOT NULL,
  `kelas` varchar(100) NOT NULL,
  `jam` varchar(100) NOT NULL,
  `tahun_ajaran` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matapelajaran`
--

INSERT INTO `matapelajaran` (`no`, `kd_matpel`, `nama_matpel`, `nip`, `nama_guru`, `hari`, `kelas`, `jam`, `tahun_ajaran`) VALUES
(1, 'H003', 'Hitung', 5, 'Ayu Zulfa', 'Selasa', 'Regular', '12.00-13.00', '2020/2021'),
(3, 'H001', 'Hitung', 5, 'Ayu Zulfa', 'Jumat', 'Regular', '13.00-14.00', '2020/2021'),
(4, 'H002', 'Hitung', 1, 'Yuniar Widianingsih', 'Senin', 'Intensif', '08.00-09.00', '2020/2021'),
(5, 'B001', 'Baca', 2, 'Heni Pebriani', 'Rabu', 'Regular', '13.00-14.00', '2020/2021'),
(6, 'B002', 'Baca', 2, 'Heni Pebriani', 'Rabu', 'Regular', '10.00-11.00', '2020/2021'),
(7, 'B003', 'Baca', 2, 'Heni Pebriani', 'Rabu', 'Regular', '14.00-15.00', '2020/2021'),
(8, 'MO001', 'Mengenal objek', 4, 'Rika Febrianti', 'Jumat', 'PDM', '08.00-09.00', '2020/2021'),
(9, 'MO002', 'Mengenal objek', 3, 'Kristia Wahyuni', 'Selasa', 'Intensif', '08.00-09.00', '2020/2021'),
(10, 'M004', 'Mewarnai', 1, 'Yuniar Widianingsih', 'Rabu', 'PDS', '08.00-09.00', '2020/2021'),
(11, 'M002', 'Mewarnai', 3, 'Kristia Wahyuni', 'Kamis', 'PDD', '12.00-13.00', '2020/2021'),
(12, 'T001', 'Tulis', 1, 'Yuniar Widianingsih', 'Kamis', 'Regular', '14.00-15.00', '2020/2021'),
(13, 'T003', 'Tulis', 2, 'Heni Pebriani', 'Senin', 'Intensif', '08.00-09.00', '2020/2021');

-- --------------------------------------------------------

--
-- Table structure for table `pendaftaran`
--

CREATE TABLE `pendaftaran` (
  `no` int(11) NOT NULL,
  `tgl_daftar` date NOT NULL,
  `nama_siswa` varchar(100) NOT NULL,
  `jk` varchar(100) NOT NULL,
  `np` int(20) NOT NULL,
  `tempat_lahir` varchar(100) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `alamat` text NOT NULL,
  `agama` varchar(15) NOT NULL,
  `berat_tinggi` varchar(15) NOT NULL,
  `nama_ayah` varchar(100) NOT NULL,
  `pend_ayah` varchar(100) NOT NULL,
  `pekerjaan_ayah` varchar(100) NOT NULL,
  `agama_ayah` varchar(100) NOT NULL,
  `no_hp_ayah` varchar(100) NOT NULL,
  `nama_ibu` varchar(100) NOT NULL,
  `pend_ibu` varchar(100) NOT NULL,
  `pekerjaan_ibu` varchar(100) NOT NULL,
  `agama_ibu` varchar(100) NOT NULL,
  `no_hp_ibu` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pendaftaran`
--

INSERT INTO `pendaftaran` (`no`, `tgl_daftar`, `nama_siswa`, `jk`, `np`, `tempat_lahir`, `tanggal_lahir`, `alamat`, `agama`, `berat_tinggi`, `nama_ayah`, `pend_ayah`, `pekerjaan_ayah`, `agama_ayah`, `no_hp_ayah`, `nama_ibu`, `pend_ibu`, `pekerjaan_ibu`, `agama_ibu`, `no_hp_ibu`) VALUES
(1, '2021-06-03', 'Bagus', 'Laki-Laki', 23454, 'Depok', '2021-06-03', 'citayem', 'Islam', '80/80', 'Riyanto', 'D2', 'Wirausaha', 'Islam', '081-999-463-324', 'Dahlia', 'S2', 'Buruh', 'Islam', '081-523-567-134'),
(3, '2021-06-19', 'Ayu', 'Perempuan', 22343, 'Depok', '2014-06-19', 'jatijajar', 'islam', '60/65', 'abi', 'PILIH', 'PNS/POLRI/TNI', 'Islam', '0875754364', 'Umi', 'D3', 'Pesiunan', 'Islam', '0864645436'),
(4, '2021-03-29', ' Gibran Damar Rachyanto  ', 'Laki-Laki', 258, 'Depok', '2016-08-15', 'Depok', 'Islam', '20/70', '-', 'PILIH', 'PILIH', '-', '-', 'Andam Dewi', 'PILIH', 'PILIH', 'Islam', '08'),
(5, '2021-01-14', 'Alesha Khairani Syah', 'Perempuan', 265, 'Depok', '2016-07-04', 'Depok', 'Islam', '-', 'Fitriansyah', 'PILIH', 'PILIH', 'Islam', '08', 'Heni Halil', 'PILIH', 'PILIH', 'Islam', '08'),
(6, '2018-02-02', 'Arzachael Aditya Ramadhan', 'Laki-Laki', 171, 'Depok', '2016-05-16', 'Jl. Kp. Ngencle, Rt. 03 Rw. 12 Kel.  Cilangkap  \nkec. Tapos kota Depok', 'Islam', '-', 'Redha Dwi Putra', 'PILIH', 'PILIH', 'Islam', '08', 'Rini Andriani', 'PILIH', 'PILIH', 'Islam', '08'),
(7, '2020-06-04', 'Ayunda Asaili Jannatin', 'Perempuan', 290, 'Depok', '2015-07-10', 'Kp Nyencle \nRt. 04\nRw. 01\nCilangkap \nTapos \nDepok \n\n', 'Islam', '-', 'Abdullah', 'PILIH', 'PILIH', 'Islam', '08', 'Khayatan Mubarokah', 'PILIH', 'PILIH', 'Islam', '08'),
(8, '2020-06-08', 'Galang Anggara Satria', 'Laki-Laki', 257, 'Depok', '2021-04-14', ' KP Nyencle \n 01 \n 01 \n Cilangkap \n Tapos \n Depok \n', 'Islam', '-', ' Antonius  ', 'S2', 'PNS/POLRI/TNI', 'Islam', '08', ' Devi Anggraeni  ', 'S1', 'PNS/POLRI/TNI', 'Islam', '08'),
(9, '2021-06-02', 'Tara Shofwa Prihandoyo', 'Laki-Laki', 364, 'Depok', '2016-06-14', 'Depok', 'Islam', '-', 'Santosa Arief Prihandoyo', 'PILIH', 'PILIH', 'Islam', '08', ' Dian Armalia  ', 'PILIH', 'PILIH', 'Islam', '08'),
(11, '2021-07-08', 'Riyan', 'Laki-Laki', 312, 'jakarta', '2021-07-14', 'poltangan', 'Islam', '65/170', 'agus', 'SMA Sederajat', 'Karyawan Swasta', 'islam', '086', 'isna', 'SMA Sederajat', 'Tidak Bekerja/Ibu Rumah Tangga', 'islam', '087');

-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE `siswa` (
  `nis` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `tempat_lahir` varchar(50) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `jk` varchar(20) NOT NULL,
  `alamat` text NOT NULL,
  `kelas` varchar(100) NOT NULL,
  `agama` varchar(100) NOT NULL,
  `tahun_ajaran` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `siswa`
--

INSERT INTO `siswa` (`nis`, `nama`, `tempat_lahir`, `tanggal_lahir`, `jk`, `alamat`, `kelas`, `agama`, `tahun_ajaran`) VALUES
(171, 'Arzachael Aditya Ramadhan', 'Depok', '2016-05-16', 'Laki-Laki', 'Jl. Kp. Ngencle, Rt. 03 Rw. 12 Kel.  Cilangkap  \nkec. Tapos kota Depok', 'PDD', 'Islam', '2021'),
(257, 'Galang Anggara Satria', 'Depok', '2021-04-14', 'Laki-Laki', ' KP Nyencle \n 01 \n 01 \n Cilangkap \n Tapos \n Depok \n', 'PDM', 'Islam', '2021'),
(258, ' Gibran Damar Rachyanto  ', 'Depok', '2016-08-15', 'Laki-Laki', 'Depok', 'PDS', 'Islam', '2021'),
(265, 'Alesha Khairani Syah', 'Depok', '2016-07-04', 'Perempuan', 'Depok', 'PDS', 'Islam', '2021'),
(290, 'Ayunda Asaili Jannatin', 'Depok', '2015-07-10', 'Perempuan', 'Kp Nyencle \nRt. 04\nRw. 01\nCilangkap \nTapos \nDepok \n\n', 'PDM', 'Islam', '2021'),
(312, 'Riyan', 'jakarta', '2021-07-14', 'Laki-Laki', 'poltangan swadaya 2h', 'Regular', 'Islam', '2021'),
(364, 'Tara Shofwa Prihandoyo', 'Depok', '2016-06-14', 'Laki-Laki', 'Depok', 'PDS', 'Islam', '2021'),
(22343, 'Ayu', 'Depok', '2014-06-19', 'Perempuan', 'jatijajar', 'Regular', 'islam', '2021');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nama_petugas` varchar(100) NOT NULL,
  `jk` varchar(50) NOT NULL,
  `tempat_lahir` varchar(100) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `alamat` text NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `nama_petugas`, `jk`, `tempat_lahir`, `tgl_lahir`, `alamat`, `username`, `password`) VALUES
(1, 'Riyan', 'Laki-Laki', 'Jakarta', '1998-06-14', 'Pasar Minggu, Poltangan', 'Riyan', 'eca3279ea8114dd5eaeebd5e5ae7ab57'),
(2, 'Riyan Shafar', 'Laki-Laki', 'jakarta', '2020-11-14', 'poltangan', 'Riyan Shafar', 'eca3279ea8114dd5eaeebd5e5ae7ab57'),
(3, 'akbar', 'Laki-Laki', 'Sukabumi', '2020-11-13', 'egaegaegaega', 'akbar', '78496fc40c894178261258a1023a8dfd'),
(4, 'satriawan', 'Laki-Laki', 'jakarta', '2021-04-08', 'aaaaaaa', 'satriawan', '202cb962ac59075b964b07152d234b70'),
(7, 'RRQ', 'Laki-Laki', 'thejak', '2021-06-14', 'gsgasgae', 'RRQ', '827ccb0eea8a706c4c34a16891f84e7b'),
(8, 'ulil', 'Laki-Laki', 'jjj', '2021-06-02', 'wfw', 'ulil', '827ccb0eea8a706c4c34a16891f84e7b'),
(9, 'satriawan', 'Laki-Laki', 'jakarta', '2021-06-20', 'poltangan', 'satriawan', '827ccb0eea8a706c4c34a16891f84e7b'),
(10, 'RiyanShafar', 'Laki-Laki', 'Jakarta', '1998-06-14', 'Poltangan', 'RiyanShafar', 'd41d8cd98f00b204e9800998ecf8427e'),
(11, 'RiyanShafarSatriawan', 'Laki-Laki', 'Jakarta', '1998-06-14', 'Poltangan', 'RiyanShafarSatriawan', '827ccb0eea8a706c4c34a16891f84e7b');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrasi`
--
ALTER TABLE `administrasi`
  ADD PRIMARY KEY (`no_pembayaran`);

--
-- Indexes for table `guru`
--
ALTER TABLE `guru`
  ADD PRIMARY KEY (`nip`);

--
-- Indexes for table `matapelajaran`
--
ALTER TABLE `matapelajaran`
  ADD PRIMARY KEY (`no`);

--
-- Indexes for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  ADD PRIMARY KEY (`no`);

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`nis`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrasi`
--
ALTER TABLE `administrasi`
  MODIFY `no_pembayaran` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `guru`
--
ALTER TABLE `guru`
  MODIFY `nip` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `matapelajaran`
--
ALTER TABLE `matapelajaran`
  MODIFY `no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  MODIFY `no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `siswa`
--
ALTER TABLE `siswa`
  MODIFY `nis` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22344;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
