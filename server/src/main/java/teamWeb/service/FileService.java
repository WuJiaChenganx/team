package teamWeb.service;

import org.springframework.core.io.Resource;

public interface FileService {
    Resource loadFileAsResource(String fileName);

}
