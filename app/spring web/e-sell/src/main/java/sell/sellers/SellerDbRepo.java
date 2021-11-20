package sell.sellers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SellerDbRepo implements SellerRepository {

	private JdbcTemplate jdbc;
	@Autowired
	public SellerDbRepo(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}
	@Override
	public Iterable<Sellers> findAll() {
		
		return jdbc.query("select nickname,location,contact from Sellers", this::mapRowToSeller);
	}

	@Override
	public Sellers findOne(String email) {
		
		return jdbc.queryForObject("select nickname,location,contact from Sellers where email=?", this::mapRowToSeller,email);
	}

	private Sellers mapRowToSeller(ResultSet rs, int rowNum) throws SQLException {
		return new Sellers(
				rs.getString("nickname"),
				rs.getString("location"),
				rs.getString("contact")
				);
	
	}
	@Override
	public Sellers save(Sellers seller) {
		jdbc.update(
				"insert into Sellers (fname,lname,dateofbirth,location,nickname,contact, email, hash_password) values(?,?,?,?,?,?,?,?)",
				seller.getFname(),
				seller.getLname(),
				seller.getDateofbirth(),
				seller.getLocation(),
				seller.getNickname(),
				seller.getContact(),
				seller.getEmail(),
				seller.getHash_password()
				);
		return seller;
	}
	
	


}
