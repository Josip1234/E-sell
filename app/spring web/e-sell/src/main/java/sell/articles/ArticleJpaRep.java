package sell.articles;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ArticleJpaRep extends JpaRepository<Articles, Integer> {

}
