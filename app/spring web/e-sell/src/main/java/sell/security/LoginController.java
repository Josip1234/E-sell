package sell.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Controller
public class LoginController {
	
	@GetMapping("/e-sell/en/login")
	public String getLogin() {
		return "login";
	}

	public void addViewControllers(ViewControllerRegistry registry) {
	
		registry.addViewController("/e-sell/en//login");
	}
}
