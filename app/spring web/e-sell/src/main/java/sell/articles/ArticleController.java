package sell.articles;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import sell.articles.types.ArticleTypes;
import sell.articles.types.TypesRepository;
import sell.files.Folder;
import sell.functions.GeneralFunctions;
import sell.sellers.SellerRepository;
import sell.sellers.Sellers;

@Slf4j
@Controller
@RequestMapping("/e-sell/en/articles")
public class ArticleController {

	private final TypesRepository repository;
	private final ArticleRepository articleRepository;
	private final SellerRepository sellerRepository;
	
	Folder folder=new Folder();
	
	public ArticleController(TypesRepository repository, ArticleRepository articleRepository,SellerRepository sellerRepository) {
		this.repository = repository;
		this.articleRepository=articleRepository;
		this.sellerRepository=sellerRepository;
	}

	@GetMapping("/options")
	public String options() {
		return "options";
	}
	
	@GetMapping("/newarticles")
	public String newarticles(Model model) {
		model.addAttribute("article", new Articles());
		return "newarticles";
	}
	@PostMapping("/newarticles")
	public String addArticle(@Valid @ModelAttribute("article") Articles articles, Errors errors) {
		Sellers sellers=sellerRepository.findOne(GeneralFunctions.getUserEmail());
		articles.setSeller(sellers.getNickname());
		log.info(sellers.getNickname());

		if(errors.hasErrors()) {
			errors.getClass();
			System.out.println(errors.toString());
			return "newarticles";
		}else {
			log.info("Values:"+articles);
			articleRepository.save(articles);
			folder.createFolder(articles);
			return "redirect:/e-sell/en/";
		}
	}
	
	
	@GetMapping("/newtype")
	public String newtype(Model model) {
		model.addAttribute("type", new ArticleTypes());
		return "newtype";
	}
	
	@PostMapping("/newtype")
	public String addtype(@Valid @ModelAttribute("type") ArticleTypes types, Errors errors) {
		if(errors.hasErrors()) {
			errors.getClass();
			System.out.println(errors.toString());
			return "newtype";
		}else {
			log.info("Values:"+types);
			repository.save(types);
			return "redirect:/e-sell/en/articles/newarticles";
		}
		
	}

	
}
