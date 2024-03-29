package sell.functions;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.github.javafaker.Faker;

import lombok.extern.slf4j.Slf4j;
import sell.articles.Article_basic_details;
import sell.files.Folder;
import sell.files.Storage;
import sell.sellers.Sellers;
/***
 * Class for general functions.
 * @author Josip Bošnjak
 *
 */
@Slf4j
public class GeneralFunctions {
	
	/***
	 * @author Josip Bošnjak
	 * @since 18.08.2022. 20:32
	 * @param regExpression -reg expression to match
	 * @param valueToReplace - value to replace
	 * @return file extension
	 */
	public static String getFileExtension(String regExpression, String valueToReplace) {
		String value="";
		String regex=regExpression;
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(valueToReplace);
		if(m.find()) {
			value=m.group(0);
			
		}
		return value;
	}
	
	/***
	 * @author Josip Bošnjak
	 * @param seller accept list of sellers
	 * @return filtered list of sellers of non forbidden key words like root
	 */
	public static List<Sellers> removeStartSellerFromList(List<Sellers> seller){
		List<Sellers> filtered= new ArrayList<Sellers>();
		for (Iterator iterator = seller.iterator(); iterator.hasNext();) {
			Sellers sellers = (Sellers) iterator.next();
			if(sellers.getNickname().equalsIgnoreCase("root")==true){
				continue;
			}else {
				filtered.add(sellers);
			}
		}
		return filtered;
	}
    /***
     * This function using security context holder and user details to get user email from logged in user.
     * @author Josip Bošnjak
     * @return email from logged in user
     * note: we need to force username to be equal to email for login or change function to find username
     */
	public static String getUserEmail() {
		String email="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
		  email=username;
		} else {
		  String username = principal.toString();
		  email=username;
		}
		return email;
	}
	/***
	 * Find value in list of sellers.
	 * @param valueToFind
	 * @param sellers
	 * @return true if value has been found
	 * @author Josip Bošnjak
	 */
	public static boolean findInAList(String valueToFind,List<Sellers> sellers) {
		boolean found=false;
		for (Iterator iterator = sellers.iterator(); iterator.hasNext();) {
			Sellers sellers2 = (Sellers) iterator.next();
			if(sellers2.getNickname().equalsIgnoreCase(valueToFind)) {
				found=true;
				break;
			}else {
				found=false;
			}
		}
		//log.info(String.valueOf("Value has been found?"+String.valueOf(found)));
		return found;
	}
	/***
	 * function to get minimum and maximum from basic articles
	 * @param article_details 
	 * @return map which contains min and max price values
	 * @author Josip Bošnjak
	 */
	//we will need dollars to other currencies conversion 
	public static Map<String,String> findMinAndMax(Iterable<Article_basic_details> article_details){
		Map<String, String> map = new HashMap<String,String>();
		//min key for map
		String minKey=MinMax.min.toString();
		//max key for map
		String maxKey=MinMax.max.toString();
		//collect price string from iterable list
		List<String> price=new ArrayList<String>();
		for (Article_basic_details article_basic_details : article_details) {
			price.add(article_basic_details.getPrice());
		}
		//we will need regex to remove anything but numbers in list 2
		//we need regex to match all the numbers
		String regex="\\d+\\.\\d+|^\\d+";
		Pattern p = Pattern.compile(regex);
		//after string is found add it to another list
		List<Double> price2 = new ArrayList<Double>();
		for (Iterator iterator = price.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			Matcher m = p.matcher(string);
			if(m.find()) {
				price2.add(Double.valueOf(m.group(0)));
			}
		}
		//find minimum and maximum value 
		Double minimum=0.0;
		Double maximum=0.0;
	   
		minimum=price2.stream().mapToDouble(d->d).min().orElseThrow(NoSuchElementException::new);
		maximum=price2.stream().mapToDouble(d->d).max().orElseThrow(NoSuchElementException::new);
		//System.out.println(minimum);
		//System.out.println(maximum);
		//add it to the map
		map.put(minKey, minimum.toString());
		map.put(maxKey, maximum.toString());
		
		return map;
	}
	/***
	 * This function displays random prices from the article basic detail list. 
	 * @param articleBasic
	 * @return list which contains double price values on homepage.
	 * @author Josip Bošnjak
	 */
	public static Map<Double,Double> displayPrices(Map<Double, Double> map,List<Article_basic_details> articleBasic){
		articleBasic=removeStringFromPrice(articleBasic);
		//declare map
		Map<String, String> maxmin = new HashMap<String,String>();
		//declare min and max value to find range for prices
		Double max;
		//variable for range
		//find min and max value and add it into the map
		maxmin=findMinAndMax(articleBasic);
		//get minimum value
		//get maximum value
		max=Double.valueOf(maxmin.get(MinMax.max.toString()));

		ClassificationImplementation implementation = new ClassificationImplementation();
		map=implementation.returnPriceListForHomePage(max);
		return map;
	}
	
	/***
	 * 	this will remove any stringvalue from database as price it will take only numbers . this list will be searched to find products by price
	 * @param list
	 * @return list of objects with stripped price values.
	 * @author Josip Bošnjak
	 */

	public static List<Article_basic_details> removeStringFromPrice(List<Article_basic_details> list){
		List<Article_basic_details> details= new ArrayList<Article_basic_details>();
		Article_basic_details detailsCopy=new Article_basic_details();
		String regex="\\d+\\.\\d+|^\\d+";
		Pattern p = Pattern.compile(regex);
		for (Article_basic_details article_basic_details : list) {
			Matcher m = p.matcher(article_basic_details.getPrice());
			if(m.find()) {
				detailsCopy.setArt_num(article_basic_details.getArt_num());
				detailsCopy.setArticle_condition(article_basic_details.getArticle_condition());
				detailsCopy.setType_id(article_basic_details.getType_id());
				detailsCopy.setType_id2(article_basic_details.getType_id2());
				detailsCopy.setType_id3(article_basic_details.getType_id3());
				detailsCopy.setPrice(m.group(0));
				  details.add(detailsCopy);
				  detailsCopy=new Article_basic_details();
			}

		}
		return details;
	}
	
/***
 * Function for taking last value of url. those three functions needs to be one function. Need to optimise this code.
 * @param url 
 * @return stripped url
 * @author Josip Bošnjak
 */
public static String replaceURL(String url) {
	String temp="";
	String temp2="";
	//Pattern pattern = Pattern.compile(".*/(.*)");
	Pattern pattern = Pattern.compile(".*/(.*)=(.*)");
	Matcher matcher = pattern.matcher(url);
	String complete="";
	if (matcher.find())
	{
	   
	    temp=matcher.group(1);
	    complete+=temp;
	    temp2=matcher.group(2);
	    complete+="-";
	    complete+=temp2;
	    //System.out.println(temp);
	    //System.out.println(temp2);
	}
	return complete;
}

public static String replacePrice(String price,String regex) {
	String temp="";
	Pattern pattern = Pattern.compile(regex);
	Matcher matcher = pattern.matcher(price);
	if (matcher.find())
	{
	   
	    temp=matcher.group(0);
	    //System.out.println(temp);
	}
	return temp;
}

public static String replacePriceGroup(String price,String regex) {
	String temp="";
	Pattern pattern = Pattern.compile(regex);
	Matcher matcher = pattern.matcher(price);
	if (matcher.find())
	{
	   
	    temp=matcher.group(1);
	    //System.out.println(temp);
	}
	return temp;
}


/***
 * function for returning all objects from list which contains up to price
 * @param article_basic_details
 * @param price
 * @return list of objects with price values. It search original list.
 * @author Josip Bošnjak
 */
public static List<Article_basic_details> findAllObjectsByPrice(List<Article_basic_details> article_basic_details,String price){
	//System.out.println("Price"+price);
	//convert price string to double
	Double priceDouble2=Double.valueOf(replacePrice(price,".*(?=-)"));
	Double priceDouble=Double.valueOf(replacePriceGroup(price,"-(.*)"));
	List<Article_basic_details> article_basic_details2 = new ArrayList<Article_basic_details>();
	for (Article_basic_details article_basic_details3 : article_basic_details) {
		//if price from the list of object is less or equal to wanted price add to the list.
		if(Double.valueOf(article_basic_details3.getPrice())<=priceDouble){
			article_basic_details2.add(article_basic_details3);
		}else if(Double.valueOf(article_basic_details3.getPrice())<=priceDouble2) {
			article_basic_details2.add(article_basic_details3);
		}else if(Double.valueOf(article_basic_details3.getPrice())>priceDouble) {
			continue;
		}else if(Double.valueOf(article_basic_details3.getPrice())>=priceDouble2) {
			continue;
		}
	}
	return article_basic_details2;
}
//it is not possible at this momment to make random apearence at the site. we need to think about it maybe in angular
//or some other framework.
public static Map<Double, Double> displayValues(Map<Double,Double> map, int howMany){
	List<Double> keys=new ArrayList<Double>();
	List<Double> values =new  ArrayList<Double>();
    String getKey="Key";
    String getValue="Value";

	
	Numeric numeric=new Numeric();
	numeric.initMap();
	int mapSize=map.size();
	int[] randomIndexes=numeric.generateRandomIndexesWithoutRepeat(mapSize, howMany);
int index=0;
	for (Map.Entry<Double, Double> entry : map.entrySet()) {
		//if(index==howMany) break;
		
	    //System.out.println("Index"+index);  
		Double key = entry.getKey();
		//numeric.doubleNumArray.add(key);
		Double val = entry.getValue();
		//numeric.doubleNumArray.add(val);
		index++;
		
		//System.out.println(key+" "+ val);
		numeric.getClassification().put(key, val);
		//printDoubleList(getDoubleNumArray());
	}
     

   
	return numeric.getClassification();
}


public static int generateRandomIndex(int upTo) {
	return Faker.instance().number().numberBetween(0, upTo);
}

public static List<String> returnMatchedUrls(List<Storage> storage){
	//initialise some array
	List<String> mat=new ArrayList<String>();
	//for each object in the storage list
	for (Storage storage2 : storage) {
		//declare empty string 
		String matched="";
		//get local path
		String localp=storage2.getLocal_path();
		//replace \ with /
		String replace=localp.replace('\\','/');
	    //define regex
		String regex=".*(?<=/)";
		//compile regex
		Pattern pattern=Pattern.compile(regex);
		//compile what to find
		Matcher matcher= pattern.matcher(replace);
		//find match
	    boolean matchFound = matcher.find();
	    //if match is found return local url path to folder with article_number else return match not found error
	    if(matchFound) {
	    matched=matcher.group(0);
	    mat.add(matched);
	    } else {
	      System.out.println("Match not found");
	    }


}
	return mat;
}
public static boolean deleteFolderFromListOfUrls(Folder folder, List<String> list) {
	boolean deleted=false;
	  for (String string : list) {
			folder.setDefaultPath(string);
			folder.deleteFolder(folder.getDefaultPath());
		}
	  return deleted;
}

}
