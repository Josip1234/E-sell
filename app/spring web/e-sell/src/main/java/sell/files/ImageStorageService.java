package sell.files;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**ž
 * Will be used as storage service to store images depending on user folder and product number folder.
 * 
 * @author Korisnik
 * @version 1. 0
 * 
 *
 */
public interface ImageStorageService {
   public void storeFile(MultipartFile fileName);
   Stream<Path> loadAll();
   Path load(String fileName);
   Resource loadAsResource(String fileName);
}
