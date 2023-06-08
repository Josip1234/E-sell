package sell.articles;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface ArticleJpa extends JpaRepository<Articles, Integer> {
	  @Query(value = "SELECT * FROM Articles WHERE article_name LIKE %?%", nativeQuery = true)
	  Page<Articles> findByArticleName(String articleName, Pageable pageable);
	  @Query(value="SELECT * FROM Articles WHERE seller = ?", nativeQuery = true)
	  List<Articles> findArticlesOfLoggedInUser(String seller);
}
