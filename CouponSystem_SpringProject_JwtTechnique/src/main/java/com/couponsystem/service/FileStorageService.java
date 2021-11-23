package com.couponsystem.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

	private Path fileStoragePath;

//	saves the file
	public String storeFile(MultipartFile file) {
		
		String fileName = file.getOriginalFilename();
		
		if (fileName.contains("..")) {
			throw new RuntimeException("file name contains ilegal characters");
		}
		
		// copy the file to the destination directory (if already exists replace)
		try {
			Path targetLocation = this.fileStoragePath.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			return fileName;
		} catch (IOException e) {
			throw new RuntimeException("Storing file " + fileName + " failed", e);
		}
	}

//	deletes the file
	public void deleteFile(String imageName) {

		try {
			Path targetLocation = this.fileStoragePath.resolve(imageName);
			Files.delete(targetLocation);
		} catch (IOException e) {
			throw new RuntimeException("Deleting file " + imageName + " failed", e);
		}
	}
}