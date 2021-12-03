package sell.articles;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ArticleJdbcRepository implements ArticleRepository {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public ArticleJdbcRepository(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}

	@Override
	public Iterable<Articles> findAll() {
		return jdbc.query("select article_number,article_name,seller from Articles", this::mapRowToArticles);

	}

	@Override
	public Articles findOne(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articles save(Articles articles) {
		log.info("Values:"+articles);
		jdbc.update(
				"insert into Articles (article_number, article_name,seller) values(?,?,?)",
				articles.getArticle_number(),
				articles.getArticle_name(),
				articles.getSeller()
				);
		return articles;
	}
	private Articles mapRowToArticles(ResultSet rs, int rowNum) throws SQLException {
		return new Articles(
				rs.getString("article_number"),
				rs.getString("article_name"),
				rs.getString("seller"));
	
	}

}
