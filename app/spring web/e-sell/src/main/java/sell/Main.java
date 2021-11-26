package sell;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import sell.articles.Articles;
import sell.files.Folder;
import sell.sellers.Sellers;
import sell.test.data.UserPassImpl;
import sell.test.data.UserPassword;

public class Main {

	public static void main(String[] args) {
		Sellers seller=new Sellers();
		seller.setNickname("josip");
		seller.setHash_password("123456789");
		Folder folder=new Folder(seller.getNickname());
		Articles article=new Articles(1, String.valueOf(BigInteger.TEN), "neki artikl", seller.getNickname());
		
		System.out.println(folder.createFolder(article));
		
	
		UserPassImpl password= new UserPassImpl();
		Map<String, Sellers> map = new HashMap<>();
		map.put(seller.getNickname(),seller);
		password.saveTestData(map,seller);
		
		
        
	}

}
