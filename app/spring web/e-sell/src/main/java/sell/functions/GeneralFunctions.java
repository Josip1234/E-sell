package sell.functions;

import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.extern.slf4j.Slf4j;
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
}
