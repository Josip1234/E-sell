package sell.sellers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.NoArgsConstructor;
import sell.functions.GeneralFunctions;

@Repository
@NoArgsConstructor
public class SellerDbRepo implements SellerRepository {

	private JdbcTemplate jdbc;
	@Autowired
	public SellerDbRepo(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}
	@Override
	public Iterable<Sellers> findAll() {
		
		return jdbc.query("select fname,lname,nickname,location,contact,email, hash_password from Sellers", this::mapRowToSeller);
	}

	@Override
	public Sellers findOne(String email) {
		
		return jdbc.queryForObject("select fname,lname,nickname,location,contact,email, hash_password from Sellers where email=?", this::mapRowToSeller,email);
	}

	private Sellers mapRowToSeller(ResultSet rs, int rowNum) throws SQLException {
		return new Sellers(rs.getString("fname"),rs.getString("lname"),rs.getString("location"),rs.getString("nickname"),rs.getString("contact"),
				rs.getString("email"),rs.getString("hash_password"));
	
	}
	
	private Sellers mapNicknameToSeller(ResultSet rs, int rowNum) throws SQLException {
		return new Sellers(rs.getString("nickname"));
	
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
	@Override
	public void updateProfile(Sellers seller) {
		jdbc.update("UPDATE Sellers SET fname=?, lname=?, location=?, email=?, nickname=?, contact=? WHERE email=?", seller.getFname(),seller.getLname(),seller.getLocation(),seller.getEmail(),seller.getNickname(),seller.getContact(),GeneralFunctions.getUserEmail());
	}
	


}
