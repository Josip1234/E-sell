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

}
