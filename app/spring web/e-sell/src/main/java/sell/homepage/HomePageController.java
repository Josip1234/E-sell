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
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



import lombok.extern.slf4j.Slf4j;
import sell.articles.ArticleBdRepository;
import sell.articles.ArticleJpa;
import sell.articles.ArticleRepository;
import sell.articles.Article_basic_details;
import sell.articles.Articles;
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
	private final ArticleRepository articleRepository;
	private final ArticleJpa articleJpa;
	
	@Autowired
	public HomePageController(SellerRepository repository, TypesRepository typesRepository, ArticleBdRepository articleBdRepository, ArticleRepository articleRepository,ArticleJpa articleJpa) {
		this.repository=repository;
		this.typesRepository=typesRepository;
		this.articleBdRepository=articleBdRepository;
		this.articleRepository=articleRepository;
		this.articleJpa=articleJpa;
	}
@GetMapping("/e-sell/en/")
public String home(Model model) {
	List<ArticleTypes> types=(List<ArticleTypes>) typesRepository.findAll();
	List<Sellers> sellers = (List<Sellers>) repository.findAll();
	List<Article_basic_details> articleBasic=(List<Article_basic_details>) articleBdRepository.findAll();
	List<Sellers> filterSellers=GeneralFunctions.removeStartSellerFromList(sellers);
	//log.info(articleBasic.toString());
	//log.info("list of sellers:"+sellers);
	Collections.shuffle(filterSellers);
	Collections.shuffle(types);
	Map<Double,Double> valuesToDisplay=new HashMap<Double,Double>();
	try {
		//need to display maps instead list
		valuesToDisplay=GeneralFunctions.displayPrices(valuesToDisplay,articleBasic);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	model.addAttribute("sell",filterSellers.stream().limit(4).collect(Collectors.toList()));
	model.addAttribute("type",types.stream().limit(4).collect(Collectors.toList()));
	model.addAttribute("basic", valuesToDisplay);
	return "home";
}

@GetMapping("/e-sell/en/loggingout")
public String getLogOutView() {
	return "loggingout";
}

@GetMapping("/logout")
public String redirect() {
	return "/e-sell/en/";
}

@GetMapping("/e-sell/en/products")
public String getProducts(@PageableDefault(size=10) Pageable pageable,Model model) {
	//List<Articles> articles= (List<Articles>) articleRepository.findAll();

	Page<Articles> listOfArticles=articleJpa.findAll(pageable);
	
	List<Articles> list=new ArrayList<Articles>();  
	for (Articles article : listOfArticles) {
		list.add(new Articles(article.getArticle_number(),article.getArticle_name(),article.getSeller()));
	}
	

	listOfArticles=new PageImpl<>(list);
	model.addAttribute("art",listOfArticles);
	model.addAttribute("first",pageable.first());
  


	
	
	
	//model.addAttribute("articles", articles);
	return "products";
}



}
