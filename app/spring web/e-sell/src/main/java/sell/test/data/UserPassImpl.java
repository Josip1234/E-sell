package sell.test.data;

import java.io.File;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.javafaker.Faker;

import lombok.NoArgsConstructor;
import sell.sellers.Sellers;

@NoArgsConstructor
public class UserPassImpl implements UserPassword{

	@Override
	public boolean saveTestData(Map<String, Sellers> data,Sellers sellers) {
		JSONArray data_array=createJsonArray(data, sellers);
		System.out.println(data_array);
	   
	   
	   
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
