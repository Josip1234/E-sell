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
	public void storeFile(MultipartFile fileName) {
		try {
			if(fileName.isEmpty()) {
				throw new StorageException("Failed to store empty file.");
			}
			Path destinationFile=this.fileLocation.resolve(Paths.get(fileName.getOriginalFilename())).normalize().toAbsolutePath();
		
			if(!destinationFile.getParent().equals(this.fileLocation.toAbsolutePath())){
				//security check
				throw new StorageException("Cannot store file outside current directory.");
			}
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
		} catch (IOException e) {
			throw new StorageException("Could not initialize storage",e);
		}
		
		
	}

}
