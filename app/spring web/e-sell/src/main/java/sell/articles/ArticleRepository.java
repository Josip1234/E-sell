package sell.articles;

public interface ArticleRepository {
Iterable<Articles> findAll();
Articles findOne(String value);
Articles save(Articles articles);
}
