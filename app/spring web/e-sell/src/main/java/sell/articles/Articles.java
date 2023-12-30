package sell.articles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import sell.functions.GeneralFunctions;
/***
 * 
 * @author Josip Bošnjak
 * Class for Articles.
 *
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="articles")
public class Articles {
@Null
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private Integer id;
@NonNull
@NotNull
@NotBlank(message = "Article number is required.")
@Size(min = 1, max=20, message = "Must have at least 1 letter. Required field. Can have maximum 20 characters.")
@Column(name="article_number")
private String article_number;
@NonNull
@NotNull
@NotBlank(message = "Article name is required.")
@Size(min = 1, max = 255, message = "Must be a number up to 255 characters.")
@Column(name="article_name")
private String article_name;
//foreign key for seller table. wilčl be null because session will generate id from seller.
@Null
@NonNull
@Column(name="seller")
private String seller;
}
