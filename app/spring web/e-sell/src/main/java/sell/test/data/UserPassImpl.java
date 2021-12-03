package sell.test.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import lombok.NoArgsConstructor;
import sell.sellers.Sellers;

@NoArgsConstructor
public class UserPassImpl implements UserPassword{

	@Override
	public boolean saveTestData(Map<String, Sellers> data,Sellers sellers) {
		JSONArray data_array=createJsonArray(data, sellers);
		System.out.println(data_array);
	   
		  try (FileWriter file = new FileWriter("src/main/resources/static/test-data.json")) {
	            //We can write any JSONArray or JSONObject instance to the file
	            file.write(data_array.toString()); 
	         
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	   
	   
		return false;
	}

	@Override
	public void readData(File file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readUserPasswordByDesktopApplication(File file) {
		// TODO Auto-generated method stub
		
	}
	public JSONArray createJsonArray(Map<String, Sellers> data,Sellers sellers) {
		JSONArray field= new JSONArray();
	   JSONObject jsonObject=new JSONObject(data);
	   field.put(jsonObject);
	   return field;
	}

}
