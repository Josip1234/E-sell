package sell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import sell.files.StorageSettings;
/***
 * 
 * @author Josip Bošnjak
 * @version 1.0.0.
 * Web java application for display and sell of various products.
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(StorageSettings.class)
public class ESellApplication {

	public static void main(String[] args) {
		SpringApplication.run(ESellApplication.class, args);
	}

}
