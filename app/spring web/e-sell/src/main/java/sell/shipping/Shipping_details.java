package sell.shipping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Shipping_details {
private Integer id;
@NonNull
private String article_number;
@NonNull
private String shipping;
@NonNull
private String comment;
@NonNull
private String location;
@NonNull
private String delivery;
@NonNull
private String returns;
@NonNull
private String payments; 
}
