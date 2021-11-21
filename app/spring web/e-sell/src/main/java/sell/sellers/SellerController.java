package sell.sellers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import sell.functions.GeneralFunctions;

@Slf4j
@Controller
@RequestMapping("/e-sell/en/seller/")
public class SellerController {
	private final SellerRepository sellerRepository;

	public SellerController(SellerRepository sellerRepository) {
		this.sellerRepository = sellerRepository;
	}
	
	@GetMapping("/profile")
	public String getProfile(Model model) {
		Sellers seller=sellerRepository.findOne(GeneralFunctions.getUserEmail());
		model.addAttribute("profile",seller);
		return "profile";
	}
	
	

}
