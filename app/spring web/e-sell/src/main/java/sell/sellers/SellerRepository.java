package sell.sellers;

public interface SellerRepository {

	Iterable<Sellers> findAll();
	Sellers findOne(String id);
	Sellers save(Sellers seller);

}
