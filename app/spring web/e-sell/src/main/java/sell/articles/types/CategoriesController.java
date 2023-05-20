package sell.articles.types;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class CategoriesController {
	private final ArtTypJpa artTypJpa;

	@GetMapping("/e-sell/en/categories")
	public String getAllCategories(Model model,@RequestParam(required = false)String keyword, @RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "5") int size) {
		List<ArticleTypes> categories= new ArrayList<ArticleTypes>();
		 PageRequest paging = PageRequest.of(page - 1, size);
	      Page<ArticleTypes> pageType;
	      if (keyword == null) {
	    	  pageType = artTypJpa.findAll(paging);
		      } else {
		    	  pageType = artTypJpa.findAll(paging);
		        model.addAttribute("keyword", keyword);
		      }
	      categories= pageType.getContent();
        
	    model.addAttribute("currentPage", pageType.getNumber() + 1);
	      model.addAttribute("totalItems", pageType.getTotalElements());
	      model.addAttribute("totalPages", pageType.getTotalPages());
	      model.addAttribute("pageSize", size);
		model.addAttribute("categories",categories);
		return "categories";
	}
	
}
