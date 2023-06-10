package sell.articles;

public interface ArticleADRepository {
    Article_advanced_details save(Article_advanced_details advanced_details);
    Article_advanced_details findDetails(String article_number);
}
