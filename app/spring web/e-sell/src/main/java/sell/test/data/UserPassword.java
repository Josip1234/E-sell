package sell.test.data;

import java.io.File;
import java.util.Map;

import sell.sellers.Sellers;

public interface UserPassword {
boolean saveTestData(Map<Integer, Sellers> data);
//data will be read with swing desktop interface
void readData(File file);
void readUserPasswordByDesktopApplication(File file);
}
