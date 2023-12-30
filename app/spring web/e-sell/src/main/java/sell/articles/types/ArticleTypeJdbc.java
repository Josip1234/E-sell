package sell.articles.types;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/***
 * 
 * Class for implementation of article type table jdbc template
 * 
 * @author Josip Bošnjak
 * 
 *
 */
@Repository
public class ArticleTypeJdbc implements TypesRepository {
	
	private JdbcTemplate jdbc;
	
	public ArticleTypeJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbc=jdbcTemplate;
				}
	




	@Override
	public ArticleTypes findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleTypes save(ArticleTypes types) {
		System.out.println("tip:"+types);
		jdbc.update(
				"insert into Article_types (type) values(?)",
				types.getType()
				);
		return types;
	}
	
	private ArticleTypes mapRowToTypes(ResultSet rs, int rowNum) throws SQLException {
		return new ArticleTypes(
				
				rs.getString("type"));
	
	}


}
