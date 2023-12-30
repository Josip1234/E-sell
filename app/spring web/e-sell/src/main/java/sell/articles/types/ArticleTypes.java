package sell.articles.types;

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
/***
 * Class for article types table
 * @author Josip Bošnjak
 *
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="article_types")
public class ArticleTypes {
@Null
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private Integer id;
@NonNull
@NotNull
@NotBlank(message = "Type is required.")
@Size(min = 1, max = 255, message = "Type must be between 1 and 50 letters.")
@Column(name="type")
private String type;

}
