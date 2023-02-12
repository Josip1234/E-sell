package sell.test.data;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import sell.sellers.Sellers;

public interface UserPassword {
boolean saveTestData(Map<String, Sellers> data,Sellers sellers);
//data will be read with swing desktop interface
String readData(String file) throws IOException;
void readUserPasswordByDesktopApplication(File file);
boolean saveToFile(String fileName);
}
