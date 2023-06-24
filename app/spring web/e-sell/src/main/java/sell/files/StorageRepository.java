/**
 * 
 */
package sell.files;

import java.util.List;

/**
 * @author Korisnik
 *
 */
public interface StorageRepository {
 Storage save(Storage storage);
 List<Storage> findImagesByArticleNumber(String article_number);
 List<Storage> findImagesByLoggedInUser(String nickname);
}
