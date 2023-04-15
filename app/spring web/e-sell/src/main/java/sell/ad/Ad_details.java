package sell.ad;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/***
 * 
 * @author Josip Bošnjak
 * This will be used to display artice details on web site.
 *
 */
@Data
@RequiredArgsConstructor
public class Ad_details {

	@Null
	private Integer id;
	//nije potrebna validacija to će se birati iz tablice artikala, ime u selekt choiceu a id kao vrijednost
	@NonNull
	private String article_num;
	@NonNull
	@NotNull(message = "Date is required.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ad_added;
	@NonNull
	@NotNull(message = "Date is required.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ad_last_updated;
	@NonNull
	@Null
	private String time_until_expire;
	@NonNull
	@Null
	private String ad_shown;
}
