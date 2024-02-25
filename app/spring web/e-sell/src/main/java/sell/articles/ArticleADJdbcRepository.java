package sell.articles;

import java.sql.ResultSet;
import java.sql.SQLException;

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
				"insert into article_advanced_details (article_num, description1, description2,display_mode_desc1,display_mode_desc2) values(?,?,?,?,?)",
				advanced_details.getArticle_num(),
				advanced_details.getDescription1(),
				advanced_details.getDescription2(),
				advanced_details.getDisplay_mode_desc1(),
			    advanced_details.getDisplay_mode_desc2()
				);
		return advanced_details;
	}

	
	
	@Override
	public Article_advanced_details findDetails(String article_number) {
		
		return jdbcTemplate.queryForObject("select article_num, description1, description2,display_mode_desc1,display_mode_desc2 from Article_advanced_details where article_num=?", this::mapRowToArticlesAD, article_number);
	}
	
	private Article_advanced_details mapRowToArticlesAD(ResultSet rs, int rowNum) throws SQLException {
		return new Article_advanced_details(
				rs.getString("article_num"),
				rs.getString("description1"),
				rs.getString("description2"),
				rs.getString("display_mode_desc1"),
				rs.getString("display_mode_desc2")
				);
	
	}
	

}
