package sell.shipping;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

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

}
