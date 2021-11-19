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

@Slf4j
@Controller
@RequestMapping("/e-sell/en/articles")
public class ArticleController {

	private final TypesRepository repository;
	
	
	
	public ArticleController(TypesRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/options")
	public String options() {
		return "options";
	}
	
	@GetMapping("/newarticles")
	public String newarticles() {
		return "newarticles";
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
