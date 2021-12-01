package sell.sellers;

import java.util.HashMap;
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
import sell.functions.GeneralFunctions;
import sell.test.data.UserPassImpl;

@Slf4j
@Controller
@RequestMapping("/e-sell/en/seller/")
public class SellerController {
	private final SellerRepository sellerRepository;
	UserPassImpl password= new UserPassImpl();
	Map<String, Sellers> map = new HashMap<>();

	@Autowired
	PasswordEncoder encoder;
	
	public SellerController(SellerRepository sellerRepository) {
		this.sellerRepository = sellerRepository;
	}
	
	@GetMapping("/profile")
	public String getProfile(Model model) {
		Sellers seller=sellerRepository.findOne(GeneralFunctions.getUserEmail());
		model.addAttribute("profile",seller);
		return "profile";
	}
	
	@PostMapping("/profile")
	public String updateProfileData(@ModelAttribute("sellers") Sellers sellers) {
		//treba ažurirati folder od usera treba napraviti u folder klasi funkciju koja će foldere izažurirati zasad neka ostane ovako
		//nakon ažuriranja u test datu ne spremi password o treba popraviti
		sellerRepository.updateProfile(sellers);
		map.put(sellers.getNickname(),sellers);
		password.saveTestData(map,sellers);
		return "redirect:/e-sell/en/";
	}

	//this is for logged in user if he forgot password
	@GetMapping("/updatePass")
	public String showForm(Model model) {
		Sellers seller=sellerRepository.findOne(GeneralFunctions.getUserEmail());
		model.addAttribute("profile",new Sellers());
		return "updateForm";
	}
	
	@PostMapping("/updatePass")
	public String updatePassword(@Valid @ModelAttribute("sellers") Sellers sellers, Errors errors) {
		if(errors.hasErrors()) {
			errors.getClass();
			System.out.println(errors.toString());
			return "updateForm";
		}else {
		Sellers seller=sellerRepository.findOne(GeneralFunctions.getUserEmail());
		log.info(seller.getFname());
		seller.setHash_password(encoder.encode(sellers.getHash_password()));
		sellerRepository.updateProfile(seller);
		return "redirect:/e-sell/en/";
		}
	}
	
	
	
}
