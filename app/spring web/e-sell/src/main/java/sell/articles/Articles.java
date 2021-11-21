package sell.articles;

import java.math.BigInteger;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Articles {
@Null
private Integer id;
@NonNull
@NotNull
@NotBlank(message = "Article number is required.")
@Size(min = 1, max=20, message = "Must have at least 1 letter. Required field. Can have maximum 20 characters.")
private String article_number;
@NonNull
@NotNull
@NotBlank(message = "Article name is required.")
@Size(min = 1, max = 255, message = "Must be a number up to 255 characters.")
private String article_name;
//foreign key for seller table. wilčl be null because session will generate id from seller.
@Null
@NonNull
private String seller;
}
