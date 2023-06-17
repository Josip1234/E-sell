package sell.files;

import java.util.List;

import sell.articles.Articles;
import sell.sellers.Sellers;
/***
 * Interface for dunction definition for new folder creation
 * @author Josip Bošnjak
 *
 */
public interface CreateFolders {
	boolean createFolder(Object object);
	boolean saveApplicationPropertiesFile(List<String> fileDataValues, ApplicationProperties applicationProperties);
	boolean deleteFolder(String url);

}
