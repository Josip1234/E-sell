package sell.ad;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class AdDetailsRepoImpl implements AdDetailsRepository {

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Ad_details save(Ad_details ad_details) {
		// TODO Auto-generated method stub
		 jdbcTemplate.update(
				"insert into ad_details (article_num,ad_added,ad_last_updated,time_until_expire,ad_shown) values (?.?.?,?,?)",
				ad_details.getArticle_num(),
				ad_details.getAd_added(),
				ad_details.getAd_last_updated(),
				ad_details.getTime_until_expire(),
				ad_details.getAd_shown()
				);
		
		return ad_details;
	}
	

}
