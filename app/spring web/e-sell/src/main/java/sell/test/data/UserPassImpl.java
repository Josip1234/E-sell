package sell.test.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
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
	public String readData(String file) throws IOException {
		String values="";

	    if(file.equals("")) {
			String deafultPath="C:/Users/Korisnik/Desktop/xampp/htdocs/E-sell/files/testuserusernamesandpasswords.txt";
			values=reading(values, deafultPath);
			String backup="C:/Users/Korisnik/Desktop/xampp/htdocs/E-sell/files/testuserusernamesandpasswords_bak.txt";
			makeBackup(deafultPath, backup);
		} else {
	    	values=reading(values, file);
	    }
		return values;
	}
	
	public String reading(String val,String deafultPath){
	      BufferedReader reader;
	        try {
				reader= new BufferedReader(new FileReader(deafultPath));
				String line=reader.readLine();
				while(line != null) {

					line=reader.readLine();
					     
						val+=line+"\n";
				
		
				}
				reader.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        val.replace("null", "");
	    	return val;
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


	@Override
	public boolean saveToFile(String fileName,String whatToSave) {
		boolean saved=false;
		 FileWriter fw;
		try {
			fw = new FileWriter(fileName, true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    //bw.write("\n");
		    bw.write(whatToSave);
		    bw.newLine();
		    bw.close();
		    saved=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return saved;
	}


	@Override
	public boolean makeBackup(String fileLocation, String fileBackupName) {
		boolean done=false;
		File copied=new File(fileBackupName);
		try {
			FileUtils.copyFile(new File(fileLocation), copied);
			done=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return done;
	}


	@Override
	public boolean fileRestore(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

}
