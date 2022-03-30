package sell.articles;

import java.util.List;

import sell.sellers.Sellers;

/***
 * 
 * @author Josip Bošnjak
 * Interface for implementation of article jdbc repository.
 * Also contains function for finding all articles from user.
 *
 */
public interface ArticleRepository {
	/***
	 * 
	 * @return all articles from database
	 */
Iterable<Articles> findAll();
/***
 * @author Josip Bošnjak
 * @param seller
 * @return all articles from one seller
 */
List<Articles> findAllByUsername(Sellers seller);
/***
 * @author Josip Bošnjak
 * @param value
 * @return find one article
 */
Articles findOne(String value);
/***
 * @author Josip Bošnjak
 * @param articles
 * @return save new articles
 */
Articles save(Articles articles);
}
