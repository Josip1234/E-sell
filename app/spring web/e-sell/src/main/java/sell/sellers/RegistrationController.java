package sell.sellers;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import sell.files.Folder;
import sell.functions.GeneralFunctions;
import sell.test.data.UserPassImpl;

@Slf4j
@Controller
@RequestMapping("/e-sell/en/registration")
public class RegistrationController {
	private final SellerRepository repository;
	
	Folder folders = new Folder();
	UserPassImpl password= new UserPassImpl();
	Map<String, Sellers> map = new HashMap<>();
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	public RegistrationController(SellerRepository repository) {
		this.repository=repository;
	}
@GetMapping
public String registration(Model model) {
	model.addAttribute("sellers", new Sellers());
	return  "registration";
}
@PostMapping
public String registerSeller(@Valid @ModelAttribute("sellers") Sellers sellers, Errors errors) {
	boolean doesExists=false;
	sellers.setType_of_user(TypeOfUser.Seller.toString());
	List<Sellers> findAll= (List<Sellers>) repository.findAll();
    doesExists=GeneralFunctions.findInAList(sellers.getNickname(),findAll);
	if(doesExists==true) {
		return "registration";
	}else {
		if(errors.hasErrors()) {
			errors.getClass();
			System.out.println(errors.toString());
			return "registration";
		}else {
			map.put(sellers.getNickname(),sellers);
			//password.saveTestData(map,sellers);
			//log.info("Values:"+sellers);
			sellers.setHash_password(encoder.encode(sellers.getHash_password()));
			repository.save(sellers);
			folders.createFolder(sellers);
			return "redirect:/e-sell/en/";
		}
	}

}
}
