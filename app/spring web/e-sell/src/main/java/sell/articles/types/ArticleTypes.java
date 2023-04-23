package sell.articles.types;

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
/***
 * Class for article types table
 * @author Josip Bošnjak
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="article_types")
public class ArticleTypes {
@Null
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private Integer id;
@NotNull
@NotBlank(message = "Type is required.")
@Size(min = 1, max = 255, message = "Type must be between 1 and 50 letters.")
@Column(name="type")
private String type;

}
