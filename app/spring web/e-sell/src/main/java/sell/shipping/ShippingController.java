package sell.shipping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/e-sell/en/shipping")
public class ShippingController {
	
	@ModelAttribute(name = "Shipping_details")
	public Shipping_details shippingDetails() {
	return new Shipping_details();
	}
	
@GetMapping("/insertShippingDetails")
public String getShippingForm(Model model, @RequestParam(required = false) String article_number) {
	
	model.addAttribute("shipping", shippingDetails());
	return "insertShippingDetails";
}
}
