package sell.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	public String[] authenticatedPaths;
	public String[] nonAuthenticatedPaths;
	
	@Autowired
	DataSource dataSource;

	/*~~(Migrate manually based on https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter)~~>*/@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
				"select email,hash_password, 'true' as enabled from Sellers where email=?").passwordEncoder(new BCryptPasswordEncoder()).authoritiesByUsernameQuery("select email,hash_password from Sellers where email = ?");
		}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(requests -> requests.requestMatchers("/e-sell/en/articles/options").authenticated()
                .requestMatchers("/e-sell/en/articles/newarticles").authenticated()
                .requestMatchers("/e-sell/en/articles/newtype").authenticated()
                .requestMatchers("/e-sell/en/articles/insertBasicArticleDetails").authenticated()
                .requestMatchers("e-sell/en/articles/uploadFile").authenticated()
                .requestMatchers("/e-sell/en/articles/{*article}").permitAll()
                .requestMatchers("/e-sell/en/articles/uploadFile").authenticated()
                .requestMatchers("/e-sell/en/advert/advertDetails").authenticated()
                .requestMatchers("/e-sell/en/seller/profile", "/e-sell/en/seller/updatePass").authenticated()
                .requestMatchers("/e-sell/en/seller/findAllArticles").authenticated()
                .requestMatchers("/e-sell/en/shipping/insertShippingDetails").authenticated()
                .requestMatchers("/e-sell/en/deletion/deleteAdvert").authenticated()
                .requestMatchers("/e-sell/en/registration", "/e-sell/en/", "/e-sell/en/seller/updateNotLoggedInPass").permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/e-sell/en/"))
                .formLogin(login -> login.loginPage("/e-sell/en/login").defaultSuccessUrl("/e-sell/en/seller/profile", true));
		
	}

	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
