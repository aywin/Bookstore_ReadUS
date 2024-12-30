package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStorageService {

    private final String uploadDir = "C:/uploads/"; // Chemin absolu pour les fichiers

    public String saveFile(MultipartFile file) throws IOException {
        // Vérifiez si le répertoire existe, sinon créez-le
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Créez un chemin unique pour le fichier
        String filePath = uploadDir + System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File destinationFile = new File(filePath);

        // Sauvegardez le fichier
        file.transferTo(destinationFile);

        return filePath;
    }
}
