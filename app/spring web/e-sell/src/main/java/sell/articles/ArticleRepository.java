package sell.articles;

import sell.sellers.Sellers;

public interface ArticleRepository {
Iterable<Articles> findAll();
Articles findOne(String value);
Articles save(Articles articles);
}
