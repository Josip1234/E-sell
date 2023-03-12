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
	
	
}
