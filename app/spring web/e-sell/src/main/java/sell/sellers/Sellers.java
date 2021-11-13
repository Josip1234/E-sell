package sell.sellers;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sell.password.ValidPassword;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Sellers {
	@Null
	private Integer id;
	@NotNull
	@NotBlank(message = "First name is required.")
	@Size(min = 1, max = 50, message = "Name must be between 1 and 50 letters.")
	private String fname;
	@NotNull
	@NotBlank(message = "Last name is required.")
	@Size(min=1,max=50, message = "Last name must be between 1 and 50 letters.")
	private String lname;
	@NotNull(message = "Date of birth is required.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateofbirth;
	@NotNull
	@NotBlank(message = "Location is required.")
	@Size(min=1, message = "Location must contain at least 1 letter.")
	private String location;
	@NonNull
	@NotNull
	@NotBlank(message = "Nickname is required.")
	@Size(min=1, max=50, message ="Nickname must be between 1 and 50 letters.")
	private String nickname;
	@NotNull
	@NotBlank(message = "Contact is required.")
	@Size(min=1, max=150, message = "Contact must be between 1 and 150 letters.")
	private String contact;
	@NotNull
	@NotBlank(message = "Email is required.")
	@Size(min=10, max=50, message = "Email must have at least 10 letters, or 50 letters max.")
	@Email(message = "Email must be correct.")
	private String email;
	@NonNull
	@NotNull
	@NotBlank(message = "Password is required.")
	@Size(min=8, message = "Password must have at least 8 leters.")
	@ValidPassword
	private String hash_password;

	public Sellers(Integer id,String nickname, String location, String contact) {
	    this.id=id;
		this.contact=contact;
		this.nickname=nickname;
		this.location=location;
	}
	public Sellers(String nickname, String location, String contact) {
		this.contact=contact;
		this.nickname=nickname;
		this.location=location;
	}

	public Sellers(String nickname) {
		this.nickname=nickname;
	}
	
	  @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
