package sell.ad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import sell.articles.Articles;

/***
 * 
 * @author Josip Bošnjak
 * This will be used to display artice details on web site.
 *
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ad_details")
public class Ad_details {

	@Null
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	//nije potrebna validacija to će se birati iz tablice artikala, ime u selekt choiceu a id kao vrijednost
	@NonNull
	@NotNull
	@NotBlank(message = "Article number is required.")
	@Column(name="article_num")
	private String article_num;
	@NonNull
	@NotNull(message = "Date is required.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="ad_added")
	private Date ad_added;
	@NonNull
	@NotNull(message = "Date is required.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="ad_last_updated")
	private Date ad_last_updated;
	@NonNull
	@Column(name="time_until_expire")
	private String time_until_expire;
	@NonNull
	@Column(name="ad_shown")
	private String ad_shown;
}
