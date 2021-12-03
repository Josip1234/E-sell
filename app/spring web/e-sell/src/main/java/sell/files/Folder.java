package sell.files;

import java.io.File;
import lombok.Data;
import lombok.NoArgsConstructor;
import sell.articles.Articles;
import sell.sellers.Sellers;
@Data
@NoArgsConstructor
public class Folder {
   private boolean done;
   private String folderName;
   private File file;
   private String defaultPath="src/main/resources/static/images/";
   private boolean doesExists;
  
   
   public Folder(String folderName) {
	   this.file=new File(defaultPath+folderName);
	   this.folderName=defaultPath+folderName;
   }
   
   public Folder(String path, String folderName) {
	   this.file=new File(path+folderName);
	   this.folderName=folderName;
   }
   
   
	public boolean createFolder(Object object) {
	   if(object instanceof Sellers) {
		   
		   Sellers sellers = (Sellers) object;
		   Folder folder=new Folder(sellers.getNickname());
		   setDone(makeDirectory(folder));
	   }else if(object instanceof Articles) {
		   Articles articles = (Articles) object;
		   Folder folder2 = new Folder(getDefaultPath()+articles.getSeller()+"/",articles.getArticle_number().toString());
		   System.out.println(folder2.getFolderName());
		   setDone(makeDirectory(folder2));
	   }else {
		   System.out.println("Define what to do if any other object is present.");
	   }
		
	
		return isDone();
	}
   
   
   public boolean makeDirectory(Folder folder) {
	
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

	public boolean doesFileExists(Folder folder) {
		if(folder.getFile().exists()) {
			setDoesExists(true);
		}else {
			setDoesExists(false);
		}
		return isDoesExists();
	}
}
