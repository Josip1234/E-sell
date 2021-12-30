package sell.articles;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Article_basic_details {
@Null
private Integer id;
//foreign key from articles tables. will be generated automaticly by session when article was entered
@Null
@NonNull
private String art_num;
//foreign key from table types. same as type id2 and typeid3
@Null
@NonNull
private Integer type_id;
@NotNull
@NonNull
@NotBlank(message = "Price is required.")
@Size(min = 1, max = 50, message = "Price must be between 1 and 50 letters.")
private String price;
@Null
@NonNull
private String article_condition;
@NonNull
@Null
private Integer type_id2;
@NonNull
@Null
private Integer type_id3;
}
