-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 26, 2022 at 08:35 PM
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

--
-- Dumping data for table `ad_details`
--

INSERT INTO `ad_details` (`id`, `article_num`, `ad_added`, `ad_last_updated`, `time_until_expire`, `ad_shown`) VALUES
(1, '0', '2022-04-26 19:32:16', '2022-04-26 19:32:16', '0', '0');

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
(1, '0', '0', 'root');

-- --------------------------------------------------------

--
-- Table structure for table `article_advanced_details`
--

CREATE TABLE `article_advanced_details` (
  `id` int(11) NOT NULL,
  `article_num` varchar(20) COLLATE utf8_croatian_ci NOT NULL,
  `description1` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL CHECK (json_valid(`description1`)),
  `description2` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL CHECK (json_valid(`description2`))
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

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
(1, '0', 1, '0.00', '0', 1, 1);

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
(3, 'Cars'),
(1, 'Nothing'),
(2, 'Shoes');

-- --------------------------------------------------------

--
-- Table structure for table `flyway_schema_history`
--

CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `flyway_schema_history`
--

INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1, '1', 'init', 'SQL', 'V1__init.sql', 0, 'root', '2022-07-25 18:51:22', 5, 1),
(2, '1.1', 'create tables', 'SQL', 'V1.1__create_tables.sql', 1250230540, 'root', '2022-07-25 18:51:24', 1725, 1),
(3, '1.2', 'article type data', 'SQL', 'V1.2__article_type_data.sql', -1634923675, 'root', '2022-07-25 18:51:24', 8, 1),
(4, '1.3', 'seller data', 'SQL', 'V1.3__seller_data.sql', -169531880, 'root', '2022-07-25 18:51:24', 5, 1),
(5, '1.4', 'articles data', 'SQL', 'V1.4__articles_data.sql', 692060780, 'root', '2022-07-25 18:51:24', 6, 1),
(6, '1.5', 'initial data', 'SQL', 'V1.5__initial_data.sql', 258302243, 'root', '2022-07-25 18:51:24', 12, 1);

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
(1, 'admin', 'admin', '2022-04-26', '0', 'root', '0', 'root@localhost.phpmyadmin', '$2y$10$ZS/hh5SAFlkWb5wojf7Oku/GVXlEeUgv4hOg2rtVmvyPAjtvZR2iK');

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

--
-- Dumping data for table `shipping_details`
--

INSERT INTO `shipping_details` (`id`, `article_number`, `shipping`, `comment`, `location`, `delivery`, `returns`, `payments`) VALUES
(1, '0', '0', '0', '0', '0', '0', '0');

-- --------------------------------------------------------

--
-- Table structure for table `storage_system`
--

CREATE TABLE `storage_system` (
  `id` int(11) NOT NULL,
  `nickname` varchar(50) COLLATE utf8_croatian_ci NOT NULL,
  `article_number` varchar(20) COLLATE utf8_croatian_ci NOT NULL,
  `user_folder` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `article_folder` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `file_name` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `file_extension` varchar(50) COLLATE utf8_croatian_ci NOT NULL,
  `local_path` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL
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
-- Indexes for table `article_advanced_details`
--
ALTER TABLE `article_advanced_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `article_num` (`article_num`);

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
-- Indexes for table `flyway_schema_history`
--
ALTER TABLE `flyway_schema_history`
  ADD PRIMARY KEY (`installed_rank`),
  ADD KEY `flyway_schema_history_s_idx` (`success`);

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
-- Indexes for table `storage_system`
--
ALTER TABLE `storage_system`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nickname` (`nickname`),
  ADD KEY `article_number` (`article_number`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ad_details`
--
ALTER TABLE `ad_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `articles`
--
ALTER TABLE `articles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `article_advanced_details`
--
ALTER TABLE `article_advanced_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `article_basic_details`
--
ALTER TABLE `article_basic_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `article_types`
--
ALTER TABLE `article_types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `sellers`
--
ALTER TABLE `sellers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `shipping_details`
--
ALTER TABLE `shipping_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `storage_system`
--
ALTER TABLE `storage_system`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

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
-- Constraints for table `article_advanced_details`
--
ALTER TABLE `article_advanced_details`
  ADD CONSTRAINT `artnum` FOREIGN KEY (`article_num`) REFERENCES `articles` (`article_number`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `article_basic_details`
--
ALTER TABLE `article_basic_details`
  ADD CONSTRAINT `article_id_fk` FOREIGN KEY (`ar_num`) REFERENCES `articles` (`article_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `article_type_fk` FOREIGN KEY (`type_id`) REFERENCES `article_types` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `type_id_2_fk` FOREIGN KEY (`type_id_2`) REFERENCES `article_types` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `type_id_3_fk` FOREIGN KEY (`type_id_3`) REFERENCES `article_types` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `shipping_details`
--
ALTER TABLE `shipping_details`
  ADD CONSTRAINT `art_num_fk` FOREIGN KEY (`article_number`) REFERENCES `articles` (`article_number`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `storage_system`
--
ALTER TABLE `storage_system`
  ADD CONSTRAINT `article_nm` FOREIGN KEY (`article_number`) REFERENCES `articles` (`article_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nickname_fk` FOREIGN KEY (`nickname`) REFERENCES `sellers` (`nickname`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
