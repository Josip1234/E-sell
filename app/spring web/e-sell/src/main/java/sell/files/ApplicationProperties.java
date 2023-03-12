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
	
	
	public boolean setDefaultValues(String datasourceDriver,String username,String password,String staticLocation) {
	String tempKey="";
	tempKey="spring.datasource.driver-class-name";
	getSpringDatasourceDriver().put(tempKey, datasourceDriver);
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
