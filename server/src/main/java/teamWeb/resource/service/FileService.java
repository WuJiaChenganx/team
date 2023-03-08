package teamWeb.resource.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface FileService {
    String loadFileAsResource(String fileName);
    String saveFile(MultipartFile multipartFile,String filePath);
}
