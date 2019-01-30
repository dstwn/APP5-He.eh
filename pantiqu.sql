-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 30, 2019 at 08:00 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pantiqu`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `kecamatan`
--

CREATE TABLE `kecamatan` (
  `id_kecamatan` int(11) NOT NULL,
  `id_kota` int(11) NOT NULL,
  `nama_kecamatan` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kecamatan`
--

INSERT INTO `kecamatan` (`id_kecamatan`, `id_kota`, `nama_kecamatan`) VALUES
(1, 3, 'Pajangan'),
(2, 4, 'Kokap'),
(3, 3, 'Kasihan'),
(4, 4, 'Samigaluh'),
(5, 2, 'Babarsari'),
(6, 2, 'Karangmalang');

-- --------------------------------------------------------

--
-- Table structure for table `kota`
--

CREATE TABLE `kota` (
  `id_kota` int(11) NOT NULL,
  `nama_kota` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kota`
--

INSERT INTO `kota` (`id_kota`, `nama_kota`) VALUES
(1, 'Kota Yogyakarta'),
(2, 'Sleman'),
(3, 'Bantul'),
(4, 'Kulon Progo'),
(5, 'Gunung Kidul');

-- --------------------------------------------------------

--
-- Table structure for table `panti`
--

CREATE TABLE `panti` (
  `id_panti` int(11) NOT NULL,
  `id_pemilik` int(11) NOT NULL,
  `nama_panti` varchar(100) NOT NULL,
  `info` text NOT NULL,
  `jml_penghuni` int(11) NOT NULL,
  `kota` varchar(100) NOT NULL,
  `kecamatan` varchar(100) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `foto` varchar(100) NOT NULL,
  `status` varchar(30) NOT NULL DEFAULT 'pending'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `panti`
--

INSERT INTO `panti` (`id_panti`, `id_pemilik`, `nama_panti`, `info`, `jml_penghuni`, `kota`, `kecamatan`, `alamat`, `foto`, `status`) VALUES
(1, 1, 'Panti Asuhan Sabilul Huda', 'Visi dan Misi Sabilulhuda dan Yayasan Bangkit Sejahtera\r\nVisi Yayasan Bangkit Sejahtera\r\n\r\nMembangun peradaban kaum dhuafa yang berpegang teguh pada nilai-nilai ketuhanan dan menjunjung tinggi harkat kemanusiaan, kepedulian, tolong menolong, saling menghargai serta menjaga kelestarian alam untuk mencapai kesejahteraan hidup dunia akhirat.\r\n\r\nMisi Yayasan Bangkit Sejahtera\r\n\r\nPencerdasan kehidupan kaum dhuafa melalui lembaga pendidikan gratis yang modern, proffesional dan islami yang dikelola secara transparan serta tidak berorientasi pada keuntungan bisnis pendidikan.\r\nMenanamkan jiwa dan semangat berwira usaha dikalangan kaum dhuafa melalui pembangunan WORKSHOP sebagai media pelatihan, pendampingan dan inkubasi bisnis bagi kaum dhuafa\r\nMembangkitkan kesadaran hidup sehat ditengah kaum dhuafa melalui penyuluhan dan pendirian lembaga kesehatan dengan manajemen modern professional dan transparan dengan pembiayaan dari perusahaan rekanan yayasan.\r\nMemasyarakatkan prinsip kemandirian, integritas dan kepribadian yang berkualitas menuju kebangkitan kaum dhuafa dalam menyonsong era persaingan bebas dan globalisasi\r\n \r\n\r\nVisi Sabilulhuda\r\n\r\nSabilulhuda ber-azzam mewujudkan sebuah generasi Islam seperti yang digambarkan di Al Qur’an.\r\n\r\n“Kamu adalah umat yang terbaik yang dilahirkan untuk manusia, menyuruh kepada yang ma’ruf, dan mencegah dari yang munkar, dan beriman kepada Allah” (QS Ali Imran 3 : 110)\r\n\r\nInilah karakter dan perilaku generasi Islam yang hendak diwujudkan melalui amal gerak Sabilul Huda\r\n\r\nMisi Sabilulhuda\r\n\r\n1. Untuk mewujudkan generasi umat terbaik, maka Sabilulhuda mendidik melalui Pondok Pesantren Sabilulhuda dengan tuntunan Syariat Islam dan ber-uswah kepada Rasulullah.\r\n“Katakanlah (Muhammad) : “Jika kamu (benar-benar) mencintai Allah, ikutilah aku, niscaya Allah mengasihi dan mengampuni dosa-dosamu.” Allah Maha Pengampun lagi Maha Penyayang”    (Ali Imran 3 : 31)\r\n\r\n2. Ada segolongan Umat Islam yang selalu saja terpinggirkan, terlalaikan haknya untuk menjadi umat terbaik Islam.\r\nSabilulhuda Al Islam bermaksud memberikan kesempatan kepada saudara fakir miskin dan yatim untuk menjadi bagian dari generasi umat terbaik, dengan program penanggungan biaya belajar di pondok pesantren dan di sekolah formal serta biaya hidup mereka melalui Panti Asuhan Sabilulhuda\r\n“Sembahlah Allah dan janganlah kamu mempersekutukan-Nya dengan sesuatupun. Dan berbuat baiklah kepada dua orang ibu-bapa, karib-kerabat, anak-anak yatim, orang-orang miskin, tetangga yang dekat dan tetangga yang jauh, dan teman sejawat, ibnu sabil dan hamba sahayamu. Sesungguhnya Allah tidak menyukai orang-orang yang sombong dan membangga-banggakan diri”   (An Nisaa’ 4 : 36)\r\n\r\n', 100, 'Sleman', 'Pakem', 'Jl. Kaliurang km.17, No. 64 RT/RW 46 belakang toserba WS, Sukunan, Pakembinangun', '', 'pending'),
(2, 2, 'Panti Asuhan Al Hakim Sinar Melati Yogyakarta', 'Panti Asuhan Al Hakim Sinar Melati  Sleman Yogyakarta sendiri berdiri pada akhir tahun 1999. Berdirinya Panti Asuhan ini saat kunjungan yang dilakukan oleh pengasuh ke sebuah Panti Asuhan. Saat itu beliau terinspirasi dan berniat untuk mendirikan sebuah Panti Asuhan dengan metode pengasuhan yang sesuai dengan syariat agama Islam. Beliau bekerja pada Departemen Agama Provinsi DIY, dengan jabatan  bagian kepengurusan  Haji, Zakat dan Wakaf. Beliau adalah Bapak Drs. H. Sigit Warsito M.A. kemudian istri beliau yang Dra. Hj. Ibu Juni Setya Suryawati menjadi salah satu pengasuh dan menjabat sebagai Kepala TK IT Sinar Melati yang berada dibawah yayasan Sinar Melati pula. Beliau-beliaulah yang selama ini berjuang untuk kelangsungan hidup dan kebutuhan hidup anak-anak yang tinggal di Panti Asuhan Al Hakim.\r\n\r\nDengan memiliki visi “Berani Hidup Berakhlaq Mulai” kami ingin anak-anak bersekolah di dalam lingkungan Panti Asuahan. Dan semoga Allah memudahkan, kami berencana segera membuka MTs Al Hakim. Untuk gedung santri laki-laki terpisah dari gedung santri perempuan. Jadi masing-masing mempunyai fasilitas sendiri-sendiri.\r\n\r\nPengalaman dan perjuangan kami mengurus Panti Asuhan Al Hakim Sinar Melati  Sleman Yogyakarta ini sejak tahun 1999 cukup mendapatkan banyak perkembangan dan kemajuan yang didapatkan bila dibandingkan saat baru didirikan. Saat ini Panti Asuhan Al Hakim Sinar Melati  Sleman Yogyakarta sudah mempunyai gedung sendiri yang permanen dan berbadan hukum.', 80, 'Sleman', 'Depok', 'Jalan Wijaya Kusuma Gang Arjuno, RT. 01/14, Condongcatur', '', 'pending'),
(3, 3, 'Panti Asuhan Darun Najah', 'PANTI ASUHAN DENGAN KURIKULUM PESANTREN\r\nPanti asuhan Darun Najah adalah lembaga nirlaba dengan fokus membantu anak Yatim/dhuafa untuk terus bersekolah serta membekali santri dengan kurikulum pondok pesantren serta program Tahfidzul', 100, 'Sleman', 'Depok', 'Santan gang dua no 19 , Maguwoharjo', '', 'pending'),
(4, 4, 'Panti Asuhan Nurul Yasmin', '\" Panti Asuhan Putri Nurul Yasmin mempunyai tujuan umum dan tujuan khusus \"\r\nTujuan umum:\r\n\r\nMemberikan makna \"keluarga\" kepada anak-anak yatim, piatu, terlantar dan juga anak-anak yang kurang mampu dengan memberikan pendidikan, perlindungan, kasih sayang dan penghidupan yang layak.\r\n\r\nTujuan khusus:\r\n\r\nSebagai wujud pengalaman Al Qur\'an dan penghambaan kepada Allah.\r\nIkut serta membangun kehidupan nasional dan pengalaman Pancasila serta UUD 1945.\r\nMemberikan pendidikan keterampilan kepada anak asuh sehingga siap terjun ke masyarakat sebagai generasi muda yang tangguh dan siap menghadapi tantangan.\r\nMemberikan pengetahuan dan pendidikan agama kepada anak asuh sebagai fondasi kehidupanya sebagai makhluk Allah sekaligus sebagai makhluk sosial, sehingga mampu menjadi manusia yang selalu berbuat baik, jujur, adil, rendah hati dan meletakan kebenaran diatas segala-galanya.\r\nMembentuk pribadi muslimah yang berbudi pekerti, sopan, santun dan andap asor.', 30, 'Sleman', 'Ngaglik', 'Wonosalam, Sukoharjo', '', 'pending'),
(5, 5, 'Panti Asuhan La Tahzan', 'VISI :\r\nTERWUJUDNYA GENERASI QUR\'ANI YANG BERAKHLAQUL KARIMAH, CERDAS, TERAMPIL, \r\nMANDIRI, DAN BERJIWA INTERPRENEURSIP.', 30, 'Bantul', 'Banguntapan', 'Gg. Irawan No.21, Pringgolayan', '', 'pending'),
(6, 6, 'Panti Asuhan Nur Fadhilah', 'Lembaga Kesejateraan Sosial Anak (LKSA) Nur Fadhiilah merupakan suatu lembaga yang menyelenggarakan kegiatan pengasuhan anak. LKSA Nur Fadhiilah berdiri pada tahun 2001 oleh Bapak H. Pitoyo Waluyo (alm) di Dusun Pringgolayan Banguntapan Bantul Yogyakarta. Lembaga ini berdiri karena terdorong oleh ajaran yang diamalkan oleh Rasulullah SAW: “Sebaik-baik manusia adalah yang paling banyak manfaat untuk orang lain”, dasar itulah yang menjadi motivasi pendiri untuk mendirikan sebuah lembaga yang akan bermanfaat dan berguna bagi orang lain.\r\n\r\nDengan berdirinya Nur Fadhiilah diharapkan tidak ada lagi anak-anak yang tidak mendapatkan kehidupan dan pendidikan yang layak, maka dari itu kami ada untuk mereka yang membutuhkan. Kami siap untuk membantu anak-anak yang menginginkan kehidupan dan pendidikan yang lebih baik agar kelak mereka bisa menjadi lebih baik dari sebelumnya dan juga akan berguna dengan orang-orang disekitar mereka.\r\n\r\nSelain itu, kami juga menerima bantuan dari para donatur agar LKSA Nur Fadhiilah dapat terus beroperasi dan siap mengemban amanah yang Bapak/Ibu berikan kepada kami. Bantuan berupa uang tunai, barang dan kebutuhan harian bisa Anda salurkan langsung ke LKSA Nur Fadhiilah. Kami sangat berterima kasih kepada Bapak/Ibu yang telah bersedia memberikan sedikit rejeki yang diberikan oleh Allah SWT kepada kami, semoga dengan adanya bantuan dari Bapak/Ibu bisa menjadi amal jariyah Bapak/Ibu dan bermanfaat bagi anak-anak LKSA Nur Fadhiilah. Insya Allah bantuan yang telah Bapak/Ibu berikan akan mendapatkan amal dan pahala yang berlimpah dari Allah SWT.', 19, 'Bantul', 'Banguntapan', ' Gg. Irawan No.21, Pringgolayan', '', 'pending'),
(7, 7, 'Panti Asuhan Nailunnajah', 'INFORMASI LEBIH LANJUT HUBUNGI :\r\n087738809004\r\n\r\n085200861122\r\n\r\nAlamat : Jalan Piyungan Prambanan KM.01 Munggur, Srimartani, Piyungan Bantul DIY.\r\n\r\n(dari Kantor desa srimartani maju 200 meter ke arah Kota Bantul kanan jalan)\r\n(dari MTs Hasyim Asyari maju 50 meter ke arah prambanan kiri jalan)', 30, 'Bantul', 'Piyungan', 'Jalan Piyungan Prambanan KM.01 Munggur, Srimartani', '', 'pending'),
(8, 8, 'Panti Asuhan Yatim Jamasaba', 'PANTI ASUHAN YATIM “JAMASBA“\r\n\r\nJl KH Agus salim No 97 A Bantul 55711 Yogyakarta. Telp (0274) 368006 email : pay.jamasba@gmail.com\r\n\r\n\r\nA. SEJARAH BERDIRI\r\n\r\nPanti Asuhan Yatim (PAY) JAMASBA yang beralamat di Jalan KH Agus Salim No. 97 Bantul Yogyakarta 55711 Telepon (0274)368006, didirikan pada tanggal 15 April 1973 Masehi, bertepatan dengan tanggal 12 Rabiul Awal (Maulud) 1393 Hijriyah.\r\n\r\n\r\nPAY JAMASBA berdiri di atas tanah magersari keraton Ngayojokarto Hadiningrat seluas 3596 m2, dan atas prakarsa KH. Mathori Al Huda, sesepuh JAMASBA yang dilaksanakan oleh para pendiri yang terdiri dari M.Daldiri, M. Irsyad, H.Danuri Dalhar, M. Zainuddin BA, H.Djalaludin BA, H. Qomaruzzaman BA, M.Djamhari B.Sc., M.Baidlowi BA serta mendapat dukungan sepenuhnya dari kaum muslimin di kota Bantul dan sekitarnya, maka pada tanggal 15 April 1973 diresmikanlah berdirinya Panti Asuhan Yatim (PAY) Jamasba Bantul.\r\n\r\nSaat pertama kali berdiri pada tahun 1973, anak yatim diasuh oleh PAY JAMASBA berjumlah 4 orang. Sesuai dengan kemajuan yang dicapai karena adanya dukungan dari kaum muslimin di kota Bantul dan sekitarnya, maka pada akhir tahun 1974 anak yang diasuh meningkat menjadi 6 anak. Anak-anak tersebut diasramakan di rumah Bapak H Danuri Dalhar (Muka Masjid Jamasba) dengan bapak asuh Bapak Drs Tuwuh Margono. Rata-rata pendidikan anak asuh adalah sekolah dasar.\r\n\r\nDi sebelah utara masjid JAMASBA, diatas tanah kagungan ndalem kraton Ngayogyakarta Hadiningrat, pada tahun 1978 PAY JAMASBA mampu mendirikan gedung asrama / Panti seluas 8X12 m2, dengan bangunan menunjang seluas 12X4 m2, sehingga anak yatim yang diasuh saat itu berjumlah 10 anak yang berpendidikan antara Sekolah Dasar sampai Sekolah Menengah Pertama dengan bapak asuh saudara Ngadikan, pegawai Kandepag Bantul.\r\n\r\nAnak-anak yatim di wilayah Kabupaten Bantul sangat banyak, sedangkan kemampuan asrama sangat terbatas, padahal keinginan orang tua/ibu mereka sangat besar untuk mengirimkan putera-puterinya ke PAY JAMASBA. Untuk mengatasi hal tersebut, maka pada tahun 1982, pengurus PAY JAMASBA mengambil kebijakan diantaranya memberikan santunan secara penuh (asrama, makan minum, pakaian, biaya sekolah, kesehatan, dll) bagi 10 anak yang berada di panti dan memberikan santunan tidak penuh (hanya biaya sekolah, kadang-kadang juga lainnya) bagi anak-anak yatim yang berada diluar asrama yang telah terdaftar sebagai anak asuh PAY JAMASBA.', 64, 'Bantul', 'Kurahan', 'Kurahan, Bantul, Bantul Sub-District, Bantul Regency, Special Region of Yogyakarta 55712', '', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `pemilik_panti`
--

CREATE TABLE `pemilik_panti` (
  `id_pemilik` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nama_pemilik` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `no_hp` bigint(20) NOT NULL,
  `no_rekening` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pemilik_panti`
--

INSERT INTO `pemilik_panti` (`id_pemilik`, `username`, `password`, `nama_pemilik`, `email`, `no_hp`, `no_rekening`) VALUES
(1, 'user1', 'password', 'Ust. Prawoto Agung Wiryawan, S.Si. Apt', 'prawoto@mail.com', 256423987, 32242),
(2, 'user2', 'password', 'Drs. H. Sigit Warsito. M.A ', 'warsito@mail.com', 8562631631, 51823),
(3, 'user3', 'password', 'Anggit Nurstyo prabowo', 'anggit@email.com', 8157959229, 306601002130509),
(4, 'user4', 'password', 'Dra. Giyanti', 'giyanti@email.com', 86423424324, 302201),
(5, 'user5', 'password', 'Andri Efriadi', 'andri@mail.com', 82325358785, 123124),
(6, 'user6', 'password', 'NUr Fadilah', 'nurfadilah@mail.com', 81234567875, 23542),
(7, 'user7', 'password', 'Nailunnajah', 'nailunnajah@mail.com', 87654674653, 87653),
(8, 'user8', 'password', 'H. Danuri Dalhar', 'danuri@mail.com', 85435765456, 87652);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `kecamatan`
--
ALTER TABLE `kecamatan`
  ADD PRIMARY KEY (`id_kecamatan`),
  ADD KEY `id_kota` (`id_kota`);

--
-- Indexes for table `kota`
--
ALTER TABLE `kota`
  ADD PRIMARY KEY (`id_kota`);

--
-- Indexes for table `panti`
--
ALTER TABLE `panti`
  ADD PRIMARY KEY (`id_panti`),
  ADD KEY `id_pemilik` (`id_pemilik`);

--
-- Indexes for table `pemilik_panti`
--
ALTER TABLE `pemilik_panti`
  ADD PRIMARY KEY (`id_pemilik`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kecamatan`
--
ALTER TABLE `kecamatan`
  MODIFY `id_kecamatan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `kota`
--
ALTER TABLE `kota`
  MODIFY `id_kota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `panti`
--
ALTER TABLE `panti`
  MODIFY `id_panti` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `pemilik_panti`
--
ALTER TABLE `pemilik_panti`
  MODIFY `id_pemilik` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kecamatan`
--
ALTER TABLE `kecamatan`
  ADD CONSTRAINT `kecamatan_ibfk_1` FOREIGN KEY (`id_kota`) REFERENCES `kota` (`id_kota`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `panti`
--
ALTER TABLE `panti`
  ADD CONSTRAINT `panti_ibfk_1` FOREIGN KEY (`id_pemilik`) REFERENCES `pemilik_panti` (`id_pemilik`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
