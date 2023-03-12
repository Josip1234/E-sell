package sell.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;
import sell.articles.Articles;
import sell.sellers.Sellers;
import sell.test.data.UserPassImpl;

/***
 * Class for creating new folder of user and article
 * @author Josip Bošnjak
 *
 */

@Data
@NoArgsConstructor
public class Folder implements CreateFolders {
	//variale to check if folder has been made
   private boolean done;
   //variable for storing folder name
   private String folderName;
   //file object for opening or closing stream 
   private File file;
   //varialble to store default path
   private String defaultPath="images/";
   //variable for checking if file exists
   private boolean doesExists;
  
  /***
   * Makes new file stream with default path variable plus folder name concatination. 
   * @param folderName
   * @author Josip Bošnjak
   */
   public Folder(String folderName) {
	   this.file=new File(defaultPath+folderName);
	   this.folderName=defaultPath+folderName;
   }
   /***
    * Makes new file stream if path does not have default defined path.
    * @param path
    * @param folderName
    * @author Josip Bošnjak
    */
   public Folder(String path, String folderName) {
	   this.file=new File(path+folderName);
	   this.folderName=folderName;
   }
   
   /***
    * Set folder name, remove default path name
    * @param nameOfFolder
    */
   public void setFolder(String nameOfFolder) {
	   this.folderName=nameOfFolder;
	   this.defaultPath="";
	   this.file=new File(this.folderName);
	   
   }
   
   /***
    * Creates a new folder depending of object. If object is seller, it creates new folder with seller nickname.
    * Seller nickname is unique, so it is allowed. 
    * @param object - seller or article object
    * @return - it should return boolean, i dont know why is returning non existing function. need to debug it.
    * @author Josip Bošnjak
    */
	public boolean createFolder(Object object) {
		//if object is instance of seller create seller folder else create article folder.
	   if(object instanceof Sellers) {
		   //convert object to sellers
		   Sellers sellers = (Sellers) object;
		   //make new folder object. It contains default path. We are opening new file stream with it.
		   Folder folder=new Folder(sellers.getNickname());
		   //Call function for making a directory. Will return true if it successfull and boolean variable done will be set to true. If
		   //it is not it will be set to false.
		   setDone(makeDirectory(folder));
	   }else if(object instanceof Articles) {
		   //convert object to articles
		   Articles articles = (Articles) object;
		   //create new folder object with default path. Get seller, concatinate article number. This is the path from
		   //seller, which is logged in user, and article number, name of the folder to create.
		   Folder folder2 = new Folder(getDefaultPath()+articles.getSeller()+"/",articles.getArticle_number().toString());
		   //System.out.println(folder2.getFolderName());
		   //set true if directory is made.
		   setDone(makeDirectory(folder2));
	   }else if(object instanceof Folder) {
	        Folder folder3=(Folder) object;
	        setDone(makeDirectory(folder3));
		   
	   }else {
		   //System.out.println("Define what to do if any other object is present.");
	   }
		
	
		return isDone();
	}
   
   /***
    * @param folder - get folder object
    * @return true if folder has been made, false if it is not
    * @author Josip Bošnjak
    */
   public boolean makeDirectory(Folder folder) {
	   //check if file exists. If exists, set done variable to false. 
	   //else get object file stream and use mkdir to create new folder
	   //if directory has ben made set boolean done variable to true. Else set it to false
		if(doesFileExists(folder)) {
			setDone(false);
		}else {
		    setDone(folder.getFile().mkdir());
		  
		    if(isDone()) {
		    	setDone(true);
		    }else {
		    	setDone(false);
		    }
		}
       return isDone();
   }
 
   /***
    * THis function recieves folder object. Checks if file exists and returns true or false
    * @param folder
    * @return true if folder already exists, false if not.
    * @author Josip Bošnjak
    */
	public boolean doesFileExists(Folder folder) {
		if(folder.getFile().exists()) {
			setDoesExists(true);
		}else {
			setDoesExists(false);
		}
		return isDoesExists();
	}
@Override
public boolean saveApplicationPropertiesFile(List<String> fileDataValues, ApplicationProperties applicationProperties) {
    setFolder(fileDataValues.get(0));
    setFile(new File(getFolderName()+fileDataValues.get(1)));
    FileWriter fw;
	try {
		fw = new FileWriter(fileDataValues.get(1));
	    BufferedWriter bw = new BufferedWriter(fw);
	    //bw.write("\n");
	    bw.write(applicationProperties.toString().replace("{", "").replace("}", ""));

	    bw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return done;
}

}
