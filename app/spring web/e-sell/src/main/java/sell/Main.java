package sell;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sell.articles.Article_basic_details;
import sell.articles.Articles;
import sell.files.ApplicationProperties;
import sell.files.Folder;
import sell.functions.ClassificationImplementation;
import sell.functions.GeneralFunctions;
import sell.sellers.Sellers;
import sell.test.data.UserPassImpl;


/***
 * 
 * @author Josip Bošnjak
 * Main class for testing general functions. There is in comment example of test data for tested functions.
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		
		//test of application properties class
	    ApplicationProperties properties = new ApplicationProperties();
	    properties.setDefaultValues("com.mysql.cj.jdbc.Driver", "root", "", "file:///c:/Users/Korisnik/Desktop/xampp/htdocs/E-sell/app/spring web/e-sell/eng/","jdbc:mysql://localhost:3306/esell");
		properties.printProperties();
		Folder folder = new Folder();
		List<String> listOfFileData=new ArrayList();
		listOfFileData.add("/e-sell/");
		listOfFileData.add("application.properties");
		folder.saveApplicationPropertiesFile(listOfFileData, properties);
		
		
		/*start test2 test two test a function for finding minimun and maximum price. This price will be stored in a map. 
		 * Map is declared first.
		Map<String, String> map = new HashMap<String,String>();
		*/
		/* Now we are declaring list array for test data.
		List<Article_basic_details> bd= new ArrayList<Article_basic_details>();
		we are creating new object to store in a list of article basic details.
		Article_basic_details details= new Article_basic_details("1", 1, "US $36.90", "Used", 2, 3);
		now we are adding object to the list.
		bd.add(details);
	     details= new Article_basic_details("2", 1, "US $32.99", "Used", 2, 3);
	     bd.add(details);
		 details= new Article_basic_details("3", 1, "US $234.37", "Used", 2, 3);
		 bd.add(details);
		 details= new Article_basic_details("4", 1, "500 kn ~ 67 €", "Used", 2, 3);
		 bd.add(details);
		 details= new Article_basic_details("5", 1, "250 kn ~ 34 €", "Used", 2, 3);
		 bd.add(details);
		 details= new Article_basic_details("6", 1, "1.1256 kn ~ 134 €", "Used", 2, 3);
		 bd.add(details);
		 details= new Article_basic_details("7", 1, "60000 kn ~ 9 €", "Used", 2, 3);
		 bd.add(details);
		 details= new Article_basic_details("8", 1, "1.4", "Used", 2, 3);
		 bd.add(details);
		 details= new Article_basic_details("9", 1, "12.45", "Used", 2, 3);
		 bd.add(details);
		 details= new Article_basic_details("10", 1, "fgrge 13.45", "Used", 2, 3);bd.add(details);
		 bd.add(details);
	
	*/	 
		 /* we are printing values of the list to check if values are the same. if they are,
		  * then something is wrong. 
		  * 
		 for (Article_basic_details article_basic_details : bd) {
			System.out.println(article_basic_details);
		}
		now we are calling function to find minimum and maximum price
		 map=GeneralFunctions.findMinAndMax(bd);
		 we are printing key and value string from the map key is minumum, and maximum, value is value
         for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			System.out.println(key+":"+val);
			
		}
		if everything is ok, then we can use this function in a web app.
         end test2
         */
		/*
		 * start we are testing create folder for user function. first we create empty seller.
		 * Sellers seller=new Sellers();
		 * setting new test values as nickname and password which has a hash.
		seller.setNickname("josip");
		seller.setHash_password("123456789");
		we are making a new object with user nickname
		Folder folder=new Folder(seller.getNickname());
		we are creating new article object.
		Articles article=new Articles(1, String.valueOf(BigInteger.TEN), "neki artikl", seller.getNickname());
		now we are creating folder from article
		System.out.println(folder.createFolder(article));
		
	    //we are testing saving username and password to file
	    first create object of password
		UserPassImpl password= new UserPassImpl();
		create map
		Map<String, Sellers> map = new HashMap<>();
		put seller nickname to the map
		map.put(seller.getNickname(),seller);
		save data to file
		password.saveTestData(map,seller);
		stop test
		this is not needed.
		*/
		 //test 3 including test 2  we are testing function for regex to remove anything else than numbers.
		  //create list of articles
		/* List<Article_basic_details> det = new ArrayList<Article_basic_details>();
		 * call function to recieve cleaned data from general function
		 det=GeneralFunctions.removeStringFromPrice(bd);
		 print that list to check if everything is alright.
		 for (Article_basic_details article_basic_details : det) {
			System.out.println(article_basic_details);
		}*/
	}

}
