package sell.homepage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import sell.articles.types.ArticleTypes;
import sell.articles.types.TypesRepository;
import sell.sellers.SellerRepository;
import sell.sellers.Sellers;

@Slf4j
@Controller
public class HomePageController {
	private final SellerRepository repository;
	private final TypesRepository typesRepository;
	
	@Autowired
	public HomePageController(SellerRepository repository, TypesRepository typesRepository) {
		this.repository=repository;
		this.typesRepository=typesRepository;
	}
@GetMapping("/e-sell/en/")
public String home(Model model) {
	List<ArticleTypes> types=(List<ArticleTypes>) typesRepository.findAll();
	List<Sellers> sellers = (List<Sellers>) repository.findAll();
	//log.info("list of sellers:"+sellers);
	Collections.shuffle(sellers);
	Collections.shuffle(types);
	model.addAttribute("sell",sellers.stream().limit(4).collect(Collectors.toList()));
	model.addAttribute("type",types.stream().limit(4).collect(Collectors.toList()));
	return "home";
}

}
