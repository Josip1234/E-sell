package sell.articles.types;

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
private String article_number;
private String Shoe_condition;
private String Theme;
private String Pattern;
private boolean Customized;
private String Color;
private String Upper_Material;
private boolean Vintage;
private String Insole_Material;
private String Occasion;
private String Brand;
private String Shoe_size;
private String Lining_Material;
private String Shoe_character;
private String Accents;
private String Model;
private String Toe_Shape;
private String Department;
private String Style;
private String Heel_Style;
private String Shoe_Shaft_Style;
private String Season;
private String Outsole_Material;
private String Heel_Height;


}
