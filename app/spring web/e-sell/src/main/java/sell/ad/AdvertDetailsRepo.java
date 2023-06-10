package sell.ad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sell.articles.Articles;

public interface AdvertDetailsRepo extends JpaRepository<Ad_details, Integer> {
	  @Query(value="SELECT * FROM Ad_details WHERE article_num = ?", nativeQuery = true)
	  Ad_details findDetailsByAn(String article_num);
}
