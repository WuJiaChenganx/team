package teamWeb.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

import java.io.File;
import java.io.IOException;

@Component
public class Address {

    public static String rootAddress(){
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "http://121.43.183.119:6250/";
    }
}
