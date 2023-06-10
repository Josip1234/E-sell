package sell.shipping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import sell.articles.Article_advanced_details;

@Repository
@AllArgsConstructor
public class ShippingDetailsRepImplement implements ShipDetailRepo {

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Shipping_details save(Shipping_details details) {
		 jdbcTemplate.update(
					"insert into shipping_details (article_number,shipping,comment,location,delivery,returns,payments) values (?,?,?,?,?,?,?)",
					details.getArticle_number(),
					details.getShipping(),
					details.getComment(),
					details.getLocation(),
					details.getDelivery(),
					details.getReturns(),
					details.getPayments()
					);
		return details;
	}

	private Shipping_details mapRowToShipping(ResultSet rs, int rowNum) throws SQLException {
		return new Shipping_details(
				rs.getString("article_number"),
				rs.getString("shipping"),
				rs.getString("comment"),
				rs.getString("location"),
				rs.getString("delivery"),
				rs.getString("returns"),
				rs.getString("payments")
				);
	
	}
	
	
	@Override
	public Shipping_details readDetails(String article_number) {
	
		return jdbcTemplate.queryForObject("select article_number,shipping,comment,location,delivery,returns,payments from Shipping_details where article_number=?", this::mapRowToShipping,article_number);
	}

}
