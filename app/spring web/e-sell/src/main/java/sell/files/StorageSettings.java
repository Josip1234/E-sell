package sell.files;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageSettings {
private String location="src/main/resources/static/images/";

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

}
