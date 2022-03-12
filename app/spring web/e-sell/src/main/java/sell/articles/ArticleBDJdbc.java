package sell.articles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ArticleBDJdbc implements ArticleBdRepository {

	private JdbcTemplate template;

	public ArticleBDJdbc(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Iterable<Article_basic_details> findByPrice(String price) {
		return template.query("select ar_num,type_id,price,article_condition,type_id_2,type_id_3 from Article_basic_details where price=?", this::mapRowToArticlesBD);
	}
	
	private Article_basic_details mapRowToArticlesBD(ResultSet rs, int rowNum) throws SQLException {
		return new Article_basic_details(
				rs.getString("ar_num"),
				rs.getInt("type_id"),
				rs.getString("price"),
				rs.getString("article_condition"),
				rs.getInt("type_id_2"),
				rs.getInt("type_id_3")
				);
	
	}

	@Override
	public Iterable<Article_basic_details> findAll() {
		return  template.query("select ar_num,type_id,price,article_condition,type_id_2,type_id_3 from Article_basic_details", this::mapRowToArticlesBD);
	}

	@Override
	public Article_basic_details save(String article_number,Article_basic_details bdetails) {
		template.update(
				"insert into Article_basic_details (ar_num,type_id,price,article_condition,type_id_2,type_id_3) values(?,?,?,?,?,?)",
			    article_number,
			    bdetails.getType_id(),
			    bdetails.getArticle_condition(),
			    bdetails.getType_id2(),
			    bdetails.getType_id3()
				);
		return bdetails;
	}

}
