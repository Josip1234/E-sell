-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 05, 2022 at 03:03 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `esell`
--

-- --------------------------------------------------------

--
-- Table structure for table `ad_details`
--

CREATE TABLE `ad_details` (
  `id` int(11) NOT NULL,
  `article_num` varchar(20) COLLATE utf8_croatian_ci NOT NULL,
  `ad_added` datetime NOT NULL,
  `ad_last_updated` datetime NOT NULL,
  `time_until_expire` varchar(100) COLLATE utf8_croatian_ci DEFAULT NULL,
  `ad_shown` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE `articles` (
  `id` int(11) NOT NULL,
  `article_number` varchar(20) COLLATE utf8_croatian_ci NOT NULL,
  `article_name` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `seller` varchar(50) COLLATE utf8_croatian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`id`, `article_number`, `article_name`, `seller`) VALUES
(7, '144', 'dhrthrhrth', 'joka'),
(8, 'vnioeghniegjoijjno', 'Prijenosni Hard Disk', 'joka'),
(9, 'hgsrthserhsdhtsrht', 'hrtrthrfshdghtrhr', 'joka414541'),
(10, '36124969', '\r\nHilfiger čizme 39/40', 'jobo'),
(11, '789456120', 'Cd Edo Maajka - Mater', 'mrasica@gmail.com'),
(12, 'ndhnd', 'nnrnfnd', 'Jobo123456'),
(14, '294771966105', 'Custom Nike Air Force 1 Black & Gold (MENS)', 'primoblack');

-- --------------------------------------------------------

--
-- Table structure for table `article_basic_details`
--

CREATE TABLE `article_basic_details` (
  `id` int(11) NOT NULL,
  `ar_num` varchar(20) COLLATE utf8_croatian_ci NOT NULL,
  `type_id` int(11) NOT NULL,
  `price` varchar(50) COLLATE utf8_croatian_ci NOT NULL,
  `article_condition` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `type_id_2` int(11) DEFAULT NULL,
  `type_id_3` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

--
-- Dumping data for table `article_basic_details`
--

INSERT INTO `article_basic_details` (`id`, `ar_num`, `type_id`, `price`, `article_condition`, `type_id_2`, `type_id_3`) VALUES
(4, '36124969', 1, '550 kn ~ 74 €', NULL, NULL, NULL),
(5, '144', 3, 'C $3.42', NULL, NULL, NULL),
(6, 'hgsrthserhsdhtsrht', 1, 'C $12.56', NULL, NULL, NULL),
(8, 'vnioeghniegjoijjno', 2, 'US $29.50', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `article_types`
--

CREATE TABLE `article_types` (
  `id` int(11) NOT NULL,
  `type` varchar(255) COLLATE utf8_croatian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci COMMENT='will be used by other table to get  type of products';

--
-- Dumping data for table `article_types`
--

INSERT INTO `article_types` (`id`, `type`) VALUES
(3, 'Elektronika'),
(8, 'fdsssddvs'),
(4, 'fhetrtjhtejjrjfgz'),
(2, 'gdgdh'),
(5, 'i67rti7it7i6rt'),
(10, 'Men\'s Shoes'),
(1, 'Novi tip produkta'),
(9, 'Shoes');

-- --------------------------------------------------------

--
-- Table structure for table `car_detail`
--

CREATE TABLE `car_detail` (
  `id` int(11) NOT NULL,
  `article_number` varchar(20) COLLATE utf8_croatian_ci NOT NULL,
  `brand` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `model` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `year` year(4) NOT NULL,
  `car_condition` text COLLATE utf8_croatian_ci NOT NULL,
  `serialnumber` longtext COLLATE utf8_croatian_ci NOT NULL,
  `mileage` longtext COLLATE utf8_croatian_ci NOT NULL,
  `mpg` text COLLATE utf8_croatian_ci NOT NULL,
  `color` text COLLATE utf8_croatian_ci NOT NULL,
  `engine` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `drivetrain` varchar(10) COLLATE utf8_croatian_ci NOT NULL,
  `basic_equipment` text COLLATE utf8_croatian_ci NOT NULL,
  `additional_equipment` text COLLATE utf8_croatian_ci DEFAULT NULL,
  `car_history` text COLLATE utf8_croatian_ci DEFAULT NULL,
  `additional` text COLLATE utf8_croatian_ci DEFAULT NULL,
  `car_type` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  `fuel_type` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  `max_speed` varchar(10) COLLATE utf8_croatian_ci DEFAULT NULL,
  `gearbox_type` varchar(255) COLLATE utf8_croatian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sellers`
--

CREATE TABLE `sellers` (
  `id` int(11) NOT NULL,
  `fname` varchar(50) COLLATE utf8_croatian_ci NOT NULL,
  `lname` varchar(50) COLLATE utf8_croatian_ci NOT NULL,
  `dateofbirth` date NOT NULL,
  `location` text COLLATE utf8_croatian_ci NOT NULL,
  `nickname` varchar(50) COLLATE utf8_croatian_ci NOT NULL,
  `contact` varchar(150) COLLATE utf8_croatian_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_croatian_ci NOT NULL,
  `hash_password` longtext COLLATE utf8_croatian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

--
-- Dumping data for table `sellers`
--

INSERT INTO `sellers` (`id`, `fname`, `lname`, `dateofbirth`, `location`, `nickname`, `contact`, `email`, `hash_password`) VALUES
(1, 'Josip', 'Bošnjak', '1992-11-05', 'Sveti rok 81 34000 Požega', 'jobo', 'Phone: +91 9759754 email: jbosnjak3@]mail.com', 'jbosnjak3@gmail.com', '$2a$10$I0uQSC9yNQ5K805hCGzfMu7sbF26AStJJIO3CBIjb.uDoo/yAuBmK'),
(2, 'Josipa', 'Bošnjak', '1992-11-05', 'Požega', 'joka', 'egergegr', 'joka@joka.com', '$2a$10$9FGLOrBt1tiYg1KWEz6JoOLyipXcPomTIfANgUnWlswGoDsugg9IK'),
(3, 'Josip', 'Josip', '1995-05-05', 'Josip', 'jopa', 'josip', 'jopa@gmail.com', '$2a$10$NAw/DgAS6SOjVkuUA7hy..CnqGXF98XPZwnjbVTZSzF00jpF241Pi'),
(6, 'Josip', 'Bošnjak', '1992-11-05', 'Požega, Sveti rok 81, 34000 Požega, Republika Hrvatska, Europska unija', 'Jobo123', 'Email: jbosnjak3@gmail.com Kućni telefon: 034-292-229 Mobitel: 0919759754', 'jbosnjak33@gmail.com', '$2a$10$QlvV7KSL9dI4Eo6aMTIwseajBUtmINOXIAtXp58JntpPdChDc7JlK'),
(8, 'Josip', 'Bošnjak', '1992-11-05', 'Požega, Sveti rok 81, 34000 Požega, Republika Hrvatska, Europska unija', 'ggegedg', 'Email: jbosnjak3@gmail.com Kućni telefon: 034-292-229 Mobitel: 0919759754', 'jbosnjak344@gmail.com', '$2a$10$ENFwOyVUkM0n99hyZ9c5teL8C4H1WV2Xy94e1fIZmDcGGpAyLvW9a'),
(10, 'Josip', 'Bošnjak', '1992-11-05', 'drgrghtr', 'ggegedga', 'Email: jbosnjak3@gmail.com Kućni telefon: 034-292-229 Mobitel: 0919759754', 'jbosnjak3445@gmail.com', '$2a$10$Gou2kgfKKE0JIEF.RQD3hOSKydbrQK.2Mub27665zjrTLavzPFAUS'),
(11, 'Josip', 'Bošnjak', '1981-12-02', 'Požega, Sveti rok 81, 34000 Požega, Republika Hrvatska, Europska unija', 'joka414541', 'Email: jbosnjak35@gmail.com Kućni telefon: 034-292-229 Mobitel: 0919759754', 'jbosnjak35@gmail.com', '$2a$10$awRHKTo3GENjwufRHMdc/OzL4FDH4oqxx2Bs0vmJgwcMwa/R7VNK.'),
(12, 'Marko', 'Rašica', '1985-09-30', 'Zagreb ', 'mrasica@gmail.com', 'E-mail: mrasica@gmail.com', 'mrasica@gmail.com', '$2a$10$ZoqdRonZYIXecKaDwr95qucHwuGv/JAUhYML08ECDaXxe.k3beRim'),
(13, 'Pavle', 'Šesti', '1955-05-05', 'London', 'pthesixst', 'Email: jbosnjak3@gmail.com Kućni telefon: 034-292-229 Mobitel: 0919759754', 'pthesixst@gmail.com', '$2a$10$1z4Ood2Da55ndOIf2XGryeIdq/QRbedn8CCWuMTfOlKsSreIG.w.W'),
(15, 'Josip', 'Bošnjak', '1992-11-05', 'Po', 'Jobo123456', 'jbosnjak333@gmail.com,Kućni telefon: 034-292-229 Mobitel: 0919759754', 'jbosnjak333@gmail.com', '$2a$10$cUDrxwBaJY1eUmZy4ZIjSOVhCL9Sfcu.KzbECrjV4sx9ht60C5tIu'),
(16, 'Primo', 'Black', '1989-03-05', 'Columbus, Ohio, United States', 'primoblack', 'Email: primoblack@gmail.com, Second email: primoblack12@gmail.com', 'primoblack@gmail.com', '$2a$10$ap7MDspN9ubvrPYTUAy9leCJMlcPoRdbc2SJ7VOwhEO3q2ZlYkLtG');

-- --------------------------------------------------------

--
-- Table structure for table `shipping_details`
--

CREATE TABLE `shipping_details` (
  `id` int(11) NOT NULL,
  `article_number` varchar(20) COLLATE utf8_croatian_ci NOT NULL,
  `shipping` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `comment` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  `location` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `delivery` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  `returns` varchar(100) COLLATE utf8_croatian_ci DEFAULT NULL,
  `payments` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `shoe_details`
--

CREATE TABLE `shoe_details` (
  `id` int(11) NOT NULL,
  `article_number` varchar(20) COLLATE utf8_croatian_ci NOT NULL,
  `Shoe_condition` text COLLATE utf8_croatian_ci NOT NULL,
  `Theme` varchar(20) COLLATE utf8_croatian_ci DEFAULT NULL,
  `Pattern` varchar(20) COLLATE utf8_croatian_ci DEFAULT NULL,
  `Customized` tinyint(1) DEFAULT NULL,
  `Color` varchar(20) COLLATE utf8_croatian_ci NOT NULL,
  `Upper Material` varchar(20) COLLATE utf8_croatian_ci NOT NULL,
  `Vintage` tinyint(1) DEFAULT NULL,
  `Insole Material` varchar(20) COLLATE utf8_croatian_ci DEFAULT NULL,
  `Occasion` text COLLATE utf8_croatian_ci DEFAULT NULL,
  `Brand` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `Shoe size` varchar(100) COLLATE utf8_croatian_ci NOT NULL,
  `Lining Material` varchar(30) COLLATE utf8_croatian_ci DEFAULT NULL,
  `Shoe_character` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `Accents` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `Model` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `Toe Shape` varchar(20) COLLATE utf8_croatian_ci DEFAULT NULL,
  `Department` varchar(20) COLLATE utf8_croatian_ci DEFAULT NULL,
  `Style` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `Heel Style` varchar(30) COLLATE utf8_croatian_ci DEFAULT NULL,
  `Shoe Shaft Style` varchar(30) COLLATE utf8_croatian_ci DEFAULT NULL,
  `Season` varchar(100) COLLATE utf8_croatian_ci DEFAULT NULL,
  `Outsole Material` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `Heel Height` varchar(30) COLLATE utf8_croatian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ad_details`
--
ALTER TABLE `ad_details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `article_num` (`article_num`);

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `article_number` (`article_number`),
  ADD KEY `seller` (`seller`),
  ADD KEY `seller_2` (`seller`);

--
-- Indexes for table `article_basic_details`
--
ALTER TABLE `article_basic_details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ar_num` (`ar_num`),
  ADD KEY `type_id` (`type_id`),
  ADD KEY `type_id_2` (`type_id_2`),
  ADD KEY `type_id_3` (`type_id_3`);

--
-- Indexes for table `article_types`
--
ALTER TABLE `article_types`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `type` (`type`);

--
-- Indexes for table `car_detail`
--
ALTER TABLE `car_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `article_number` (`article_number`);

--
-- Indexes for table `sellers`
--
ALTER TABLE `sellers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nickname` (`nickname`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `shipping_details`
--
ALTER TABLE `shipping_details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `article_number` (`article_number`);

--
-- Indexes for table `shoe_details`
--
ALTER TABLE `shoe_details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `article_number` (`article_number`),
  ADD KEY `Shoe_character` (`Shoe_character`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ad_details`
--
ALTER TABLE `ad_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `articles`
--
ALTER TABLE `articles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `article_basic_details`
--
ALTER TABLE `article_basic_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `article_types`
--
ALTER TABLE `article_types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `car_detail`
--
ALTER TABLE `car_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sellers`
--
ALTER TABLE `sellers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `shipping_details`
--
ALTER TABLE `shipping_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `shoe_details`
--
ALTER TABLE `shoe_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ad_details`
--
ALTER TABLE `ad_details`
  ADD CONSTRAINT `article_number_fk` FOREIGN KEY (`article_num`) REFERENCES `articles` (`article_number`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `articles`
--
ALTER TABLE `articles`
  ADD CONSTRAINT `seller_fk` FOREIGN KEY (`seller`) REFERENCES `sellers` (`nickname`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `article_basic_details`
--
ALTER TABLE `article_basic_details`
  ADD CONSTRAINT `article_id_fk` FOREIGN KEY (`ar_num`) REFERENCES `articles` (`article_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `article_type_fk` FOREIGN KEY (`type_id`) REFERENCES `article_types` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `type_id_2_fk` FOREIGN KEY (`type_id_2`) REFERENCES `article_types` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `type_id_3_fk` FOREIGN KEY (`type_id_3`) REFERENCES `article_types` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `car_detail`
--
ALTER TABLE `car_detail`
  ADD CONSTRAINT `an2_fk` FOREIGN KEY (`article_number`) REFERENCES `articles` (`article_number`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `shipping_details`
--
ALTER TABLE `shipping_details`
  ADD CONSTRAINT `art_num_fk` FOREIGN KEY (`article_number`) REFERENCES `articles` (`article_number`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `shoe_details`
--
ALTER TABLE `shoe_details`
  ADD CONSTRAINT `an_fk` FOREIGN KEY (`article_number`) REFERENCES `articles` (`article_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `shoe_character` FOREIGN KEY (`Shoe_character`) REFERENCES `article_types` (`type`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
