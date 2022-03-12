package sell.articles;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Article_basic_details {
@Null
private Integer id;
//foreign key from articles tables. will be generated automaticly by session when article was entered
@NonNull
private String art_num;
//foreign key from table types. same as type id2 and typeid3
@NonNull
private Integer type_id;
@NotNull
@NotBlank(message = "Price is required.")
@Size(min = 1, max = 50, message = "Price must be between 1 and 50 letters.")
private String price;
private String article_condition;
@NonNull
private Integer type_id2;
@NonNull
private Integer type_id3;

public Article_basic_details(String art_num, Integer type_id,String price,String article_condition, Integer type_id2, Integer type_id3) {
	this.art_num = art_num;
	this.type_id = type_id;
	this.price = price;
	this.article_condition = article_condition;
	this.type_id2 = type_id2;
	this.type_id3 = type_id3;
}
public Article_basic_details(String art_num) {
	this.art_num = art_num;

}




}
