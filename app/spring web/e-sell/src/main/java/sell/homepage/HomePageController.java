package sell.homepage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import sell.articles.ArticleBdRepository;
import sell.articles.Article_basic_details;
import sell.articles.types.ArticleTypes;
import sell.articles.types.TypesRepository;
import sell.functions.GeneralFunctions;
import sell.functions.MinMax;
import sell.sellers.SellerRepository;
import sell.sellers.Sellers;

@Slf4j
@Controller
public class HomePageController {
	private final SellerRepository repository;
	private final TypesRepository typesRepository;
	private final ArticleBdRepository articleBdRepository;
	
	@Autowired
	public HomePageController(SellerRepository repository, TypesRepository typesRepository, ArticleBdRepository articleBdRepository) {
		this.repository=repository;
		this.typesRepository=typesRepository;
		this.articleBdRepository=articleBdRepository;
	}
@GetMapping("/e-sell/en/")
public String home(Model model) {
	List<ArticleTypes> types=(List<ArticleTypes>) typesRepository.findAll();
	List<Sellers> sellers = (List<Sellers>) repository.findAll();
	List<Article_basic_details> articleBasic=(List<Article_basic_details>) articleBdRepository.findAll();
	
	//log.info(articleBasic.toString());
	//log.info("list of sellers:"+sellers);
	Collections.shuffle(sellers);
	Collections.shuffle(types);
	//declare map
	Map<String, String> map = new HashMap<String,String>();
   //declare min and max value to find range for prices
	double min,max;
	//variable for range
	Double divideBy=0.0;
	//find min and max value and add it into the map
	map=GeneralFunctions.findMinAndMax(articleBasic);
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
	
	
	model.addAttribute("sell",sellers.stream().limit(4).collect(Collectors.toList()));
	model.addAttribute("type",types.stream().limit(4).collect(Collectors.toList()));
	model.addAttribute("basic", valuesToDisplay);
	return "home";
}

}
