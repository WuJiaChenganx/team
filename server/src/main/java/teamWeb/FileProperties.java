package teamWeb;

import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

//@EnableAsync
@ConfigurationProperties(prefix = "file")
@Data
public class FileProperties {
    private String docDir;
}
