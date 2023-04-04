package sell.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ArticleADJdbcRepository implements ArticleADRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	
    @Autowired
	public ArticleADJdbcRepository(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Article_advanced_details save(Article_advanced_details advanced_details) {
		System.out.println(advanced_details);
		jdbcTemplate.update(
				"insert into article_advanced_details (article_num, description1, description2) values(?,?,?)",
				advanced_details.getArticle_num(),
				advanced_details.getDescription1(),
				advanced_details.getDescription2()
				);
		return advanced_details;
	}

}
