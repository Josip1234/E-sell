package sell.articles;

import java.util.List;

import sell.sellers.Sellers;

public interface ArticleRepository {
Iterable<Articles> findAll();
List<Articles> findAllByUsername(Sellers seller);
Articles findOne(String value);
Articles save(Articles articles);
}
