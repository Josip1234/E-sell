package sell.ad;

import java.math.BigInteger;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ad_details {

	@Null
	private Integer id;
	//nije potrebna validacija to će se birati iz tablice artikala, ime u selekt choiceu a id kao vrijednost
	private BigInteger article_num;
	@NotNull(message = "Date is required.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ad_added;
	@NotNull(message = "Date is required.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ad_last_updated;
	@Null
	private String time_until_expire;
	@Null
	private String ad_shown;
}
