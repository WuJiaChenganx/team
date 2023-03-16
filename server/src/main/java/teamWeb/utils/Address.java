package teamWeb.utils;

import java.io.File;

import java.io.File;
import java.io.IOException;

public class Address {
    public static String rootAddress(){
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return courseFile+"\\";
    }
}
