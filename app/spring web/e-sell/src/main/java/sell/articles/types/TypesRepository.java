package sell.articles.types;

/***
 * Function definition interface for CRUD for article types table
 * @author Josip Bošnjak
 *
 */
public interface TypesRepository {

	ArticleTypes findOne(String id);
	ArticleTypes save(ArticleTypes types);
}
