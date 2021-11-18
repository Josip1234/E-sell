package sell.articles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ArticleController {

	@GetMapping("/e-sell/en/articles/options")
	public String options() {
		return "options";
	}
	
	@GetMapping("/e-sell/en/articles/newarticles")
	public String newarticles() {
		return "newarticles";
	}
	@GetMapping("/e-sell/en/articles/newtype")
	public String newtype() {
		return "newtype";
	}
	
}
