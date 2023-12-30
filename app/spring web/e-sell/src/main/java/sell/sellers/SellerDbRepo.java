package sell.sellers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.NoArgsConstructor;
import sell.functions.GeneralFunctions;

@Repository
@NoArgsConstructor
public class SellerDbRepo implements SellerRepository {

	private JdbcTemplate jdbc;
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
		return new Sellers(rs.getString("fname"),rs.getString("lname"),rs.getString("nickname"),rs.getString("location"),rs.getString("contact"),
				rs.getString("email"),rs.getString("hash_password"));
	
	}
	
	@SuppressWarnings("unused")
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
		jdbc.update(
				"insert into User_authorization(user_email, type_of_user) values(?,?)",
				seller.getEmail(),seller.getType_of_user()
				);
		return seller;
	}
	@Override
	public void updateProfile(Sellers seller) {
		jdbc.update("UPDATE Sellers SET fname=?, lname=?, location=?, email=?, nickname=?, contact=? WHERE email=?", seller.getFname(),seller.getLname(),seller.getLocation(),seller.getEmail(),seller.getNickname(),seller.getContact(),GeneralFunctions.getUserEmail());
	}
	@Override
	public Sellers findTypeOfUser(String email) {
        Sellers sellers = new Sellers();
        sellers.setType_of_user(jdbc.queryForObject("select type_of_user from User_authorization where user_email=?", this::mapRowToUserType,email));
		return sellers;
	}
	@SuppressWarnings("unused")
	private String mapRowToUserType(ResultSet rs, int rowNum) throws SQLException {

		return rs.getString("type_of_user");
	
	}


}
