package sell.articles.types;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import sell.sellers.SellerRepository;

@AllArgsConstructor
@Controller
public class CategoriesController {
	private final TypesRepository repository;

	@GetMapping("/e-sell/en/categories")
	public String getAllCategories(Model model) {
		List<ArticleTypes> categories = (List<ArticleTypes>) repository.findAll();
		model.addAttribute("categories",categories);
		return "categories";
	}
}
