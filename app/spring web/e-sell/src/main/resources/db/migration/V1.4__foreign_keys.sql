ALTER TABLE "ad_details"
  ADD CONSTRAINT "article_number_fk" FOREIGN KEY ("article_num") REFERENCES "articles" ("article_number") ON DELETE CASCADE ON UPDATE CASCADE;


 

ALTER TABLE "car_detail"
  ADD CONSTRAINT "an2_fk" FOREIGN KEY ("article_number") REFERENCES "articles" ("article_number") ON DELETE CASCADE ON UPDATE CASCADE;



ALTER TABLE "shipping_details"
  ADD CONSTRAINT "art_num_fk" FOREIGN KEY ("article_number") REFERENCES "articles" ("article_number") ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE "shoe_details"
  ADD CONSTRAINT "an_fk" FOREIGN KEY ("article_number") REFERENCES "articles" ("article_number") ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT "shoe_character" FOREIGN KEY ("Shoe_character") REFERENCES "article_types" ("type") ON DELETE CASCADE ON UPDATE CASCADE;


 ALTER TABLE "article_basic_details"
  ADD CONSTRAINT "article_id_fk" FOREIGN KEY ("ar_num") REFERENCES "articles" ("article_number") ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT "article_type_fk" FOREIGN KEY ("type_id") REFERENCES "article_types" ("id") ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT "type_id_2_fk" FOREIGN KEY ("type_id_2") REFERENCES "article_types" ("id") ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT "type_id_3_fk" FOREIGN KEY ("type_id_3") REFERENCES "article_types" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
