package teamWeb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import teamWeb.FileProperties;
import teamWeb.service.FileService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
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

    @Override
    public String saveFile(MultipartFile multipartFile,String fileLocalPath) {
        String originName = multipartFile.getOriginalFilename();
        String format=sdf.format(new Date());
        String realPath = filePath.toString() +"/"+ fileLocalPath;
        File folder = new File(realPath);
        String newName = UUID.randomUUID().toString() +format+"."+ originName.split("\\.")[1];
        try {
            File result = new File(folder,newName);
            multipartFile.transferTo(result);
            return result.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}