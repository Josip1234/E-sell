package sell.sellers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import lombok.extern.slf4j.Slf4j;
import sell.articles.ArticleRepository;
import sell.articles.Article_basic_details;
import sell.articles.Articles;
import sell.functions.GeneralFunctions;
import sell.test.data.OutputInputUserEmailPass;
import sell.test.data.UserPassImpl;

@Slf4j
@Controller
@RequestMapping("/e-sell/en/seller/")
public class SellerController {
	private final SellerRepository sellerRepository;
	private final ArticleRepository articleRepository;
	private final SellerJpaRep jpaRep;
	
	UserPassImpl password= new UserPassImpl();
	Map<String, Sellers> map = new HashMap<>();

	@Autowired
	PasswordEncoder encoder;
	
	public SellerController(SellerRepository sellerRepository, ArticleRepository articleRepository,SellerJpaRep seller) {
		this.sellerRepository = sellerRepository;
		this.articleRepository=articleRepository;
		this.jpaRep=seller;
	}
	
	@GetMapping("/profile")
	public String getProfile(Model model) {
		Sellers seller=sellerRepository.findOne(GeneralFunctions.getUserEmail());
		model.addAttribute("profile",seller);
       System.out.println(seller.toString());
        if(seller.getType_of_user()==null) {
        	seller.setType_of_user(sellerRepository.findTypeOfUser(GeneralFunctions.getUserEmail()).getType_of_user());
        	System.out.println(seller.getType_of_user());
        	model.addAttribute("type",seller);
        	model.addAttribute("profile",seller);
        
        }else {
        	model.addAttribute("type",seller.getType_of_user());
        	model.addAttribute("profile",seller);
        	  System.out.println(seller.getType_of_user());
        }
    	
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
	
	@GetMapping("/profile/test_data")
	public String getSwingApplication() {
		System.setProperty("java.awt.headless", "false");
		OutputInputUserEmailPass emailPass = new OutputInputUserEmailPass();
		emailPass.runSwing();
		return "redirect:/e-sell/en/seller/profile";
	}
	
	@GetMapping("/findAllArticles")
	public String findAllArticlesOfUser(Model model) {
		String userEmail=GeneralFunctions.getUserEmail();
		Sellers nickname=sellerRepository.findOne(userEmail);
		List<Articles> articles=articleRepository.findAllByUsername(nickname);
		model.addAttribute("articles", articles);
		return "findAllArticles";
	}

	//for non logged in users password update
	@GetMapping("/updateNotLoggedInPass")
	public String getNotLoggedIn() {
		return "updateNotLoggedInPass";
	}
	
	//this is for logged in user if he forgot password
	@GetMapping("/updatePass")
	public String showForm(Model model) {
		Sellers seller=sellerRepository.findOne(GeneralFunctions.getUserEmail());
		model.addAttribute("profile",new Sellers());
		return "updateForm";
	}
	
	@PostMapping("/updatePass")
	public String updatePassword(@Valid @ModelAttribute("profile") Sellers sellers, Errors errors) {
		if(errors.hasErrors()) {
			errors.getClass();
			//System.out.println(errors.toString());
			return "updateForm";
		}else {
		Sellers seller=sellerRepository.findOne(GeneralFunctions.getUserEmail());
		//log.info(seller.getFname());
		seller.setHash_password(encoder.encode(sellers.getHash_password()));
		sellerRepository.updateProfile(seller);
		return "redirect:/e-sell/en/";
		}
	}

	@GetMapping("/sellers")
	public String getSellers(Model model,@RequestParam(required = false)String keyword, @RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "5") int size) {
		List<Sellers> sellers= new ArrayList<Sellers>();
		 Pageable paging = PageRequest.of(page - 1, size);
	      Page<Sellers> pageSeller;
	      if (keyword == null) {
		        pageSeller = jpaRep.findAll(paging);
		      } else {
		    	  pageSeller = jpaRep.findAll(paging);
		        model.addAttribute("keyword", keyword);
		      }
            sellers=pageSeller.getContent();
         
		model.addAttribute("sellers",sellers);
	    model.addAttribute("currentPage", pageSeller.getNumber() + 1);
	      model.addAttribute("totalItems", pageSeller.getTotalElements());
	      model.addAttribute("totalPages", pageSeller.getTotalPages());
	      model.addAttribute("pageSize", size);
		return "sellers";
	}
	

	
}
