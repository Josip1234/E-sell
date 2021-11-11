package sell.articles.types;

import sell.sellers.Sellers;

public interface TypesRepository {
	Iterable<ArticleTypes> findAll();
	ArticleTypes findOne(String id);
	ArticleTypes save(Sellers seller);
}
