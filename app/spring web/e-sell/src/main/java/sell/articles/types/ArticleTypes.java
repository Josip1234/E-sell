package sell.articles.types;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleTypes {
@Null
private Integer id;
@NotNull
@NotBlank(message = "Type is required.")
@Size(min = 1, max = 255, message = "Type must be between 1 and 50 letters.")
private String type;
//this is foreign key for tables category or subcategory. each number here will be connected to that table for making product categorization automaticly. 
//user will choose it from select choice.
@Null
private Integer types_of_categories;
}
