package sell.files;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationProperties {
	private Map<String,String> springDatasourceDriver = new HashMap<String,String>();
	private Map<String,String> springJpa= new HashMap<String,String>();
	private Map<String,String> springHibernateFormatSql= new HashMap<String,String>();
	private Map<String,String> springDatasourceUrl= new HashMap<String,String>();
	private Map<String,String> springDatasourceUsername= new HashMap<String,String>();
	private Map<String,String> springDatasourcePassword= new HashMap<String,String>();
	private Map<String,String> springMultipartMaxFileSize= new HashMap<String,String>();
	private Map<String,String> springMUltipartMaxRequestSize= new HashMap<String,String>();
	private Map<String,String> springMultipartEnabled= new HashMap<String,String>();
	private Map<String,String> springMultipartLocation= new HashMap<String,String>();
	private Map<String,String> springWebResourcesStaticLocation= new HashMap<String,String>();
	
	
	public boolean setDefaultValues(String datasourceDriver,String username,String password,String staticLocation,String datasourceUrl) {
	String tempKey="";
	tempKey="spring.datasource.driver-class-name";
	getSpringDatasourceDriver().put(tempKey, datasourceDriver);
	tempKey="spring.datasource.username";
	getSpringDatasourceUsername().put(tempKey, username);
	tempKey="spring.datasource.password";
	getSpringDatasourcePassword().put(tempKey, password);
	tempKey="spring.web.resources.static-locations";
	getSpringWebResourcesStaticLocation().put(tempKey, staticLocation);
	tempKey="spring.jpa.show-sql";
	getSpringJpa().put(tempKey, "true");
	tempKey="spring.jpa.properties.hibernate.format_sql";
	getSpringHibernateFormatSql().put(tempKey, "true");
	tempKey="spring.datasource.url";
	getSpringDatasourceUrl().put(tempKey, datasourceUrl);
	tempKey="spring.servlet.multipart.max-file-size";
	getSpringMultipartMaxFileSize().put(tempKey, "-1");
	tempKey="spring.servlet.multipart.max-request-size";
	getSpringMUltipartMaxRequestSize().put(tempKey, "-1");
	tempKey="spring.servlet.multipart.enabled";
	getSpringMultipartEnabled().put(tempKey, "true");
	tempKey="spring.servlet.multipart.location";
	getSpringMultipartLocation().put(tempKey, "${java.io.tmpdir}");
 	return true;	
	}


	public void printProperties() {
		 System.out.println(getSpringDatasourceDriver());
		 System.out.println(getSpringJpa());
		 System.out.println(getSpringHibernateFormatSql());
		 System.out.println(getSpringDatasourceUrl());
		 
		 System.out.println(getSpringDatasourceUsername());
		 System.out.println(getSpringDatasourcePassword());
		 
		 System.out.println(getSpringMultipartMaxFileSize());
		 System.out.println(getSpringMUltipartMaxRequestSize());
		 System.out.println(getSpringMultipartEnabled());
		 System.out.println(getSpringMultipartLocation());
		 System.out.println(getSpringWebResourcesStaticLocation());
		
	}



	
	
	/*
			spring.jpa.show-sql=true
			spring.jpa.properties.hibernate.format_sql=true
			spring.datasource.url=jdbc:mysql://localhost:3306/esell
	
			
			spring.servlet.multipart.max-file-size=-1
			spring.servlet.multipart.max-request-size=-1
			spring.servlet.multipart.enabled=true
			spring.servlet.multipart.location=${java.io.tmpdir}
			*/

}
