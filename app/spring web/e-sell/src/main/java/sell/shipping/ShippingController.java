package sell.shipping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dynamic.picture.gallery.entity.GalleryData;

@Controller
@RequestMapping("/e-sell/en/shipping")
public class ShippingController {
	
	@ModelAttribute(name = "Shipping_details")
	public Shipping_details shippingDetails() {
	return new Shipping_details();
	}
	
@GetMapping("/insertShippingDetails")
public String getShippingForm() {
	return "insertShippingDetails";
}
}
