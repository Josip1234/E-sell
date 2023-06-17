package sell.ad.delete;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sell.ad.AdvertDetailsRepo;
import sell.articles.ArticleADRepository;
import sell.articles.ArticleBdRepository;
import sell.articles.ArticleJpa;
import sell.articles.ArticleRepository;
import sell.articles.Articles;
import sell.files.StorageRepository;
import sell.functions.GeneralFunctions;
import sell.sellers.SellerRepository;
import sell.sellers.Sellers;
import sell.shipping.ShipDetailRepo;

@Controller
@AllArgsConstructor
@RequestMapping("/e-sell/en/deletion/")
public class AdvertDeletionController {
    private final AdvertDetailsRepo advertDetailsRepo;
    private final ArticleBdRepository articleBdRepository;
    private final ArticleADRepository adRepository;
    private final ArticleRepository articleRepository;
    private final StorageRepository repository;
    private final ShipDetailRepo detailRepo;
    private final SellerRepository repository2;
    
    
    
    @GetMapping("deleteAdvert")
    public String getDeletionFormConfirmation(Model model) {
    	String userEmail=GeneralFunctions.getUserEmail();

		Sellers nickname=repository2.findOne(userEmail);

		List<Articles> articles=articleRepository.findAllByUsername(nickname);
        model.addAttribute("articles",articles);
    	return "deleteAdvert";
    }

    @PostMapping("deleteAdvert")
    public String deleteAdvert(@CookieValue(name = "article_num") String article_num,Model model) {
    	advertDetailsRepo.deleteAll(article_num);
 
    	return "redirect:deleteAdvert";
    }

	
    
}
