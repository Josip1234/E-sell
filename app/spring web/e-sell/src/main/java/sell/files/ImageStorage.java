package sell.files;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;




@Service
public class ImageStorage implements ImageStorageService {
	private final Path fileLocation;
	
	
	@Autowired
	public ImageStorage(StorageSettings settings) {
		
		this.fileLocation = Paths.get(settings.getLocation());
	}

	@Override
	public void storeFile(String nickname,String article_number,MultipartFile fileName) {
		try {
			if(fileName.isEmpty()) {
				throw new StorageException("Failed to store empty file.");
			}
			Path destinationFile=this.fileLocation.resolve(Paths.get(nickname+"//"+article_number+"//"+fileName.getOriginalFilename())).normalize().toAbsolutePath();
			StorageSettings settings= new StorageSettings();
			settings.setLocation(destinationFile.toString());
		    //System.out.println(destinationFile.toString());
			
			try(InputStream inputStream = fileName.getInputStream()) {
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
			}
		}
			
		 catch (IOException e) {
            throw new StorageException("Failed to store file.",e);			
		}

	}

	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.fileLocation, 1).filter(path->!path.equals(this.fileLocation)).map(this.fileLocation::relativize);
		} catch (IOException e) {
			throw new StorageException("Failed to read stored files",e);
		}
	}

	@Override
	public Path load(String fileName) {
	
		return fileLocation.resolve(fileName);
	}

	@Override
	public Resource loadAsResource(String fileName) {
		try {
			Path file=load(fileName);
			Resource resource= new UrlResource(file.toUri());
			if(resource.exists() || resource.isReadable()) {
				return resource;
			}
			else {
				throw new StorageFileNotFoundException("Coould not read file:"+fileName);
			}
		} catch (MalformedURLException e) {
		
			throw new StorageFileNotFoundException("Could not read file: " + fileName, e);
		}
	}

	@Override
	public void init() {
		try {
			Files.createDirectories(fileLocation);
			Folder folder=new Folder();
			folder.setFolder("logos");
			folder.createFolder(folder);
		} catch (IOException e) {
			throw new StorageException("Could not initialize storage",e);
		}
		
		
	}

}
