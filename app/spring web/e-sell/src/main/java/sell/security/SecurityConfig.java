package sell.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	public String[] authenticatedPaths;
	public String[] nonAuthenticatedPaths;
	
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
				"select email,hash_password, 'true' as enabled from Sellers where email=?").passwordEncoder(new BCryptPasswordEncoder()).authoritiesByUsernameQuery("select email,hash_password from Sellers where email = ?");
		}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/e-sell/en/articles/options").authenticated()
		.antMatchers("/e-sell/en/articles/newarticles").authenticated()
		.antMatchers("/e-sell/en/articles/newtype").authenticated()
		.antMatchers("/e-sell/en/articles/insertBasicArticleDetails").authenticated()
		.antMatchers("e-sell/en/articles/uploadFile").authenticated()
		.antMatchers("/e-sell/en/articles/{*article}").permitAll()
		.antMatchers("/e-sell/en/articles/uploadFile").authenticated()
		.antMatchers("/e-sell/en/advert/advertDetails").authenticated()
		.antMatchers("/e-sell/en/seller/profile","/e-sell/en/seller/updatePass").authenticated()
		.antMatchers("/e-sell/en/seller/findAllArticles").authenticated()
		.antMatchers("/e-sell/en/shipping/insertShippingDetails").authenticated()
		.antMatchers("/e-sell/en/deletion/deleteAdvert").authenticated()
		.antMatchers("/e-sell/en/registration","/e-sell/en/","/e-sell/en/seller/updateNotLoggedInPass").permitAll() .and()
		.logout().logoutSuccessUrl("/e-sell/en/").and()
		.formLogin().loginPage("/e-sell/en/login").defaultSuccessUrl("/e-sell/en/seller/profile", true);
		
	}

	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
