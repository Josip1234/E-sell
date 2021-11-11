package sell;

import java.math.BigInteger;

import sell.articles.Articles;
import sell.files.Folder;
import sell.sellers.Sellers;

public class Main {

	public static void main(String[] args) {
		Sellers seller=new Sellers("josip");
		Folder folder=new Folder(seller.getNickname());
		Articles article=new Articles(1, BigInteger.TEN, "neki artikl", seller.getNickname());
		
		System.out.println(folder.createFolder(article));
		

        
	}

}
