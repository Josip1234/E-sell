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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.extern.slf4j.Slf4j;
import sell.articles.ArticleBdRepository;
import sell.articles.ArticleJpaRep;
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
	private final ArticleJpaRep articleJpaRep;
	
	@Autowired
	public HomePageController(SellerRepository repository, TypesRepository typesRepository, ArticleBdRepository articleBdRepository, ArticleRepository articleRepository, ArticleJpaRep jpaRep) {
		this.repository=repository;
		this.typesRepository=typesRepository;
		this.articleBdRepository=articleBdRepository;
		this.articleRepository=articleRepository;
		this.articleJpaRep=jpaRep;
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
	
	
	Page<Articles> listOfArticles=articleJpaRep.findAll(pageable);
	System.out.println(listOfArticles);
	
	List<Articles> articles=new ArrayList<Articles>();  
	for (Articles art : articles) {
		
		articles.add(new Articles(art.getId(),art.getArticle_number(),art.getArticle_name(),art.getSeller()));
	}
	

    listOfArticles=new PageImpl<>(articles);
	
    
	model.addAttribute("articles", listOfArticles);
	return "products";
}

}
