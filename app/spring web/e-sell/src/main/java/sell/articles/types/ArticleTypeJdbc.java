package sell.articles.types;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sell.sellers.Sellers;

@Repository
public class ArticleTypeJdbc implements TypesRepository {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public ArticleTypeJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbc=jdbcTemplate;
				}
	


	@Override
	public Iterable<ArticleTypes> findAll() {
		
		return jdbc.query("select id,type from article_types", this::mapRowToTypes);
	}

	@Override
	public ArticleTypes findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleTypes save(Sellers seller) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private ArticleTypes mapRowToTypes(ResultSet rs, int rowNum) throws SQLException {
		return new ArticleTypes(
				rs.getInt("id"),
				rs.getString("type"),
				rs.getInt("types_of_categories"));
	
	}


}
