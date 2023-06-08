package sell.ad;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import sell.articles.ArticleJpa;
import sell.articles.ArticleRepository;
import sell.articles.Articles;
import sell.articles.types.ArticleTypes;
import sell.functions.GeneralFunctions;
import sell.sellers.SellerRepository;

@Controller
@AllArgsConstructor
@RequestMapping("/e-sell/en/advert")
public class AdvertDetailsController {
private final AdvertDetailsRepo adDetailsRepository;
private final ArticleJpa articleRepository;
private final SellerRepository repository;

@ModelAttribute(name = "ad_details")
public Ad_details ad_details() {
return new Ad_details();
}

@GetMapping("/advertDetails")
public String newAdvertDetailsForm(Model model) {
	String email = GeneralFunctions.getUserEmail();

	String user=repository.findOne(email).getNickname();

    List<Articles> articles = articleRepository.findArticlesOfLoggedInUser(user);
    System.out.println(articles.toString());
    model.addAttribute("articles",articles);
	return "advertDetails";
}


}
