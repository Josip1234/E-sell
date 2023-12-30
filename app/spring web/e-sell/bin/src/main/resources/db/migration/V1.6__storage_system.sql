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
ALTER TABLE `storage_system`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nickname` (`nickname`),
  ADD KEY `article_number` (`article_number`);

ALTER TABLE `storage_system`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `storage_system`
  ADD CONSTRAINT `article_nm` FOREIGN KEY (`article_number`) REFERENCES `articles` (`article_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nickname_fk` FOREIGN KEY (`nickname`) REFERENCES `sellers` (`nickname`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
