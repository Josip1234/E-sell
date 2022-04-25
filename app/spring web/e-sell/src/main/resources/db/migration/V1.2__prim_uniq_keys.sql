ALTER TABLE `ad_details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `article_num` (`article_num`);

  ALTER TABLE `article_basic_details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ar_num` (`ar_num`),
  ADD KEY `type_id` (`type_id`),
  ADD KEY `type_id_2` (`type_id_2`),
  ADD KEY `type_id_3` (`type_id_3`);


ALTER TABLE `article_types`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `type` (`type`);


ALTER TABLE `car_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `article_number` (`article_number`);


ALTER TABLE `sellers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nickname` (`nickname`),
  ADD UNIQUE KEY `email` (`email`);


ALTER TABLE `shipping_details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `article_number` (`article_number`);


ALTER TABLE `shoe_details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `article_number` (`article_number`),
  ADD KEY `Shoe_character` (`Shoe_character`);


ALTER TABLE `ad_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `article_basic_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `article_types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `car_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `sellers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `shipping_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `shoe_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


