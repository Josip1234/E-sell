package sell.articles;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;
import sell.articles.types.ArticleTypes;
import sell.articles.types.TypesRepository;
import sell.files.Folder;
import sell.files.ImageStorageService;
import sell.files.StorageFileNotFoundException;
import sell.functions.GeneralFunctions;
import sell.sellers.SellerRepository;
import sell.sellers.Sellers;

/***
 * 
 * @author Josip Bošnjak
 * This is controller for displaying views of option menu, adding new articles, adding new types, for display article basic details, 
 * and insert new basic article details. Also new folder is being made for every new article, from existing user, which is being 
 * found by general function.
 *
 */
@Slf4j
@Controller
@RequestMapping("/e-sell/en/articles")
public class ArticleController {

    /***
     * Repositories for database operations
     */
	private final TypesRepository repository;
	private final ArticleRepository articleRepository;
	private final SellerRepository sellerRepository;
	private final ArticleBdRepository articleBdRepository;
	private final ImageStorageService imageStorageService;
	
	//empty object for making new folder
	Folder folder=new Folder();
	
	/***
	 * @author Josip Bošnjak
	 * @param repository 
	 * @param articleRepository
	 * @param sellerRepository
	 * @param articleBdRepository
	 * Repository injection
	 */
	public ArticleController(TypesRepository repository, ArticleRepository articleRepository,SellerRepository sellerRepository, ArticleBdRepository articleBdRepository, ImageStorageService imageStorageService) {
		this.repository = repository;
		this.articleRepository=articleRepository;
		this.sellerRepository=sellerRepository;
		this.articleBdRepository=articleBdRepository;
		this.imageStorageService=imageStorageService;
	}
    /***
     * @author Josip Bošnjak
     * @return option view on web site
     */
	@GetMapping("/options")
	public String options() {
		return "options";
	}
	/***
	 * @author Josip Bošnjak
	 * @param model adding article empty object to thymeleaf view
	 * @return view of new articles
	 */
	@GetMapping("/newarticles")
	public String newarticles(Model model) {
		model.addAttribute("article", new Articles());
		return "newarticles";
	}
	/***
	 * @author Josip Bošnjak
	 * @param articles accept values from form from user.
	 * @param errors 
	 * @return newarticles if not valid value. If values are valid, it will return redirect for insert new article basic details.
	 */
	@PostMapping("/newarticles")
	public String addArticle(@Valid @ModelAttribute("article") Articles articles, Errors errors) {
		//get logged in user
		Sellers sellers=sellerRepository.findOne(GeneralFunctions.getUserEmail());
		//set seller nickname to article field of seller, it is a foreign key to nickname in seller table
		articles.setSeller(sellers.getNickname());
		//print seller nickname to check if it is the real value
		//log.info(sellers.getNickname());
        //if values from form have errors print errors and return to the form and display errors to the form 
		//else insert new article in database using jdbc template repository and redirect user to insert basic details of this new
		//article.
		if(errors.hasErrors()) {
			errors.getClass();
			//System.out.println(errors.toString());
			return "newarticles";
		}else {
			//log.info("Values:"+articles);
			articleRepository.save(articles);
			folder.createFolder(articles);
			return "redirect:insertBasicArticleDetails";
		}
	}
	
	/***
	 * @author Josip Bošnjak
	 * @param model add empty article type object to the thymeleaf html file
	 * @return newtype form
	 */
	@GetMapping("/newtype")
	public String newtype(Model model) {
		model.addAttribute("type", new ArticleTypes());
		return "newtype";
	}
	
	/***
	 * @author Josip Bošnjak
	 * @param types recieve form from data
	 * @param errors 
	 * @return form from newtype and display errors in view if there are no errors save new type
	 */
	@PostMapping("/newtype")
	public String addtype(@Valid @ModelAttribute("type") ArticleTypes types, Errors errors) {
		if(errors.hasErrors()) {
			errors.getClass();
			//System.out.println(errors.toString());
			return "newtype";
		}else {
			//log.info("Values:"+types);
			repository.save(types);
			return "redirect:/e-sell/en/articles/newarticles";
		}
		
	}
	/***
	 * @author Josip Bošnjak
	 * @param request get current url from site
	 * @param model add list of values from article details to thymeleaf html file
	 * @return article details view
	 * This function recieves current url request, then it is using cleanup function to get only last part of the url, from homepage criteria,
	 * which is price.
	 * After that, list is being created by querying article basic details repository. 
	 * After that, new list is created by using another cleanup function. We need clean prices, only numbers from string.
	 * We are getting final list which will be displayed in a view to user. That list is a list of objects with search criteria
	 * from the homepage. It will display values up to price 
	 * need to update this to display all products in selected range..
	 */
@GetMapping("/{*article}")
public String getDetails(HttpServletRequest request, Model model) {
    String url= ServletUriComponentsBuilder.fromRequestUri(request).toUriString();
    //log.info("Map entry "+url);
    String replacedUrl=GeneralFunctions.replaceURL(url);
    //log.info("Replaced url "+url);
    List<Article_basic_details> article_basic_details=(List<Article_basic_details>) articleBdRepository.findAll();
    List<Article_basic_details> getNumbersFromList=GeneralFunctions.removeStringFromPrice(article_basic_details);
    List<Article_basic_details> getFinalList=GeneralFunctions.findAllObjectsByPrice(getNumbersFromList, replacedUrl);
    model.addAttribute("basic", getFinalList);
	return "article_details";
}
/***
 * @author Josip Bošnjak
 * @param model get view for insert new basic detail for articles
 * @return insert basic article details view
 * This function finds list of article types. They are added to view, as select choice. 
 * There are three select options for article types. They are using the same list. However, only 
 * one value can be selected from one select choice, and must be unique to other select choices.
 */
@GetMapping("/insertBasicArticleDetails")
public String getForm(Model model) {
	List<ArticleTypes> types= (List<ArticleTypes>) repository.findAll();
	model.addAttribute("types",types);
	model.addAttribute("bdetails", new Article_basic_details());
	return "insertBasicArticleDetails";
}

/***
 * After basic details has been written, redirect to the form for uploading images of products.
 * @author Josip Bošnjak
 * @param bdetails get values from form input for article basic details
 * @param errors
 * @param article_numb get hidden field from article number it is foreign key from articles
 * @return form if there are erors, save details if form is correctly fullfilled by user.
 */
@PostMapping("/insertBasicDetails")
public String addProductBasicDetails(@Valid @ModelAttribute("bdetails") Article_basic_details bdetails,Errors errors ,@ModelAttribute("article_numb") String article_numb ) {
    if(errors.hasErrors()) {
    	errors.getClass();
    	return "insertBasicArticleDetails";
    }else {
    	articleBdRepository.save(article_numb,bdetails);
    	return "redirect:uploadFile";
    }
}

/***
 * @author Josip Bošnjak
 * @return form for uploading images of products
 *we need to get coockies here see file:///C:/Users/Korisnik/Desktop/Tutorials/docs/spring%205/java%20-%20get%20cookie%20value%20by%20name%20in%20spring%20mvc%20-%20Stack%20Overflow.html
 */
@GetMapping("/uploadFile")
public String getUploadForm(@CookieValue(value="article_number", required = false) String article_number,Model model) throws IOException {
	String email=GeneralFunctions.getUserEmail();
	//System.out.println("Email:"+email);
	if(email!="anonymousUser") {
		
	
	//log.info(article_number);
	model.addAttribute("files", imageStorageService.loadAll().map(
			path -> MvcUriComponentsBuilder.fromMethodName(ArticleController.class,
					"serveFile", path.getFileName().toString()).build().toUri().toString())
			.collect(Collectors.toList()));

	return "uploadFile";
	}else {
		return "redirect:/e-sell/en/";
	}
	
}


@GetMapping("/files/{filename:.+}")
@ResponseBody
public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
    //log.info("success");
	Resource file = imageStorageService.loadAsResource(filename);
	return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
			"attachment; filename=\"" + file.getFilename() + "\"").body(file);
}

@PostMapping("/uploadFile")
public String handleFileUpload(@CookieValue(value="article_number", required = false) String article_number, @RequestParam("file") MultipartFile file,
		RedirectAttributes redirectAttributes) {
     //log.info("success");
      String nickname=GeneralFunctions.getUserEmail();
      Sellers seller=sellerRepository.findOne(nickname);
      nickname=seller.getNickname();
	imageStorageService.storeFile(nickname,article_number,file);
	redirectAttributes.addFlashAttribute("message",
			"You successfully uploaded " + file.getOriginalFilename() + "!");

	return "redirect:/";
}

@ExceptionHandler(StorageFileNotFoundException.class)
public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
	//log.info("success");
	return ResponseEntity.notFound().build();
}



}
