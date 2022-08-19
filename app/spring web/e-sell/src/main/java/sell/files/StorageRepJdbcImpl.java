package sell.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.NoArgsConstructor;

@Repository
@NoArgsConstructor
public class StorageRepJdbcImpl implements StorageRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public StorageRepJdbcImpl(JdbcTemplate jdbc) {
		this.jdbcTemplate=jdbc;
	}

	@Override
	public Storage save(Storage storage) {
		jdbcTemplate.update(
				"insert into Storage_system (nickname,article_number,user_folder,article_folder,file_name,file_extension, local_path, url,type) values(?,?,?,?,?,?,?,?,?)",
				storage.getNickname(),storage.getArticle_number(),storage.getUser_folder(),storage.getArticle_folder(),storage.getFile_name(),
				storage.getFile_extension(),storage.getLocal_path(),storage.getUrl(),storage.getType()
				);
		return storage;
		
	}

}
