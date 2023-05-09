package sell.shipping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/e-sell/en/shipping")
public class ShippingController {
@GetMapping("/insertShippingDetails")
public String getShippingForm() {
	return "insertShippingDetails";
}
}
