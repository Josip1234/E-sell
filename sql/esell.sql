-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 01, 2023 at 03:38 PM
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
(1, '0', '0', 'root'),
(3, 'wfweffwf', 'fwfwfed', 'Jobo'),
(4, '787', 'fewfew', 'Jobo'),
(5, '', 'fwqff', 'Jobo'),
(6, 'fwefwfe', 'wfewf', 'eqfwwrgwgg'),
(17, 'ni', 'htrht', 'wewfew'),
(18, 'grggerg', 'gergegrgre', 'Jobo'),
(21, '45', 'rgegre', 'root'),
(22, 'greg', 'gregregre', 'eqfwwrgwgg'),
(23, 'ehghrhrehreherrhehdr', 'hehrehtehehehrehrhehrhe', 'eqfwwrgwgg'),
(24, 'grergwegw', 'gwgwegwqgegge', 'Jobo'),
(27, 'vidcunt', 'wfwf', 'root'),
(28, 'vikfq', 'fewewww', 'root'),
(29, '4', 'rhhth', 'root'),
(30, '5', 'rhtrht', 'root'),
(31, '6', 'trhrh', 'Jobo'),
(32, '7', 'hrhhrht', 'root'),
(33, '56', 'g', 'root'),
(34, '57', 'gsr', 'eqfwwrgwgg'),
(35, '58', 'egre', 'Jobo'),
(36, '59', 'egre', 'wewfew'),
(37, '60', 'egregg', 'wewfew'),
(38, '61', 'ergege', 'Jobo'),
(39, '62', 'ergeg', 'Jobo'),
(40, '63', 'regegeqgr', 'root'),
(43, '2342432', 'greger', 'eqfwwrgwgg'),
(44, '34243', 'grsgresg', 'Jobo'),
(45, '160523', 'Aston Martin DB9', 'Jobo'),
(46, '79', 'Neki novi artikl', 'Jobo'),
(47, '798', 'Neki novi artikl', 'Jobo'),
(48, '75875875tegteg', 'h', 'Jobo'),
(49, 'rgeeggre', '515', 'Jobo'),
(50, 'rgeeggrehtrh', '515rhth', 'Jobo'),
(51, 'rgeeggrehtrhfjf', '515rhth', 'Jobo'),
(52, 'rgeeggrehtrhfjfgre', '515rhth', 'Jobo'),
(53, '646', '4646456', 'Jobo'),
(54, '646rgeg', '4646456eggr', 'Jobo');

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
(1, '0', 1, '0.00', '0', 1, 1),
(2, '160523', 6, '650000', 'Used', 7, 1),
(3, '79', 3, '16.56', 'Novi', 3, 7),
(6, 'rgeeggre', 3, 'hth', 'trhhtrh', 2, 1),
(16, '646', 6, '45415', 'tjztjjzju', 4, 4),
(17, '646rgeg', 5, 'gegr', 'egrgeg', 2, 7);

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
(6, 'Car'),
(3, 'Cars'),
(5, 'Clothes'),
(4, 'NONE'),
(1, 'Nothing'),
(2, 'Shoes'),
(7, 'Sports car');

-- --------------------------------------------------------

--
-- Table structure for table `flyway_schema_history`
--

CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `description` varchar(200) COLLATE utf8mb4_croatian_ci NOT NULL,
  `type` varchar(20) COLLATE utf8mb4_croatian_ci NOT NULL,
  `script` varchar(1000) COLLATE utf8mb4_croatian_ci NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) COLLATE utf8mb4_croatian_ci NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;

--
-- Dumping data for table `flyway_schema_history`
--

INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1, '1', 'init', 'SQL', 'V1__init.sql', 0, 'root', '2023-03-13 20:51:11', 5, 1),
(2, '1.1', 'create tables', 'SQL', 'V1.1__create_tables.sql', 1250230540, 'root', '2023-03-13 20:51:13', 1599, 1),
(3, '1.2', 'article type data', 'SQL', 'V1.2__article_type_data.sql', -1634923675, 'root', '2023-03-13 20:51:13', 18, 1),
(4, '1.3', 'seller data', 'SQL', 'V1.3__seller_data.sql', -169531880, 'root', '2023-03-13 20:51:13', 8, 1),
(5, '1.4', 'articles data', 'SQL', 'V1.4__articles_data.sql', 692060780, 'root', '2023-03-13 20:51:13', 9, 1),
(6, '1.5', 'initial data', 'SQL', 'V1.5__initial_data.sql', 258302243, 'root', '2023-03-13 20:51:13', 18, 1),
(7, '1.6', 'storage system', 'SQL', 'V1.6__storage_system.sql', 1153835633, 'root', '2023-03-13 20:51:13', 167, 1),
(8, '1.7', 'storage system update', 'SQL', 'V1.7__storage_system_update.sql', 1684770759, 'root', '2023-03-13 20:51:13', 16, 1),
(9, '1.8', 'storage system update', 'SQL', 'V1.8__storage_system_update.sql', 187210854, 'root', '2023-03-13 20:51:14', 15, 1),
(10, '1.9', 'user data', 'SQL', 'V1.9__user_data.sql', -1241114152, 'root', '2023-03-13 20:51:14', 4, 1),
(11, '2.0', 'user authorization', 'SQL', 'V2.0__user_authorization.sql', -135046316, 'root', '2023-03-13 20:51:14', 63, 1),
(12, '2.1', 'update auth', 'SQL', 'V2.1__update_auth.sql', 1034027362, 'root', '2023-03-13 20:51:14', 80, 1),
(13, '2.1.2', 'update user authorization', 'SQL', 'V2.1.2__update_user_authorization.sql', -486428184, 'root', '2023-03-13 20:51:14', 33, 1),
(14, '2.1.3', 'update article type data', 'SQL', 'V2.1.3__update_article_type_data.sql', 1137287535, 'root', '2023-04-01 13:28:02', 11, 1);

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
(1, 'admin', 'admin', '2022-04-26', '0', 'root', '0', 'root@localhost.phpmyadmin', '$2y$10$ZS/hh5SAFlkWb5wojf7Oku/GVXlEeUgv4hOg2rtVmvyPAjtvZR2iK'),
(2, 'Josip', 'Bošnjak', '1992-11-05', 'Sveti rok 81 34000 Požega', 'Jobo', 'jbosnjak3@gmail.com', 'jbosnjak3@gmail.com', '$2a$10$hoaGbnBhBH.ENVSPkU5SC.DYYjhj7PB2uSInyt5.tJBwQWQqcqPsa'),
(3, 'Mgwerg', 'ambo', '2211-02-26', 'gwgwgeggw', 'eqfwwrgwgg', 'wfegeewr@gg.vv', 'jb@gmail.com', '$2a$10$vIACyvX7EIyVj38NRXENpuQT0LT15Cgjh9hetBP09xorhF/e5oMmK'),
(4, 'PAvel', 'MAgreb', '5411-04-05', 'gwegeswgw', 'wewfew', 'fewefrgwe', 'p@gmail.com', '$2a$10$xX32Fjx7f6UwVhMW5LtK0ub20rzczMaVQIyB8/QS1xdnWs3lGdmsa');

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
  `url` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  `type` enum('Logo','Product_picture') COLLATE utf8_croatian_ci NOT NULL,
  `relative_link` varchar(255) COLLATE utf8_croatian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

--
-- Dumping data for table `storage_system`
--

INSERT INTO `storage_system` (`id`, `nickname`, `article_number`, `user_folder`, `article_folder`, `file_name`, `file_extension`, `local_path`, `url`, `type`, `relative_link`) VALUES
(1, 'Jobo', '160523', 'Jobo', '160523', '50px-GT4_MX5_TitleScreen.png', 'png', 'C:\\Users\\Korisnik\\Desktop\\xampp\\htdocs\\E-sell\\app\\spring web\\e-sell\\images\\Jobo\\160523\\50px-GT4_MX5_TitleScreen.png', 'http://localhost:8080/e-sell/en/images/Jobo/160523/50px-GT4_MX5_TitleScreen.png', 'Product_picture', '/images/Jobo/160523/50px-GT4_MX5_TitleScreen.png'),
(2, 'Jobo', '160523', 'Jobo', '160523', '240px-GT4_Chevrolet_Corvette_C6_Coupe_\'04_Banner.png', 'png', 'C:\\Users\\Korisnik\\Desktop\\xampp\\htdocs\\E-sell\\app\\spring web\\e-sell\\images\\Jobo\\160523\\240px-GT4_Chevrolet_Corvette_C6_Coupe_\'04_Banner.png', 'http://localhost:8080/e-sell/en/images/Jobo/160523/240px-GT4_Chevrolet_Corvette_C6_Coupe_\'04_Banner.png', 'Product_picture', '/images/Jobo/160523/240px-GT4_Chevrolet_Corvette_C6_Coupe_\'04_Banner.png'),
(3, 'Jobo', '160523', 'Jobo', '160523', 'AreasIcon.png', 'png', 'C:\\Users\\Korisnik\\Desktop\\xampp\\htdocs\\E-sell\\app\\spring web\\e-sell\\images\\Jobo\\160523\\AreasIcon.png', 'http://localhost:8080/e-sell/en/images/Jobo/160523/AreasIcon.png', 'Product_picture', '/images/Jobo/160523/AreasIcon.png'),
(4, 'Jobo', '79', 'Jobo', '79', 'GT4_350z_35th_05_logo.png', 'png', 'C:\\Users\\Korisnik\\Desktop\\xampp\\htdocs\\E-sell\\app\\spring web\\e-sell\\images\\Jobo\\79\\GT4_350z_35th_05_logo.png', 'http://localhost:8080/e-sell/en/images/Jobo/79/GT4_350z_35th_05_logo.png', 'Product_picture', '/images/Jobo/79/GT4_350z_35th_05_logo.png'),
(5, 'Jobo', 'rgeeggre', 'Jobo', 'rgeeggre', '50px-GT4_MX5_TitleScreen.png', 'png', 'C:\\Users\\Korisnik\\Desktop\\xampp\\htdocs\\E-sell\\app\\spring web\\e-sell\\images\\Jobo\\rgeeggre\\50px-GT4_MX5_TitleScreen.png', 'http://localhost:8080/e-sell/en/images/Jobo/rgeeggre/50px-GT4_MX5_TitleScreen.png', 'Product_picture', '/images/Jobo/rgeeggre/50px-GT4_MX5_TitleScreen.png');

-- --------------------------------------------------------

--
-- Table structure for table `user_authorization`
--

CREATE TABLE `user_authorization` (
  `id` int(11) NOT NULL,
  `user_email` varchar(50) COLLATE utf8_croatian_ci NOT NULL,
  `type_of_user` enum('Admin','Seller') COLLATE utf8_croatian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

--
-- Dumping data for table `user_authorization`
--

INSERT INTO `user_authorization` (`id`, `user_email`, `type_of_user`) VALUES
(1, 'jbosnjak3@gmail.com', 'Seller');

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
-- Indexes for table `user_authorization`
--
ALTER TABLE `user_authorization`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_email` (`user_email`),
  ADD KEY `user_email_2` (`user_email`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `article_advanced_details`
--
ALTER TABLE `article_advanced_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `article_basic_details`
--
ALTER TABLE `article_basic_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `article_types`
--
ALTER TABLE `article_types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `sellers`
--
ALTER TABLE `sellers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `shipping_details`
--
ALTER TABLE `shipping_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `storage_system`
--
ALTER TABLE `storage_system`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_authorization`
--
ALTER TABLE `user_authorization`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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

--
-- Constraints for table `user_authorization`
--
ALTER TABLE `user_authorization`
  ADD CONSTRAINT `seller_user` FOREIGN KEY (`user_email`) REFERENCES `sellers` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
