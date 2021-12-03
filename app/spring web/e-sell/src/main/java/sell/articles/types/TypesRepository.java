package sell.articles.types;

public interface TypesRepository {
	Iterable<ArticleTypes> findAll();
	ArticleTypes findOne(String id);
	ArticleTypes save(ArticleTypes types);
}
