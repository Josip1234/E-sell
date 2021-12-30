package sell.functions;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
		System.out.println(minimum);
		System.out.println(maximum);
		//add it to the map
		map.put(minKey, minimum.toString());
		map.put(maxKey, maximum.toString());
		
		return map;
	}
}
