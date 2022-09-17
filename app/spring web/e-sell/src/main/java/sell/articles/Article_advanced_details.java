package sell.articles;

import lombok.AllArgsConstructor;
import lombok.Data;
/***
 * Class for shoe details table
 * @author Josip Bošnjak
 *
 */
@Data
@AllArgsConstructor
public class Article_advanced_details {
private Integer id;
private String article_num;
private String description1;
private String description2;


}
