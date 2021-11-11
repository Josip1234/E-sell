package sell.articles;

import java.math.BigInteger;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Articles {
@Null
private Integer id;
@NotNull
@NotBlank(message = "Article number is required.")
@Size(min = 1, max = 20, message = "Must be a number up to 20 numbers.")
private BigInteger article_number;
@NotNull
@NotBlank(message = "Article name is required.")
@Size(min = 1, max = 255, message = "Must be a number up to 255 characters.")
private String article_name;
//foreign key for seller table. wilčl be null because session will generate id from seller.
@Null
private String seller;
}
