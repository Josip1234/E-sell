package sell.functions;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.extern.slf4j.Slf4j;
import sell.articles.Article_basic_details;
import sell.sellers.Sellers;

@Slf4j
public class GeneralFunctions {

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
		log.info(String.valueOf("Value has been found?"+String.valueOf(found)));
		return found;
	}
	//function to get minimum and maximum from basic articles
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
	
	public static List<Double> displayPrices(List<Article_basic_details> articleBasic){
		//declare map
		Map<String, String> map = new HashMap<String,String>();
		//declare min and max value to find range for prices
		double min,max;
		//variable for range
		Double divideBy=0.0;
		//find min and max value and add it into the map
		map=findMinAndMax(articleBasic);
		//get minimum value
		min=Double.valueOf(map.get(MinMax.min.toString()));
		//get maximum value
		max=Double.valueOf(map.get(MinMax.max.toString()));
		//get range round it to integer
		divideBy= max/min;
		//ntil max value has been reached, subtract max value add it to list
		List<Double> valuesToDisplay = new ArrayList<Double>();
		double remainder=0.0;
		//if index is zero remainder is max add it to the list after that subtract remainder and add it to the list for every other case subtract remainder add it to the list
		//this will be optimized after project is finished
		for (double i = 0.0; i < max; i++) {
			if(i==0) {
				remainder=max;
			}else if(remainder<0) {
				break;
			}else {
				BigDecimal db= new BigDecimal(remainder).setScale(2,RoundingMode.HALF_UP);
				double rounded=db.doubleValue();
				valuesToDisplay.add(rounded);
				remainder=remainder-divideBy;
				
			}
			
		}
		Collections.shuffle(valuesToDisplay);
		return valuesToDisplay;
	}
	//this will remove any stringvalue from database as price it will take only numbers
	//this list will be searched to find products by price
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
//take mall the numbers from urls
public static String replaceURL(String url) {
	String temp="";
	Pattern pattern = Pattern.compile(".*/(.*)");
	Matcher matcher = pattern.matcher(url);
	if (matcher.find())
	{
	   
	    temp=matcher.group(1);
	}
	return temp;
}
	
}
