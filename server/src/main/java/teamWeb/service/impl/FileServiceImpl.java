package teamWeb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import teamWeb.FileProperties;
import teamWeb.service.FileService;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {
    private final Path filePath;
    @Autowired
    public FileServiceImpl(FileProperties fileProperties) {
        filePath = Paths.get(fileProperties.getDocDir()).toAbsolutePath().normalize();
    }
    @Override
    public String loadFileAsResource(String fileName) {
        String path = filePath.resolve(fileName).normalize().toString();

        return path;
    }
}