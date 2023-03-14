package sell.articles;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/***
 * 
 * @author Josip Bošnjak
 * Interface for Article table in sql table article_basic details
 *
 */
public interface ArticleBdRepository {
	/***
	 * @author Josip Bošnjak
	 * @param price
	 * @return list of article basic details
	 * Find article basic details by price.
	 */
Iterable<Article_basic_details> findByPrice(String price);
/***
 * @author Josip Bošnjak
 * @return list of article basic details
 */
Iterable<Article_basic_details> findAll();
/***
 * @author Josip Bošnjak
 * @param article_number 
 * @param bdetails
 * @return saved article basic details object
 * Save basic details of articles. Article number may be extra. Probably will be removed in the future.
 */
Article_basic_details save(String article_number,Article_basic_details bdetails);

}
