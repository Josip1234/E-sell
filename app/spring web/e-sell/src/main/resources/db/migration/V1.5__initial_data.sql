INSERT INTO `ad_details` (`id`, `article_num`, `ad_added`, `ad_last_updated`, `time_until_expire`, `ad_shown`) VALUES
(0, '0', '2022-04-26 19:32:16', '2022-04-26 19:32:16', '0', '0');


INSERT INTO `article_basic_details` (`id`, `ar_num`, `type_id`, `price`, `article_condition`, `type_id_2`, `type_id_3`) VALUES
(0, 0, 1, '0.00', '0', 1, 1);


INSERT INTO `car_detail` (`id`, `article_number`, `brand`, `model`, `year`, `car_condition`, `serialnumber`, `mileage`, `mpg`, `color`, `engine`, `drivetrain`, `basic_equipment`, `additional_equipment`, `car_history`, `additional`, `car_type`, `fuel_type`, `max_speed`, `gearbox_type`) VALUES
(0, '0', '0', '0', 2000, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', NULL, '0');


INSERT INTO `shipping_details` (`id`, `article_number`, `shipping`, `comment`, `location`, `delivery`, `returns`, `payments`) VALUES
(0, '0', '0', '0', '0', '0', '0', '0');


INSERT INTO `shoe_details` (`id`, `article_number`, `Shoe_condition`, `Theme`, `Pattern`, `Customized`, `Color`, `Upper Material`, `Vintage`, `Insole Material`, `Occasion`, `Brand`, `Shoe size`, `Lining Material`, `Shoe_character`, `Accents`, `Model`, `Toe Shape`, `Department`, `Style`, `Heel Style`, `Shoe Shaft Style`, `Season`, `Outsole Material`, `Heel Height`) VALUES (NULL, '0', '', NULL, NULL, NULL, '0', '0', NULL, NULL, NULL, NULL, '0', NULL, 'Cars', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

