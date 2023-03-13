package sell.articles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
/***
 * 
 * @author Josip Bošnjak
 * Class for Articles.
 *
 */
@Entity
@Table(name="articles")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
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
private String seller;
}
