package sell.sellers;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import sell.password.ValidPassword;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sellers")
public class Sellers {
	@Null
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@NotNull
	@NonNull
	@NotBlank(message = "First name is required.")
	@Size(min = 1, max = 50, message = "Name must be between 1 and 50 letters.")
	@Column(name="fname")
	private String fname;
	@NotNull
	@NonNull
	@NotBlank(message = "Last name is required.")
	@Size(min=1,max=50, message = "Last name must be between 1 and 50 letters.")
	@Column(name="lname")
	private String lname;
	@NotNull(message = "Date of birth is required.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="dateofbirth")
	private Date dateofbirth;
	@NotNull
	@NonNull
	@NotBlank(message = "Location is required.")
	@Size(min=1, message = "Location must contain at least 1 letter.")
	@Column(name="location")
	private String location;
	@NonNull
	@NotNull
	@NotBlank(message = "Nickname is required.")
	@Size(min=1, max=50, message ="Nickname must be between 1 and 50 letters.")
	//trebamo napisati validaciju za nickname jer ne smije dva nicknamea biti u bazi
	//za dupli email ista stvar.
	@Column(name="nickname")
	private String nickname;
	@NonNull
	@NotNull
	@NotBlank(message = "Contact is required.")
	@Size(min=1, max=150, message = "Contact must be between 1 and 150 letters.")
	@Column(name="contact")
	private String contact;
	@NotNull
	@NonNull
	@NotBlank(message = "Email is required.")
	@Size(min=10, max=50, message = "Email must have at least 10 letters, or 50 letters max.")
	@Email(message = "Email must be correct.")
	@Column(name="email")
	private String email;
	@NonNull
	@NotNull
	@NotBlank(message = "Password is required.")
	@Size(min=8, message = "Password must have at least 8 leters.")
	@ValidPassword
	@Column(name="hash_password")
	private String hash_password;
	@NonNull
	@NotNull
	private String type_of_user;
	
	
 
	public Sellers() {
		this.type_of_user=TypeOfUser.Seller.toString();
	}
	
	public Sellers(Integer id,String nickname, String location, String contact,String type_of_user) {
	    this.id=id;
		this.contact=contact;
		this.nickname=nickname;
		this.location=location;
		this.type_of_user=type_of_user;
	}
	public Sellers(String nickname, String location, String contact,String type_of_user) {
		this.contact=contact;
		this.nickname=nickname;
		this.location=location;
		this.type_of_user=type_of_user;
	}

	public Sellers(String nickname) {
		this.nickname=nickname;
	}
	
	
	  @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	public Sellers(String fname,String lname,String nickname, String location, String contact, String email,String hash_password) {
		this.fname = fname;
		this.lname = lname;
		this.location = location;
		this.nickname = nickname;
		this.contact = contact;
		this.email = email;
		this.hash_password = hash_password;
	}
	
	

	  
}
