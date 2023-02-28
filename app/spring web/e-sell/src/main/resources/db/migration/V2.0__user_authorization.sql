CREATE TABLE `esell`.`user_authorization` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_email` VARCHAR(50) NOT NULL,
  `type_of_user` ENUM('Admin', 'Seller') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`user_email`)
) ENGINE = InnoDB CHARSET = utf8 COLLATE utf8_croatian_ci;
