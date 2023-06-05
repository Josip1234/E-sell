package sell.ad;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import sell.articles.Articles;
import sell.articles.types.ArticleTypes;

@Controller
@AllArgsConstructor
@RequestMapping("/e-sell/en/advert")
public class AdvertDetailsController {
private final AdvertDetailsRepo adDetailsRepository;

@ModelAttribute(name = "ad_details")
public Ad_details ad_details() {
return new Ad_details();
}

@GetMapping("/advertDetails")
public String newAdvertDetailsForm() {

	return "advertDetails";
}


}
