package sell;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sell.articles.Article_basic_details;
import sell.articles.Articles;
import sell.files.Folder;
import sell.functions.GeneralFunctions;
import sell.sellers.Sellers;
import sell.test.data.UserPassImpl;

public class Main {

	public static void main(String[] args) {
		List<Article_basic_details> bd= new ArrayList<Article_basic_details>();
		Article_basic_details details= new Article_basic_details("1", 1, "US $36.90", "Used", 2, 3);
		bd.add(details);
	     details= new Article_basic_details("2", 1, "US $32.99", "Used", 2, 3);
	     bd.add(details);
		 details= new Article_basic_details("3", 1, "US $234.37", "Used", 2, 3);
		 bd.add(details);
		 details= new Article_basic_details("4", 1, "500 kn ~ 67 €", "Used", 2, 3);
		 bd.add(details);
		 details= new Article_basic_details("5", 1, "250 kn ~ 34 €", "Used", 2, 3);
		 bd.add(details);
		 details= new Article_basic_details("6", 1, "1.000 kn ~ 134 €", "Used", 2, 3);
		 bd.add(details);
		 details= new Article_basic_details("7", 1, "60 kn ~ 9 €", "Used", 2, 3);
		 bd.add(details);
		 details= new Article_basic_details("8", 1, "1.4", "Used", 2, 3);
		 bd.add(details);
		 details= new Article_basic_details("9", 1, "12.45", "Used", 2, 3);
		 bd.add(details);
		 details= new Article_basic_details("10", 1, "fgrge 13.45", "Used", 2, 3);bd.add(details);
		 bd.add(details);
		 for (Article_basic_details article_basic_details : bd) {
			System.out.println(article_basic_details);
		}
		 GeneralFunctions.findMinAndMax(bd);
		/*
		 * start
		 * Sellers seller=new Sellers();
		seller.setNickname("josip");
		seller.setHash_password("123456789");
		Folder folder=new Folder(seller.getNickname());
		Articles article=new Articles(1, String.valueOf(BigInteger.TEN), "neki artikl", seller.getNickname());
		
		System.out.println(folder.createFolder(article));
		
	
		UserPassImpl password= new UserPassImpl();
		Map<String, Sellers> map = new HashMap<>();
		map.put(seller.getNickname(),seller);
		password.saveTestData(map,seller);
		stop test
		*/
		
        
	}

}
