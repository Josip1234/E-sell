package sell.articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleJpa extends JpaRepository<Articles, Integer>, PagingAndSortingRepository<Articles, Integer> {

}
