package sell.sellers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import sell.files.CreateFolders;

@Slf4j
@Controller
@RequestMapping("/e-sell/en/registration")
public class RegistrationController {
	private final SellerRepository repository;
	
	CreateFolders folders;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	public RegistrationController(SellerRepository repository, CreateFolders folders) {
		this.repository=repository;
		this.folders=folders;
	}
@GetMapping
public String registration(Model model) {
	model.addAttribute("sellers", new Sellers());
	return("registration");
}
@PostMapping
public String registerSeller(@Valid @ModelAttribute("sellers") Sellers sellers, Errors errors) {
	if(errors.hasErrors()) {
		errors.getClass();
		System.out.println(errors.toString());
		return "registration";
	}else {
		log.info("Values:"+sellers);
		sellers.setHash_password(encoder.encode(sellers.getHash_password()));
		repository.save(sellers);
		folders.createFolder(sellers);
		return "redirect:/e-sell/en/";
	}

}
}
