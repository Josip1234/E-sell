package sell.shipping;

public interface ShipDetailRepo {
Shipping_details save(Shipping_details details);
Shipping_details readDetails(String article_number);
}
