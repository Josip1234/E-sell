package sell.articles;

public interface ArticleBdRepository {
Iterable<Article_basic_details> findByPrice(String price);
}
