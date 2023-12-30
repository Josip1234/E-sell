package sell.files;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.NoArgsConstructor;
import sell.articles.Article_advanced_details;

@Repository
@NoArgsConstructor
public class StorageRepJdbcImpl implements StorageRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public StorageRepJdbcImpl(JdbcTemplate jdbc) {
		this.jdbcTemplate=jdbc;
	}

	@Override
	public Storage save(Storage storage) {
		jdbcTemplate.update(
				"insert into Storage_system (nickname,article_number,user_folder,article_folder,file_name,file_extension, local_path, url,type,relative_link) values(?,?,?,?,?,?,?,?,?,?)",
				storage.getNickname(),storage.getArticle_number(),storage.getUser_folder(),storage.getArticle_folder(),storage.getFile_name(),
				storage.getFile_extension(),storage.getLocal_path(),storage.getUrl(),storage.getType(),storage.getRelative_link()
				);
		return storage;
		
	}
	
	private Storage mapRowToStorage(ResultSet rs, int rowNum) throws SQLException {
		return new Storage(
				rs.getString("nickname"),
				rs.getString("article_number"),
				rs.getString("user_folder"),
				rs.getString("article_folder"),
				rs.getString("file_name"),
				rs.getString("file_extension"),
				rs.getString("local_path"),
				rs.getString("url"),
				rs.getString("type"),
				rs.getString("relative_link")
				);
	
	}

	@Override
	public List<Storage> findImagesByArticleNumber(String article_number) {
		
		return jdbcTemplate.query("SELECT * FROM Storage_system where article_number=?", this::mapRowToStorage,article_number);
	}

	@Override
	public List<Storage> findImagesByLoggedInUser(String nickname) {
		
		return jdbcTemplate.query("SELECT * FROM Storage_system where nickname=?", this::mapRowToStorage,nickname);
	}

}
