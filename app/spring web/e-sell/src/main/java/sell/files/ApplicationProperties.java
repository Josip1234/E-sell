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
	private Map<String,String> springDatasourceDriver;
	private Map<String,String> springJpa;
	private Map<String,String> springHibernateFormatSql;
	private Map<String,String> springDatasourceUrl;
	private Map<String,String> springDatasourceUsername;
	private Map<String,String> springDatasourcePassword;
	private Map<String,String> springMultipartMaxFileSize;
	private Map<String,String> springMUltipartMaxRequestSize;
	private Map<String,String> springMultipartEnabled;
	private Map<String,String> springMultipartLocation;
	private Map<String,String> springWebResourcesStaticLocation;
	
	
	public boolean setDefaultValues(String datasourceDriver,String username,String password,String staticLocation) {
	String tempKey="";
	Map<String,String> tempMap=new HashMap<String,String>();
	tempKey="spring.datasource.driver-class-name";
	tempMap.put(tempKey, datasourceDriver);
	System.out.println(tempMap);
	this.springDatasourceDriver=tempMap;
	tempKey="";
	tempMap.clear();
	tempKey="spring.datasource.username";
	tempMap.put(tempKey, username);
	System.out.println(tempMap);
	this.springDatasourceUsername=tempMap;
	tempMap.clear();
	tempKey="";
	tempKey="spring.datasource.password";
	tempMap.put(tempKey, password);
	this.springDatasourcePassword=tempMap;
	System.out.println(tempMap);
	tempKey="";
	tempMap.clear();
	tempKey="spring.web.resources.static-locations";
	tempMap.put(tempKey, staticLocation);
	this.springWebResourcesStaticLocation=tempMap;
	System.out.println(tempMap);
	tempMap.clear();
	tempKey="";
 	return true;	
	}


	public void printProperties() {
		 System.out.println(getSpringDatasourceDriver());
		 
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
