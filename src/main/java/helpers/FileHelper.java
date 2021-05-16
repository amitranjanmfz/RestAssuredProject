package helpers;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileHelper {

    public static String readFile(String fileName) {
        try{
            return FileUtils.readFileToString(getResources(fileName),"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public  static File getResources(String filename){
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return new File(classLoader.getResource(filename).getFile());
    }
}
