package sell.shipping;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Shipping_details {
private Integer id;
private String article_number;
private String shipping;
private String comment;
private String location;
private String delivery;
private String returns;
private String payments; 
}
