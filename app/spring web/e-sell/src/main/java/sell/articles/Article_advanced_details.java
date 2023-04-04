package sell.articles;

import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
/***
 * Class for shoe details table
 * @author Josip Bošnjak
 *
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Article_advanced_details {
@Null
private Integer id;
@NonNull
private String article_num;
@NonNull
private String description1;
@NonNull
private String description2;


}
