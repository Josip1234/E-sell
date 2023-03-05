package sell.sellers;

public interface SellerRepository {

	Iterable<Sellers> findAll();
	Sellers findOne(String email);
	Sellers save(Sellers seller);
    void updateProfile(Sellers seller);
    Sellers findTypeOfUser(String email);
}
