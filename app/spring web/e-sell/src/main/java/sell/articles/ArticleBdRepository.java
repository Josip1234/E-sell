package sell.articles;

public interface ArticleBdRepository {
Iterable<Article_basic_details> findByPrice(String price);
Iterable<Article_basic_details> findAll();
Article_basic_details save(String article_number,Article_basic_details bdetails);
}
